package to.msn.wings.selfjava.chap10;

import java.util.List;

public class StreamMulti {

  public static void main(String[] args) {
    var list = List.of(
      List.of("あいう", "かきく", "さしす"),
      List.of("たちつ", "なにぬ"),
      List.of("はひふ", "まみむ"));
    list.stream()
      .<String>mapMulti((sublist, consumer) -> {
        for (var str : sublist) {
          consumer.accept(str);
        }
      })
      .forEach(System.out::println);
  }
}
