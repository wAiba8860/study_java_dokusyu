package to.msn.wings.selfjava.chap10;

import java.util.ArrayList;
import java.util.List;

public class CollReplace {

  public static void main(String[] args) {
    var list = new ArrayList<String>(
      List.of("バラ", "チューリップ", "あさがお"));
    list.replaceAll(v -> {
      if (v.length() < 3) {
        return v;
      } else {
        return v.substring(0, 3);
      }
    });
    System.out.println(list);
  }
}
