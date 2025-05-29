package to.msn.wings.selfjava.chap04;

public class WhileDo {

  public static void main(String[] args) {
    var i = 1;
    do {
      System.out.println(i + "番目のループです。");
      i++;
    } while (i < 6);
  }
}
