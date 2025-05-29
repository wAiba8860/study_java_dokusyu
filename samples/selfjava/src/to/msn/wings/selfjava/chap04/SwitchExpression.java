package to.msn.wings.selfjava.chap04;

public class SwitchExpression {
  public static void main(String[] args) {
    String str = "";
    // String str = "Hoge";
    System.out.println(switch(str) {
      case "Hoge" -> "ほげ";
      case null, default, "" -> "無効";
    });
  }
}
