package to.msn.wings.selfjava.chap11;

public class ThreadPool implements Runnable {
  @Override
  public void run() {
    for (var i = 0; i < 30; i++){
      System.out.println(Thread.currentThread().getName() + ":" + i);
    }
  }
}
