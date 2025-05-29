package to.msn.wings.selfjava.chap06;

import java.util.ArrayList;
import java.util.Collections;

public class CollUnmodify {

  public static void main(String[] args) {
    var data = new ArrayList<String>() {
      {
        add("バラ");
        add("ひまわり");
        add("あさがお");
      }
    };
    var udata = Collections.unmodifiableList(data);
    udata.set(0, "チューリップ");
    udata.add("さくら");
  }
}
