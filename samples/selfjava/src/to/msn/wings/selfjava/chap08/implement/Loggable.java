package to.msn.wings.selfjava.chap08.implement;

public interface Loggable {
  default void log(String msg) {
    System.out.println("Log: " + msg);
  }
}
