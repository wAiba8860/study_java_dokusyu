package to.msn.wings.selfjava.chap09.records;

record Name(String first, String last) {}
record Student(Name name, int age) {}

public class RecordNest {
  public static void main(String[] args) {
    Object obj = new Student(new Name("太郎", "山田"), 18);
    if (obj instanceof Student(Name(var first, var last), int age)) {
      System.out.println(first + last + ": " + age);
    }
  }
}
