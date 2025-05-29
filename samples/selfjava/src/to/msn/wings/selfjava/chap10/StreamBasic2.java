package to.msn.wings.selfjava.chap10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StreamBasic2 {

  public static void main(String[] args) {
    var list = List.of("ant", "elephant", "hamster");
    list.stream().forEach(System.out::println);
    // list.parallelStream().forEach(System.out::println);
    System.out.println("---------------");

    var data = new String[] { "バラ", "あさがお", "チューリップ" };
    Arrays.stream(data).forEach(System.out::println);
    System.out.println("---------------");

    var map = Map.of("orange", "みかん", "apple", "りんご", "strawberry", "いちご");

    map.entrySet().stream().forEach(System.out::println);
  }
}
