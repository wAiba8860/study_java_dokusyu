package to.msn.wings.selfjava.chap10;

public class MethodRefUnuseBasic {

  public static void main(String[] args) {
    var data = new String[] { "春はあけぼの", "夏は夜", "秋は夕暮れ" };
    var un = new MethodRefUnuse();
    un.walkArray(data);
  }
}
