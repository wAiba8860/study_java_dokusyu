package to.msn.wings.selfjava.chap07.staticinit;

public class Order {
  String value = "First!";

  public Order() {
    System.out.println(value);
  }

  {
    value = "Second!!";
  }
}
