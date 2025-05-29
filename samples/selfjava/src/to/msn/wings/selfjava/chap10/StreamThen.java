package to.msn.wings.selfjava.chap10;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamThen {

  public static void main(String[] args) {
    System.out.println(
        Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
          .sorted()
          .collect(
            Collectors.collectingAndThen(
              Collectors.toList(),
              Collections::unmodifiableList
            )
          )
      );
  }
}
