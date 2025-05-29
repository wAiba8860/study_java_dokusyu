package to.msn.wings.selfjava.chap10;

import java.util.stream.IntStream;

public class StreamBoxed {

  public static void main(String[] args) {
    IntStream.range(1, 5)
      .boxed()
      .forEach(System.out::println);

    IntStream.range(1, 5)
      .mapToObj(Integer::valueOf)
      .forEach(System.out::println);
  }
}
