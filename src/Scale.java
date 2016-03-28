import jm.JMC;
import jm.music.data.*;
import jm.util.*;

/**
 * Created by spencer on 3/28/16.
 */

/**
 * A short example which generates a one octave c chromatic scale
 * and writes to a MIDI file called ChromaticScale.mid
 * @author Andrew Sorensen and Andrew Brown
 */

public final class Scale implements JMC {
    public static void main(String[] args) {

      Score s = new Score("JMDemo - Scale");

      Part p = new Part("Flute", FLUTE, 0);
      Phrase phr = new Phrase("Chromatic Scale", 0.0);

      //Create the scale notes and add them to a sphrase
      for (int i = 0; i < 12; i++) {
        Note n = new Note(C4 + i, C);
        phr.add(n);

      }

      // add the phrase to a part
      p.addPhrase(phr);
      // add the part to the score
      s.add(p);


      // write a MIDI gile to disk of the score
      Write.midi(s, "ChromaticScale.mid");



    }

}
