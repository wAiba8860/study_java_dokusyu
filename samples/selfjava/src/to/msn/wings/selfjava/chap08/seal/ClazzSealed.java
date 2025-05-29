package to.msn.wings.selfjava.chap08.seal;

sealed class Person permits BusinessPerson, Student {}

sealed class BusinessPerson extends Person permits EliteBusinessPerson {}

final class EliteBusinessPerson extends BusinessPerson {}

non-sealed class Student extends Person {}

class ScholarshipStudent extends Student {}

class HetareStudent extends Student {}

public class ClazzSealed {
  public static void main(String[] args) {
    Person p = new BusinessPerson();
    System.out.println(switch (p) {
      case BusinessPerson bp -> "BusinessPerson";
      case Student st -> "Stuent";
      case Person pp -> "Person";
    });
  }
}
