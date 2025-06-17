package to.msn.wings.studyjava.chap11;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Rensyu11_1 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        System.out.println("処理の重複問題を解決するためのブロック。一つのスレッド処理が終わるまで次のスレッド処理が開始しなくなる");
        System.out.println(
                "synchronizedブロックで囲まれた処理は、複数のスレッドから同時に呼び出されなくなります。ほぼ同時に呼び出された場合にも、先に呼び出されたほうの処理を優先し、あとから呼び出された側は先行する処理が終わるまで待ちの状態になります。これによって、同時実行によるデータの不整合を防ぎます。");
        System.out.println("[2]:");
        practice2();
    }

    public static void practice2() {
        try (var sche = Executors.newScheduledThreadPool(2)) {
            // scheduleではなくscheduleAtFixedRate
            sche.scheduleAtFixedRate(() -> {
                System.out.println(LocalDateTime.now());
            }, 0, 5, TimeUnit.SECONDS);
            // startではなくsleep
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // finallyではなくcatch
        // try_catch_resources構文で自動的に破棄されるのでfinallyはいらない
    }
}
