package to.msn.wings.selfjava.chap06;

import java.util.ArrayList;
import java.util.List;

public class IteratorList {

  public static void main(String[] args) {
    var data = new ArrayList<String>(List.of("バラ", "ひまわり", "あさがお"));
    var ite = data.listIterator(data.size());
    while (ite.hasPrevious()) {
      System.out.println(ite.previous());
    }
  }
}
