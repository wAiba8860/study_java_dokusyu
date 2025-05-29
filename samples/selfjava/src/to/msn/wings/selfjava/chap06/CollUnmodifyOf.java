package to.msn.wings.selfjava.chap06;

import java.util.List;
import java.util.Map;

public class CollUnmodifyOf {

  public static void main(String[] args) {
    var data = List.of("バラ", "ひまわり", "あさがお");
    System.out.println(data);

    var map = Map.of("Rose", "バラ",
    "Sunflower", "ひまわり", "Morning Glory", "あさがお");
    System.out.println(map);
  }
}
