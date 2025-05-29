package to.msn.wings.selfjava.chap05;

public class RegReplaceNamed {

  public static void main(String[] args) {
    var str = "仕事用はwings@example.comです。";
    System.out.println(str.replaceAll(
        "(?i)(?<localName>[a-z0-9.!#$%&'*+/=?^_{|}~-]+)@(?<domain>[a-z0-9-]+(?:\\.[a-z0-9-]+)*)",
        "${domain}の${localName}"));
  }
}
