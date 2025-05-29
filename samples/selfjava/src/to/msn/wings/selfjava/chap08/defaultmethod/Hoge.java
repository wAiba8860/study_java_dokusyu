package to.msn.wings.selfjava.chap08.defaultmethod;

public interface Hoge {
  default void log(String msg) {
    System.out.println("Hoge: " + msg);
  }
}
