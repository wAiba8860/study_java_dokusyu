package to.msn.wings.selfjava.chap10;

import java.util.stream.IntStream;

public class StreamRange {

  public static void main(String[] args) {
    IntStream.range(10, 20)
      .forEach(System.out::println);

//    IntStream.rangeClosed(10, 20)
//      .forEach(System.out::println);
  }
}
