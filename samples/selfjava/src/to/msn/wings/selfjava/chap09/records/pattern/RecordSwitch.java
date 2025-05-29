package to.msn.wings.selfjava.chap09.records.pattern;

record Person(String name) { }
record Student(String name) { }

public class RecordSwitch {
  public static void main(String[] args) {
    Object obj = new Student("山田太郎");
    switch (obj) {
      case Person(var name):
        System.out.println("Person: " + name);
        break;
      case Student(var name):
        System.out.println("Student: " + name);
        break;
      default:
        System.out.println("Unknown...");
        break;
    }
  }
}
