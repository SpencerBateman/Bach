package bateman.bach.model;

import com.sun.tools.javac.util.ArrayUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * Created by spencer on 3/30/16.
 */
public class SeedImpl implements Seed {

  private List<Roman> progression = new ArrayList<>();
  private List<Roman> chords = new ArrayList<>();

  /**
   * Constructor
   * @param path the path to the .txt file with the training information
   */
  public SeedImpl(String path) {

    // So this is null right now so watch out
    List<String> lines = null;


    try {
      lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

    } catch (IOException e) {
      e.printStackTrace();
    }

    String[] a = new String[0];

    for (int i = 0; i < lines.size(); i++) {
      String[] test = lines.get(i).split("\\s+");

      String[] str = new String[a.length + test.length];
      System.arraycopy(a, 0, str, 0, a.length);
      System.arraycopy(test, 0, str, a.length, test.length);
      a = str;

    }

    String[] str = a;


    /**
     * This is essentially String to Romans I don't know a better way to do this so this is what
     * I am going with for now. If there is a solution like extending the String class then
     * maybe that's what I am going to go with.
     */
    for (int i = 0; i < str.length; i++) {

      switch (str[i]) {
        case "i":
          progression.add(Roman.i);
          break;
        case "I":
          progression.add(Roman.I);
          break;
        case "ii":
          progression.add(Roman.ii);
          break;
        case "II":
          progression.add(Roman.II);
          break;
        case "iii":
          progression.add(Roman.iii);
          break;
        case "III":
          progression.add(Roman.III);
          break;
        case "iv":
          progression.add(Roman.iv);
          break;
        case "IV":
          progression.add(Roman.IV);
          break;
        case "v":
          progression.add(Roman.v);
          break;
        case "V":
          progression.add(Roman.V);
          break;
        case "vi":
          progression.add(Roman.vi);
          break;
        case "VI":
          progression.add(Roman.VI);
          break;
        case "vii":
          progression.add(Roman.vii);
          break;
        case "VII":
          progression.add(Roman.VII);
          break;
        case "Isus2":
          progression.add(Roman.Isus2);
          break;
        case "v7":
          progression.add(Roman.v7);
          break;
        case "bVII":
          progression.add(Roman.bVII);
          break;
      }
    }

    // Populate the list of all chords used.
    this.chords = this.generateChordList();


  }

  @Override
  public List<Roman> getProgression() {
    return progression;
  }

  /**
   * The each row of this array represents a chord
   * And each double in the row represents a number of times the row chord resolves to that chord.
   *
   * It is currently returning a value that for one given the size of the list of chords.
   *
   * @return
   */
  @Override
  public double[][] getRawMarkov() {
    double[][] result = new double[chords.size()][chords.size()];

    for (int a = 0; a < chords.size(); a++) {

      for (int b = 0; b < chords.size(); b++) {

        for (int c = 0; c < progression.size() - 1; c++) {
          if (progression.get(c) == chords.get(a)) {

            // There is a bug here

            Roman landingChord = progression.get(c + 1);
            result[a][chords.indexOf(landingChord)] += 1;
          }

        }
      }

    }
    return result;
  }



  @Override
  public List<Roman> getChords() {
    return chords;
  }

  @Override
  public double[][] getMarkov() {
    double[][] raw = this.getRawMarkov();
    double[][] result = new double[chords.size()][chords.size()];

    for (int i = 0; i < chords.size(); i++) {

      for (int j = 0; j < chords.size(); j++) {

        double denominator = DoubleStream.of(raw[i]).sum();

        if (!(denominator == 0.0)) {
          result[i][j] = (raw[i][j] / denominator);

        } else {
          result[i][j] = 0.0;
        }





      }

    }


    return result;
  }


  private List<Roman> generateChordList() {
    List result = new ArrayList<>();

    for (Roman r : progression) {
      if (!result.contains(r)) {
        result.add(r);
      }
    }
    return result;
  }

}
