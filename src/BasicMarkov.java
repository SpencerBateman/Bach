import jm.JMC;
import jm.music.data.*;
import jm.util.*;
import java.util.*;


/**
 * Created by spencer on 3/28/16.
 */

/**
 * A short example which generates a one octave c chromatic scale
 * and writes to a MIDI file called ChromaticScale.mid
 * @author Andrew Sorensen and Andrew Brown
 */


public final class BasicMarkov {
  public static void main(String[] args) {
    // A map for our musical pitches
    int[] map = {63, 66, 68, 70, 73};

    // A multidimensional array representing our markov matrix
    double[][] markovMatrix = {
            {0, .66, 0, 0, .33},
            {0, 0, 1, 0, 0},
            {.5, 0, 0, .5, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0}};

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
    for (int i = 0; i < 30; i++) {

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
  }
}