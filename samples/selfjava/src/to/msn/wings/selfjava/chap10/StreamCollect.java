package to.msn.wings.selfjava.chap10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamCollect {

  public static void main(String[] args) {
    System.out.println(
      Stream.of("バラ", "あさがお", "チューリップ", "さくら")
        .sorted()
        .collect(
          ArrayList<String>::new,
          (list, str) -> list.add(str),
          (list1, list2) -> list1.addAll(list2)
        )

        // .collect(
        //     ArrayList<String>::new,
        //     List::add,
        //     List::addAll
        //   )
    );
  }
}
