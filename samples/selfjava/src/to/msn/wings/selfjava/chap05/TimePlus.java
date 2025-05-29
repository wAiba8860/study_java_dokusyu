package to.msn.wings.selfjava.chap05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TimePlus {

  public static void main(String[] args) {
    var d = LocalDate.of(2024, 1, 10);
    System.out.println(d);
    System.out.println(d.plus(3, ChronoUnit.YEARS));
    System.out.println(d.minus(21, ChronoUnit.DAYS));
  }
}
