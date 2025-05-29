package to.msn.wings.selfjava.chap09;

import java.util.List;

public class UnBounded {

  public static void showList(List<?> list) {
    for (var item : list) {
      System.out.println(item);
    }
    // list.add("Hoge");
    // list.add(null);
    // Object obj = list.get(0);
    // System.out.println(obj);
  }

  public static void main(String[] args) {
    var data = List.of("バラ", "ひまわり", "あさがお");
    UnBounded.showList(data);
  }
}
