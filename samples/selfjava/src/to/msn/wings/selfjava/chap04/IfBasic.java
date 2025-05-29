package to.msn.wings.selfjava.chap04;

public class IfBasic {

  public static void main(String[] args) {
    var i = 10;
    if (i == 10) {
      System.out.println("変数iは10です。");
    } else {
      System.out.println("変数iは10ではありません。");
    }

    // 条件演算子を使った場合
    // System.out.println(i == 10 ? 
    //   "変数iは10です。" : "変数iは10ではありません。");
  }
}
