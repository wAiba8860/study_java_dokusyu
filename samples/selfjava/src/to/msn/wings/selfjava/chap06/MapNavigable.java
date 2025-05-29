package to.msn.wings.selfjava.chap06;

import java.util.TreeMap;

public class MapNavigable {

  public static void main(String[] args) {
    var data = new TreeMap<String, String>() {
      {
        put("peak", "高くなる");
        put("peach", "もも");
        put("peace", "平和");
        put("piece", "1切れ");
      }
    };

    var key = "pear";

    if (data.containsKey(key)) {
      System.out.println(key + "は" + data.get(key) + "です。");
    } else {
      System.out.print("検索中の単語は");
      System.out.print(data.lowerKey(key) + "または");
      System.out.print(data.higherKey(key));
      System.out.println("ですか？");
    }
  }
}
