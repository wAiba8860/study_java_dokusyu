package to.msn.wings.selfjava.chap05;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatNumber {

  public static void main(String[] args) {
    var num1 = 1234.5678;
    var nf1 = NumberFormat.getCurrencyInstance(Locale.JAPAN);
    var nf2 = NumberFormat.getIntegerInstance();
    var nf3 = NumberFormat.getNumberInstance();
    System.out.println(nf1.format(num1));
    System.out.println(nf2.format(num1));
    System.out.println(nf3.format(num1));

    var num2 = 0.567;
    var nf4 = NumberFormat.getPercentInstance();
    System.out.println(nf4.format(num2));

    var num3 = 123_456_789;
    var nf5 = NumberFormat.getCompactNumberInstance();
    var nf6 = NumberFormat.getCompactNumberInstance(
      Locale.US, NumberFormat.Style.LONG);
    System.out.println(nf5.format(num3));
    nf5.setMaximumFractionDigits(2);
    System.out.println(nf5.format(num3));
    System.out.println(nf6.format(num3));
  }
}
