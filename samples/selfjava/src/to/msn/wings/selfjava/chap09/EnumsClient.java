package to.msn.wings.selfjava.chap09;

import java.util.EnumSet;

public class EnumsClient {
  public static void main(String[] args) {
      var s0 = EnumSet.of(Season.SPRING, Season.AUTUMN);
      System.out.println(s0);
      var s1 = EnumSet.allOf(Season.class);
      System.out.println(s1);
      var s2 = EnumSet.noneOf(Season.class);
      System.out.println(s2);
      var s3 = EnumSet.copyOf(s0);
      System.out.println(s3);
      var s4 = EnumSet.complementOf(s0);
      System.out.println(s4);
      var s5 = EnumSet.range(Season.SPRING, Season.AUTUMN);
      System.out.println(s5);

  }
}
