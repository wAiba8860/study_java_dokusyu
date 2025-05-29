package to.msn.wings.selfjava.chap03;

public class Shortcut {

  public static void main(String[] args) {
    String str = null;
    // String str = "https://wings.msn.to/";

    if (str != null && str.startsWith("https://")) {
      System.out.println("「https://～」で始まります。");
    }

    // startsWithメソッドだけを呼び出す場合
    // if(str.startsWith("https://")) {
    //   System.out.println("「https://～」で始まります。");
    // }

    // &&→ & にした場合
    // if(str != null & str.startsWith("http://")) {
    //   System.out.println("「https://～」で始まります。");
    // }
  }
}
