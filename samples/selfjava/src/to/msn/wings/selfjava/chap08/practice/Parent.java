package to.msn.wings.selfjava.chap08.practice;

public class Parent extends Person implements Father, Mother {
  public void run() {
    Father.super.run();
    Mother.super.run();
  }
}
