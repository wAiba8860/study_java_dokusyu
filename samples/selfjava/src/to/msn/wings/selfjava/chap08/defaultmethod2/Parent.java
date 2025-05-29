package to.msn.wings.selfjava.chap08.defaultmethod2;

public interface Parent {
  default void log(String msg) {
    System.out.println("Parent: " + msg);
  }
}
