package to.msn.wings.selfjava.chap04.practice;

public class Practice4 {

  public static void main(String[] args) {
    var language = "Kotlin";

    switch (language) {
      case "Scala":
      case "Kotlin":
      case "Groovy":
        System.out.println("JVM言語");
        break;
      case "C#":
      case "Visual Basic":
      case "F#":
        System.out.println(".NET言語");
        break;
      default:
        System.out.println("不明");
        break;
    }

    // 別解：複数の値をカンマ区切りで列挙
    // switch (language) {
    //   case "Scala", "Kotlin", "Groovy":
    //     System.out.println("JVM言語");
    //     break;
    //   case "C#", "Visual Basic", "F#":
    //     System.out.println(".NET言語");
    //     break;
    //   default:
    //     System.out.println("不明");
    //     break;
    // }

    // 別解：switch式
    // System.out.println(switch(language) {
    //   case "Scala", "Kotlin", "Groovy" -> "JVM言語";
    //   case "C#", "Visual Basic", "F#" -> ".NET言語";
    //   default -> "不明";
    // });
  }
}
