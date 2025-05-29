package to.msn.wings.selfjava.chap03;

public class ConcatBuilder {

  public static void main(String[] args) {
    var start = System.currentTimeMillis();
    // var builder = new StringBuilder();
    var builder = new StringBuilder(1000);
    for (var i = 0; i < 100000; i++) {
      builder.append("いろは");
    }
    var result = builder.toString();
    System.out.println(result.length());
    var end = System.currentTimeMillis();
    System.out.println((end - start)  + "ミリ秒");
  }
}
