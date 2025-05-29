package to.msn.wings.selfjava.chap08.defaultmethod;

public interface Hoge2 {
  default void log(String msg) {
    System.out.println("Hoge2: " + msg);
  }
}
