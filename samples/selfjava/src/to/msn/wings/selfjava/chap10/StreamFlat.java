package to.msn.wings.selfjava.chap10;

import java.util.List;

public class StreamFlat {

  public static void main(String[] args) {
    var list = List.of(
      List.of("あいう", "かきく", "さしす"),
      List.of("たちつ", "なにぬ"),
      List.of("はひふ", "まみむ")
    );
    list.stream()
      .flatMap(v -> v.stream())
      .forEach(System.out::println);

    // list.stream()
    //   .flatMap(v -> v.stream().map(str -> str.substring(0, 1)))
    //   .forEach(System.out::println);
  }
}
