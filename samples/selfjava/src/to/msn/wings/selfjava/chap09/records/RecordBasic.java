package to.msn.wings.selfjava.chap09.records;

public class RecordBasic {
  public static void main(String[] args) {
    var p1 = new Person("山田太郎", 38);
    var p2 = new Person("山田太郎", 38);
    System.out.println(p1.name());
    System.out.println(p1);
    System.out.println(p1.equals(p2));
    System.out.println(p1 == p2);
  }
}
