package to.msn.wings.selfjava.chap10;

public class Counter {
  private int result = 0;

  public int getResult() {
    return this.result;
  }

  public void addLength(String value) {
    this.result += value.length();
  }
}
