package bateman.bach.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by spencer on 3/29/16.
 */
public enum Roman {
  I, II, III, IV, V, VI, VII,
  i, ii, iii, iv, v, vi, vii,
  Isus2, v7, bVII;

  public List<Roman> getScaleDegree() {
    List scaledegrees = new ArrayList<>();

    switch (this) {
      case I: scaledegrees.add(1);
              scaledegrees.add(5);
              scaledegrees.add(8);
              break;

      case i: scaledegrees.add(1);
              scaledegrees.add(4);
              scaledegrees.add(8);
              break;

      case II: scaledegrees.add(3);
               scaledegrees.add(7);
               scaledegrees.add(10);
               break;

      case ii: scaledegrees.add(3);
               scaledegrees.add(6);
               scaledegrees.add(10);
               break;

      case III: scaledegrees.add(5);
                scaledegrees.add(9);
                scaledegrees.add(12);
                break;

      case iii: scaledegrees.add(5);
                scaledegrees.add(8);
                scaledegrees.add(12);
                break;

      case IV: scaledegrees.add(6);
               scaledegrees.add(10);
               scaledegrees.add(12);
               break;

      case iv: scaledegrees.add(6);
               scaledegrees.add(9);
               scaledegrees.add(12);
               break;

      case V: scaledegrees.add(8);
              scaledegrees.add(11);
              scaledegrees.add(3);
              break;

      case v: scaledegrees.add(8);
              scaledegrees.add(10);
              scaledegrees.add(3);
              break;

      case VI: scaledegrees.add(10);
               scaledegrees.add(2);
               scaledegrees.add(5);
               break;

      case vi: scaledegrees.add(10);
               scaledegrees.add(1);
               scaledegrees.add(5);
               break;

      case VII: scaledegrees.add(11);
                scaledegrees.add(4);
                scaledegrees.add(7);
                break;

      case vii: scaledegrees.add(11);
                scaledegrees.add(3);
                scaledegrees.add(7);
                break;



      case Isus2: scaledegrees.add(1);
                  scaledegrees.add(3);
                  scaledegrees.add(8);
                  break;

      case v7: scaledegrees.add(8);
               scaledegrees.add(10);
               scaledegrees.add(3);
               scaledegrees.add(5);
               break;

      case bVII: scaledegrees.add(10);
                 scaledegrees.add(3);
                 scaledegrees.add(6);
                 break;



    }
    return scaledegrees;
  }
}
