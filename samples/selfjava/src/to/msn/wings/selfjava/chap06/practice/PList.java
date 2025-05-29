package to.msn.wings.selfjava.chap06.practice;

import java.util.ArrayList;
import java.util.List;

public class PList {

  public static void main(String[] args) {
    var list = new ArrayList<Integer>(List.of(10, 15, 30));
    var list2 = new ArrayList<Integer>(List.of(60 ,90));
    list.remove(0);
    list.set(1, 20);
    list.addAll(2, list2);
    for (var i : list) {
      System.out.println(i);
    }
  }
}
