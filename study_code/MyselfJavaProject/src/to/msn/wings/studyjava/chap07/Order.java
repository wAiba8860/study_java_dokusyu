package to.msn.wings.studyjava.chap07;

public class Order {

    String value = "first!";

    public Order() {
        System.out.println(value);
    }

    {
        value = "second!";
    }
}