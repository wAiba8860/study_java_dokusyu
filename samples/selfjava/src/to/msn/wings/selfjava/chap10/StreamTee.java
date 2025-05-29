package to.msn.wings.selfjava.chap10;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTee {
  public static void main(String[] args) {
    var result = Stream.of("Java", "Python", "C#", "JavaScript")
  .collect(
    Collectors.teeing(
      Collectors.joining(","),
      Collectors.joining("\t"),
      (r1, r2) -> {
        return Map.of(
          "comma", r1,
          "tab", r2
        );
      }
    )
  );

System.out.println(result.get("comma"));
System.out.println(result.get("tab"));
  }
}
