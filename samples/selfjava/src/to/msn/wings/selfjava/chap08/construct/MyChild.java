package to.msn.wings.selfjava.chap08.construct;

public class MyChild extends MyParent {
  public MyChild(String name) {
    super(name);
    System.out.printf("子の%sです。\n", name);
  }
}
