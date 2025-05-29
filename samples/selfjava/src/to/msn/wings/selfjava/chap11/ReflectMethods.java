package to.msn.wings.selfjava.chap11;

import java.io.File;

public class ReflectMethods {

  public static void main(String[] args) {
    var fl = File.class;
    for (var m : fl.getMethods()) {
      System.out.println(m.getName());
    }
  }
}
