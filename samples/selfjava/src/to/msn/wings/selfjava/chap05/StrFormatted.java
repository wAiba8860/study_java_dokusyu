package to.msn.wings.selfjava.chap05;

public class StrFormatted {
  public static void main(String[] args) {
    var str = "名前は%1$s、%3$d歳です。%1$sは、元気です。";
    System.out.println(str.formatted("サクラ", "女の子", 1));
  }
}
