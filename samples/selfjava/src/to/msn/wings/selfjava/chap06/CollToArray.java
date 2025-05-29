package to.msn.wings.selfjava.chap06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollToArray {

  public static void main(String[] args) {
    var data = new ArrayList<String>(List.of("バラ", "ひまわり", "あさがお"));
    var strs = new String[data.size()];
    data.toArray(strs);
    data.set(0, "チューリップ");
    System.out.println(Arrays.toString(strs));
    System.out.println(data);
  }
}
