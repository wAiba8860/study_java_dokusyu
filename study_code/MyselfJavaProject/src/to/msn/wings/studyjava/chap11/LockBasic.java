package to.msn.wings.studyjava.chap11;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBasic {
    private int value = 0;
    private final Lock lock = new ReentrantLock();

    // 10万個のスレッドを実行
    public static void main(String[] args) {
        // スレッドの個数
        final int TASK_NUM = 1000;
        var th = new Thread[TASK_NUM];
        var tb = new LockBasic();

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

        // ロックを取得
        lock.lock();
        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                this.value++;
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
