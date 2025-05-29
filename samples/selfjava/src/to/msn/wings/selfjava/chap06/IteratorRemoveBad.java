package to.msn.wings.selfjava.chap06;

import java.util.ArrayList;
import java.util.List;

public class IteratorRemoveBad {

  public static void main(String[] args) {
    var data = new ArrayList<String>(List.of("バラ", "ひまわり", "あさがお"));

    for (var s : data) {
      System.out.println(s);
      data.remove(s);
    }
  }
}
