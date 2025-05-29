package to.msn.wings.selfjava.chap06;

import java.util.ArrayList;
import java.util.List;

public class CollIterator {
  public static void main(String[] args) {
    var data = new ArrayList<String>(List.of("バラ", "ひまわり", "あさがお"));
    var itr = data.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }

    // for (var itr = data.iterator(); itr.hasNext(); ) {
    //   System.out.println(itr.next());
    // }
  }
}
