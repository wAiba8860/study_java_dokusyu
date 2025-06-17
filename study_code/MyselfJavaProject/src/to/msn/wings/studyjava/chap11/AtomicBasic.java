package to.msn.wings.studyjava.chap11;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicBasic {
    private AtomicInteger value = new AtomicInteger();

    // 10万個のスレッドを実行
    public static void main(String[] args) {
        // スレッドの個数
        final int TASK_NUM = 1000;
        var th = new Thread[TASK_NUM];
        var tb = new AtomicBasic();

        // スレッドを生成＆実行
        for (var i = 0; i < TASK_NUM; i++) {
            th[i] = new Thread(() -> {
                tb.increment();
            });
            th[i].start();
        }

        // スレッド終了まで待機
        for (var i = 0; i < TASK_NUM; i++) {
            try {
                th[i].join();
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        System.out.println(tb.value);
    }

    void increment() {
        value.getAndIncrement();
    }
}
