package to.msn.wings.selfjava.chap08.defaultmethod2;

public interface Hoge2 extends Parent{
  default void log(String msg) {
    System.out.println("Hoge2: " + msg);
  }
}
