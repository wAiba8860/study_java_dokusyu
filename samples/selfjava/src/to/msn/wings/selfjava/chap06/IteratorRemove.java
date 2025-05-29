package to.msn.wings.selfjava.chap06;

import java.util.ArrayList;
import java.util.List;

public class IteratorRemove {

  public static void main(String[] args) {
    var data = new ArrayList<String>(List.of("バラ", "ひまわり", "あさがお"));
    var ite = data.iterator();
    while (ite.hasNext()) {
      System.out.println(ite.next());
      ite.remove();
    }
    System.out.println(data);
  }
}
