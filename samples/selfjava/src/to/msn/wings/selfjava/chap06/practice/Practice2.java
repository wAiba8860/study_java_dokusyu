package to.msn.wings.selfjava.chap06.practice;

import java.util.HashMap;
import java.util.Map;

public class Practice2 {

  public static void main(String[] args) {
    // var map = new HashMap<String, String>() {
    //   {
    //     put("cucumber", "キュウリ");
    //     put("lettuce", "レタス");
    //     put("spinach", "ホウレンソウ");
    //   }
    // };

    var map = new HashMap<String, String>(Map.of("cucumber",
      "キュウリ", "lettuce", "レタス", "spinach", "ホウレンソウ")
    );

    map.put("carrot", "ニンジン");
    map.remove("spinach");
    map.replace("cucumber", "胡瓜");

    for (var entry : map.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
  }
}
