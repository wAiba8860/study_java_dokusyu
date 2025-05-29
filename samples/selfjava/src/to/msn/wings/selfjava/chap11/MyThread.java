package to.msn.wings.selfjava.chap11;

public class MyThread extends Thread {
  @Override
  public void run() {
    for (var i = 0; i < 30; i++) {
      System.out.println(this.getName() + ": " + i);
    }
  }
}
