package to.msn.wings.selfjava.chap11;

public class ThreadVirtual {
  public static void main(String[] args) throws InterruptedException {
    var factory = Thread.ofVirtual().name("MyThread").factory();
    var th = factory.newThread(new MyRunner());
    th.start();
    th.join();
  }  
}
