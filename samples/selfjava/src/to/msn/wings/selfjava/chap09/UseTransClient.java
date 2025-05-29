package to.msn.wings.selfjava.chap09;

public class UseTransClient {

  public static void main(String[] args) {
    var ut = new UseTrans();
    try {
      ut.readHttpPages();
    } catch (MySampleException e) {
      e.printStackTrace();
      var ex = e.getCause();
      System.out.println(ex);
    }
  }
}
