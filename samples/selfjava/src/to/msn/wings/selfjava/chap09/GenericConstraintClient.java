package to.msn.wings.selfjava.chap09;

public class GenericConstraintClient {

  public static void main(String[] args) {
    var m = new GenericConstraint<String>();
    //var n = new GenericConstraint<Person>();
    System.out.println(m.Hoge("ねこ", "ねこ"));
  }
}
