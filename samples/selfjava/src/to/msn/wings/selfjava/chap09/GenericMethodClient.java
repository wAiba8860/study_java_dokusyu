package to.msn.wings.selfjava.chap09;

import java.util.Collections;

public class GenericMethodClient {
  public static void main(String[] args) {
    System.out.println(Collections.singletonList("WINGS"));

    var list = Collections.<String>emptyList();
    System.out.println(list);
  }
}
