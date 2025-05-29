package to.msn.wings.selfjava.chap08.immutable;

public class ImmutableBasic {
  public static void main(String[] args) {
    var p = new Person("山田太郎", 30);
    System.out.println(p.getName());
  }
}
