package to.msn.wings.selfjava.chap06;

import java.util.List;
import java.util.TreeSet;

public class SetTree {

  public static void main(String[] args) {
    var ts = new TreeSet<Integer>(List.of(1, 20, 30, 10, 60, 15));
    System.out.println(ts);
    System.out.println(ts.descendingSet());
    System.out.println(ts.ceiling(15));
    System.out.println(ts.lower(15));
    System.out.println(ts.tailSet(15));
    System.out.println(ts.headSet(30, true));
  }
}
