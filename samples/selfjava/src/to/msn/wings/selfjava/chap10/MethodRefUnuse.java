package to.msn.wings.selfjava.chap10;

public class MethodRefUnuse {
  public void walkArray(String[] data) {
    for (var value : data) {
      System.out.printf("[%s]\n", value);
    }
  }
}
