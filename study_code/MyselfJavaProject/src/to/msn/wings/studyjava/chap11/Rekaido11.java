package to.msn.wings.studyjava.chap11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Rekaido11 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        System.out.println("x:スレッド生成／破棄はオーバーヘッドの大きな処理。スレッドプールを利用してできるだけ再利用を検討するべき");
        System.out.println("x:atomicはロックを使わない機能を提供する");
        System.out.println("x:他にも列挙型、Class型、アノテーション型などを指定できる");
        System.out.println("!o! x:java.seはjava.baseの誤り java seモジュールはjava標準ライブラリ全体を含むモジュールです");
        System.out.println("x:自動モジュールとして扱われる");
        System.out.println("[2]:");
        practice2();
        System.out.println("[3]:");
        System.out.println("1:implements -> extends 2:正しい 3:var -> Thread 4:newScheduledThreadPool 5:opens -> open");
        System.out.println("[4]:");
        practice4();
    }

    public static void practice2() {
        // 単一のスレッドを準備
        try (var exe = Executors.newSingleThreadExecutor()) {

            // スレッドを実行
            var r = exe.submit(() -> {

                var rnd = new Random();
                var num = rnd.nextInt(1000);
                Thread.sleep(num);
                return num;

            });

            // スレッドからの戻り値を表示
            System.out.println("結果: " + r.get());
        } catch (InterruptedException | ExecutionException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public class MyRunner extends Thread {

    }

    synchronized void increment() {

    }

    public static void practice4() {
        var sche = Executors.newScheduledThreadPool(2);
        // 処理1
        CompletableFuture.supplyAsync(() -> {
            var r = new Random();
            var num = r.nextInt(2000);
            heavy(num);
            System.out.printf("処理1: %d\n", num);
            return num;
        })

                // 処理2（乱数を倍に）
                .thenApplyAsync(data -> {
                    var num = data * 2;
                    heavy(num);
                    System.out.printf("処理2: %d\n", num);
                    return num;
                }).thenAcceptAsync(data -> {
                    var num = data * 2;
                    heavy(num);
                    System.out.printf("処理3: %d\n", num);
                });
        heavy(7000);
    }

    // ダミーの重い処理（ここでは指定時間だけ処理を休止）
    public static void heavy(int num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
