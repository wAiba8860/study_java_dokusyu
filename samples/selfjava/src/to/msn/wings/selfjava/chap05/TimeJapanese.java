package to.msn.wings.selfjava.chap05;

import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.time.format.DateTimeFormatter;

public class TimeJapanese {

  public static void main(String[] args) {
    var d = JapaneseDate.of(JapaneseEra.REIWA, 6, 12, 31);
    System.out.println(d);
    var df = DateTimeFormatter.ofPattern("Gy年MM月dd日");
    System.out.println(d.format(df));
  }
}
