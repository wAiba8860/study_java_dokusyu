package to.msn.wings.studyjava.chap11;

public class SynchronizedNotUse {
    // 複数スレッドで共有するデータ
    private int value = 0;

    // lock用途のオブジェクト
    private Object lock = new Object();

    // 10万個のスレッドを実行
    public static void main(String[] args) {
        // スレッドの個数
        final int TASK_NUM = 1000;
        var th = new Thread[TASK_NUM];
        var tb = new SynchronizedNotUse();

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

    // valueフィールドをインクリメント
    // void increment() {
    // this.value++;
    // }

    // 排他制御
    // void increment() {
    // synchronized (lock) {
    // this.value++;
    // }
    // }

    synchronized void increment() {
        this.value++;
    }
}
