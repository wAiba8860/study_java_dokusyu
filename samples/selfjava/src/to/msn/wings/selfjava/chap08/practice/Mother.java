package to.msn.wings.selfjava.chap08.practice;

public interface Mother {
  default void run() {
    System.out.println("I am a mother.");
  }
}
