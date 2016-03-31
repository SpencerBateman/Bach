package bateman.bach.model;

import java.util.List;

/**
 * Created by spencer on 3/30/16.
 */
public interface Seed{

  List<Roman> getProgression();

  double[][] getMarkov();

  List<Roman> getChords();

}
