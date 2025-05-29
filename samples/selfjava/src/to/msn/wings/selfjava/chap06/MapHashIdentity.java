package to.msn.wings.selfjava.chap06;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class MapHashIdentity {

  public static void main(String[] args) {
    var key1 = Integer.valueOf(256);
    var key2 = Integer.valueOf(256);

    var data = new HashMap<Integer, String>() {
    // var data = new IdentityHashMap<Integer, String>() {
      {
        put(key1, "Hoge");
        put(key2, "Foo");
      }
    };
    System.out.println(data);
  }
}
