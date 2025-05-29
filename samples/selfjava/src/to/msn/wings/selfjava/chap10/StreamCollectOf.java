package to.msn.wings.selfjava.chap10;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StreamCollectOf {

  public static void main(String[] args) {
    System.out.println(
      Stream.of("バラ", "あさがお", "チューリップ", "さくら")
        .sorted()
        .collect(
          Collector.of(
            ArrayList<String>::new,
            (list, str) -> list.add(str),
            (list1, list2) -> {
              list1.addAll(list2);
              return list1;
            },
            Collector.Characteristics.IDENTITY_FINISH
          )
        )
    );
  }
}
