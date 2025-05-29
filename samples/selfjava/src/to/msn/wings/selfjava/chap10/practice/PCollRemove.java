package to.msn.wings.selfjava.chap10.practice;

import java.util.ArrayList;
import java.util.List;

public class PCollRemove {

  public static void main(String[] args) {
    var list = new ArrayList<String>(
        List.of("シュークリーム", "エクレア", "マドレーヌ", "ババロア"));
      list.removeIf(v -> v.length() < 5);
      System.out.println(list);
  }
}
