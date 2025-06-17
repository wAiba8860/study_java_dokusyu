package to.msn.wings.studyjava.chap11;

public class MyThread extends Thread {

    // スレッドの実処理
    @Override
    public void run() {
        for (var i = 0; i < 30; i++) {
            System.out.println(this.getName() + ": " + i);
        }
    }

}
