package to.msn.wings.selfjava.chap10;

import java.util.function.IntConsumer;

public class MethodLambdaScope {
  public static void main(String[] args) {
    int radius = 10;
    Runnable circle = () -> {
      System.out.println(Math.pow(radius, 2) * Math.PI);
      // radius++;
    };
    circle.run();
    // radius++;
  }
}
