package to.msn.wings.selfjava.chap04;

public class SwitchMatch {
  public static void main(String[] args) {
    Object obj = -123;
    // Object obj = "Wings";
    // Object obj = null;
    // Object obj = false;
    // Object obj = "";

    switch (obj) {
      case Integer i -> System.out.println(Math.abs(i));
      case String str -> System.out.println(str.substring(0, 1));
      case null -> System.out.println("nullです。");
      // case null, "" -> System.out.println("空です。");
      
      default -> System.out.println("意図しない値です。");
      // case null, default -> System.out.println("意図しない値です。");
    }

    // Object o = -123;
    // System.out.println(switch (o) {
    //   case String s -> "  %s  ".formatted(s);
    //   case Integer i -> "%,d".formatted(i);
    //   default -> o.toString();
    // });
  }
}
