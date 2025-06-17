package to.msn.wings.studyjava.chap11;

public class MyRunner implements Runnable {
    // スレッドの実処理
    public void run() {
        for (var i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
