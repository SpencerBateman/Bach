import bateman.bach.model.Roman;
import bateman.bach.model.Seed;
import bateman.bach.model.SeedImpl;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by spencer on 3/28/16.
 */

public final class BasicMarkov {
  public static void main(String[] args) {

    Seed s = new SeedImpl("isthisit.txt");



    //System.out.println(s.getProgression());
    //System.out.println(s.getChords());





    /// TESTING TO SEE IF THE ARRAY POPULATES CORRECTLY
    double[][] a = s.getMarkov();
    String aString = "";
    for (int row = 0; row < a.length; row++) {
      if (a[row] != null && a[row].length > 0) {
        aString = aString + a[row][0];

        for (int column = 1; column < a[row].length; column++) {
          aString = aString + " " + a[row][column];
        }
      }
      aString = aString + "\n";
    }

    //System.out.println(aString);


    List map = s.getChords();
    List song = new ArrayList<>();

    double[][] markovMatrix = s.getMarkov();


    // The seed for generating output
    int seed = 2; // Chcking that our map says 64 is at index 2

    //The output as an index value
    int output = 0; //there are no outputs yet

    song.add(s.getChords().get(seed));


    //Generate notes and add them to a phrase
    for (int i = 0; i < 200; i++) {

      //Retrieve a random number between 0.0 and 1.0
      double choice = Math.random();

      //The current sum of weighting left to right
      double currentSum = 0.0;

      // Check matrix left to right
      for (;output < markovMatrix.length; output++) {


        currentSum += markovMatrix[seed][output];


        if (choice <= currentSum) {
          break; // break when we've chosen right number
        }


        //System.out.print(choice);

      }

      song.add(map.get(output));

      //Change the seed to equal the output
      seed = output;

      //Reset the output for the next pass
      output = 0;
    }


    System.out.print("\n");
    System.out.println(song);








    /**
    // A map for our musical pitches
    int[] map = {65, 67, 69, 70, 72, 74, 64};

    // A multidimensional array representing our markov matrix
    double[][] markovMatrix = {
            {.21, .31, 0, 0, 0, 0, .46},
            {.78, .07, .02, .05, .05, 0, 0},
            {.33, .66, 0, 0, 0, 0, 0},
            {0, .125, .625, .25, 0, 0, 0},
            {0, 0, 0, .33, .66, 0, 0},
            {0, 0, 0, 0, 0, 0, 1},
            {.79, .06, 0, 0, 0, .13, 0}};

    // The seed for generating output
    int seed = 2; // Chcking that our map says 64 is at index 2

    //The output as an index value
    int output = 0; //there are no outputs yet

    // Score, part and phrase to contain the output
    Score scr = new Score();
    Part part = new Part();
    Phrase phrase = new Phrase();

    // Add the seed note to the phrase first
    Note n = new Note();
    n.setPitch(map[seed]);
    phrase.add(n);

    //Generate notes and add them to a phrase
    for (int i = 0; i < 15; i++) {

      //Retrieve a random number between 0.0 and 1.0
      double choice = Math.random();

      //The current sum of weighting left to right
      double currentSum = 0.0;

      // Check matrix left to right
      for (;output < markovMatrix.length; output++) {


        currentSum += markovMatrix[seed][output];


        if (choice <= currentSum) {
          break; // break when we've chosen right number
        }


        System.out.print(choice);
      }
      Note note = new Note();
      note.setPitch(map[output]);
      phrase.addNote(note);

      //Change the seed to equal the output
      seed = output;

      //Reset the output for the next pass
      output = 0;
    }
    part.addPhrase(phrase);
    scr.addPart(part);
    Write.midi(scr, "basic_markov.mid");

     */
  }


}