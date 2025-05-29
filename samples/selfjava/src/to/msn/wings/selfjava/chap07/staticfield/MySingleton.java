package to.msn.wings.selfjava.chap07.staticfield;

public class MySingleton {
  private static MySingleton instance = new MySingleton();

  private MySingleton() {}

  public static MySingleton getInstance() {
    return instance;
  }

  public static void main(String[] args) {
    System.out.println(MySingleton.getInstance());
    System.out.println(MySingleton.getInstance());
  }
}
