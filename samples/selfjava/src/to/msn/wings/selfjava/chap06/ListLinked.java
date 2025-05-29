package to.msn.wings.selfjava.chap06;

import java.util.LinkedList;
import java.util.List;

public class ListLinked {

  public static void main(String[] args) {
    var list = new LinkedList<String>(List.of("うさぎ", "たつ", "へび"));
    System.out.println(list);

    list.addFirst("とら");
    list.addLast("うま");
    System.out.println(list);
    System.out.println(list.getFirst());
    System.out.println(list.getLast());
    System.out.println(list.removeFirst());
    System.out.println(list.removeLast());
    System.out.println(list);
  }
}
