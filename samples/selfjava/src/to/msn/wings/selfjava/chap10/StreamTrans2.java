package to.msn.wings.selfjava.chap10;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTrans2 {

  public static void main(String[] args) {
    var list = Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
        .filter(s -> s.startsWith("さ"))
        .collect(Collectors.toList());
        // .toList();
    System.out.println(list);
  }
}
