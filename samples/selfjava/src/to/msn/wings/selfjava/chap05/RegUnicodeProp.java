package to.msn.wings.selfjava.chap05;

import java.util.regex.Pattern;

public class RegUnicodeProp {
  public static void main(String[] args) {
    var str = "WINGSプロジェクトは2003年に発足した執筆者コミュニティです。";
    var ptn = Pattern.compile("\\p{IsKatakana}+");
    var match = ptn.matcher(str);
    while (match.find()) {
      System.out.println(match.group());
    }
  }
}
