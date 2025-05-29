package to.msn.wings.selfjava.chap09.practice;

public class WeekdayClient {

  public static void main(String[] args) {
    for (var day : Weekday.values()) {
      System.out.println(day.ordinal() + ":" + day.toString());
    }
  }
}
