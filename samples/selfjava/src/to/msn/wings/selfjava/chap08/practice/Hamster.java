package to.msn.wings.selfjava.chap08.practice;

public class Hamster implements Mammal {
  private String name;

  public Hamster(String name) {
    this.name = name;
  }

  @Override
  public void move() {
    System.out.printf("%sは、トコトコ歩きます。", this.name);
  }
}
