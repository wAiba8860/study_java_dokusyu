package to.msn.wings.selfjava.chap09.member;

public class EnumBasic {

  public static void main(String[] args) {
    System.out.println(Season.SPRING);
    System.out.println(Season.SPRING.toString());
    System.out.println(Season.SPRING.toSeasonValue());
  }
}
