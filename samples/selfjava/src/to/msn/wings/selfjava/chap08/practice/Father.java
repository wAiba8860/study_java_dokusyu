package to.msn.wings.selfjava.chap08.practice;

public interface Father {
  default void run() {
    System.out.println("I am a father.");
  }
}
