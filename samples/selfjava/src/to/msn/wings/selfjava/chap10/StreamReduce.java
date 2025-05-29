package to.msn.wings.selfjava.chap10;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamReduce {

  public static void main(String[] args) {
    System.out.println(
      Stream.of("バラ", "あさがお", "チューリップ", "さくら")
        .sorted()
        .reduce((result, str) -> result + "," + str)
        .orElse("")
    );

    // var list = new String[] { "バラ", "あさがお", "チューリップ", "さくら" };
    // Arrays.sort(list);
    // var result = "";
    // for (var str: list) {
    //   result += str + ",";
    // }
    // System.out.println(result);
  }
}
