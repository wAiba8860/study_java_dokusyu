package to.msn.wings.studyjava.chap10;

import java.util.function.IntConsumer;

public class MethodLambdaScope {
    public static void main(String[] args) {
        int radius = 10;
        Runnable circle = () -> {
            System.out.println(Math.pow(radius, 2) * Math.PI);
            // Local variable radius defined in an enclosing scope must be final or effectively
            // final
            // radius++;
        };
        circle.run();
        // 上と同様
        // radius++;


        // Lambda expression's parameter radius cannot redeclare another local variable defined in
        // an enclosing scope.
        // IntConsumer c = radius -> {
        // System.out.println(Math.pow(radius, 2) * Math.PI);
        // };
    }
}
