package to.msn.wings.selfjava.chap09;

import java.util.EnumMap;

public class EnumSeason {
  public void processSeason(Season season) {
    System.out.println(season);
  }

  public static void main(String[] args) {
    var es = new EnumSeason();
    es.processSeason(Season.SPRING);
    // es.processSeason(4);
    // es.processSeason(EnumConstMonth.JANUARY);

    var map = new EnumMap<Season, String>(Season.class);
    map.put(Season.SPRING, "春");
    System.out.println(map);
  }
}
