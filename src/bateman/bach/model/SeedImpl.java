package bateman.bach.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    String[] str = lines.get(0).split("\\s+");


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
      }
    }

    // Populate the list of all chords used.
    this.chords = this.generateChordList();


  }

  @Override
  public List<Roman> getProgression() {
    return progression;
  }

  @Override
  public double[][] getMarkov() {
    return null;
  }

  @Override
  public List<Roman> getChords() {
    return chords;
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
