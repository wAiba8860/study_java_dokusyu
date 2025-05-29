package to.msn.wings.selfjava.chap07.argument;

public class ParamRefArray {
  public int[] update(int[] data) {
    data = new int[] { 10, 20, 30 };
    return data;
  }
}
