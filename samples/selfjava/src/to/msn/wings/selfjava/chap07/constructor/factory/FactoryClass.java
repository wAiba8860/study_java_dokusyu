package to.msn.wings.selfjava.chap07.constructor.factory;

public class FactoryClass {
  private FactoryClass() {
    System.out.println("ファクトリー");
  }

  public static FactoryClass getInstance() {
    return new FactoryClass();
  }
}
