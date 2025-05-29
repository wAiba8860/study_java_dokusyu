package to.msn.wings.selfjava.chap10;

import java.util.List;

public class StreamBasic {

  public static void main(String[] args) {
    var list = List.of("ant", "elephant", "hamster");

    list.
      stream().
      filter(s -> s.length() > 3).
      map(String::toUpperCase).
      forEach(System.out::println);
  }
}
