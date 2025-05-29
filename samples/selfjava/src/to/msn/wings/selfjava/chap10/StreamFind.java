package to.msn.wings.selfjava.chap10;

import java.util.stream.Stream;

public class StreamFind {

  public static void main(String[] args) {
    var str = Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら", "もも")
        .filter(s -> s.startsWith("さ"))
        .findFirst();
      System.out.println(str.orElse("－"));

    // var str = Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら", "もも")
    //   .parallel()
    //   .filter(s -> s.startsWith("さ"))
    //   .findAny();
    // System.out.println(str.orElse("－"));
  }
}
