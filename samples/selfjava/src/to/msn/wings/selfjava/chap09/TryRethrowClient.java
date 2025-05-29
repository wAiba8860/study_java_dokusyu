package to.msn.wings.selfjava.chap09;

public class TryRethrowClient {
  public static void main(String[] args) {
    try {
      TryRethrow.rethrow(true);
    } catch (MySampleException | MyLibException e) {
      e.printStackTrace();
    }
  }  
}
