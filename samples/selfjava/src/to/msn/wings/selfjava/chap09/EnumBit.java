package to.msn.wings.selfjava.chap09;

import java.util.regex.Pattern;

public class EnumBit {

  public static void main(String[] args) {
    var flags = Pattern.CASE_INSENSITIVE | Pattern.MULTILINE;
    // var flags = Pattern.CASE_INSENSITIVE | Pattern.COMMENTS;
    if ((flags & Pattern.COMMENTS) != 0) {
      System.out.println("COMMENTSは有効です。");
    }
  }
}
