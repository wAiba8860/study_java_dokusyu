package to.msn.wings.selfjava.chap07.argument;

public class ArgsOverload {
  void hoge(int x, int y) {
    System.out.println("int_x_y");
  }

  void hoge(int... x) {
    System.out.println("int...");
  }

  // void hoge(int[] x) {
  //   System.out.println("int[]");
  // }
}
