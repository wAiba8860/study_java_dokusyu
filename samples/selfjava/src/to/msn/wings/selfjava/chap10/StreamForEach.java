package to.msn.wings.selfjava.chap10;

import java.util.stream.Stream;

public class StreamForEach {

  public static void main(String[] args) {
    Stream.of("バラ", "あさがお", "チューリップ", "さくら")
    .forEach(v -> System.out.println(v));

    // .parallel()
    // .forEach(v -> System.out.println(v));

    // .parallel()
    // .forEachOrdered(v -> System.out.println(v));
  }
}
