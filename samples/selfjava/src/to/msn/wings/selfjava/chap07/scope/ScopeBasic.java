package to.msn.wings.selfjava.chap07.scope;

public class ScopeBasic {

  public static void main(String[] args) {
    var s = new Scope();
    System.out.println(s.show());
    System.out.println(s.data);
  }
}
