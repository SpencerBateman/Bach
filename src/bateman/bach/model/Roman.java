package bateman.bach.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by spencer on 3/29/16.
 */
public enum Roman {
  I, II, III, IV, V, VI, VII,
  i, ii, iii, iv, v, vi, vii;

  public List<Integer> getScaleDegree() {
    List scaledegrees = new ArrayList<>();

    switch (this) {
      case I: scaledegrees.add(1);
              scaledegrees.add(5);
              scaledegrees.add(8);
              break;

      case II: scaledegrees.add(3);
               scaledegrees.add(7);
               scaledegrees.add(10);
               break;

      case III: scaledegrees.add(5);
                scaledegrees.add(9);
                scaledegrees.add(12);
                break;

      case IV: scaledegrees.add(6);
               scaledegrees.add(10);
               scaledegrees.add(12);
               break;

    }
    return scaledegrees;
  }
}
