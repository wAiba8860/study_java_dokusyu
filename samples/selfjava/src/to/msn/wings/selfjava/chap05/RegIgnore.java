package to.msn.wings.selfjava.chap05;

import java.util.regex.Pattern;

public class RegIgnore {

  public static void main(String[] args) {
    var str = "仕事用はwings@example.comです。プライベート用はYAMA@example.comです。";
    var ptn = Pattern.compile("[a-z0-9.!#$%&'*+/=?^_{|}~-]+@[a-z0-9-]+(\\.[a-z0-9-]+)*", Pattern.CASE_INSENSITIVE);
    // var ptn = Pattern.compile("[A-Za-z0-9.!#$%&'*+/=?^_{|}~-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*");
    // var ptn = Pattern.compile(
    //   """
    //   [a-z0-9.!\\#$%&'*+/=?^_{|}~-]+  # local
    //   @                               # delimiter
    //   [a-z0-9-]+(\\.[a-z0-9-]+)*      # domain
    //   """, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS);
    
    var match = ptn.matcher(str);
    while (match.find()) {
      System.out.println(match.group());
    }
  }
}
