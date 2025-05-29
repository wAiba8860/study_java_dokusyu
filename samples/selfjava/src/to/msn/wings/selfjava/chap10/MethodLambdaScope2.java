package to.msn.wings.selfjava.chap10;

import java.util.function.IntConsumer;

public class MethodLambdaScope2 {
  public static void main(String[] args) {
    // int radius = 10;
    IntConsumer c = radius -> {
      System.out.println(Math.pow(radius, 2) * Math.PI);
    };
  }
}
