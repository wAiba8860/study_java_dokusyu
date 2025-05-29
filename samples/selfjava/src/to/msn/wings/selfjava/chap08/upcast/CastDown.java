package to.msn.wings.selfjava.chap08.upcast;

public class CastDown {
  public static void main(String[] args) {
    Person p = new BusinessPerson();
    BusinessPerson bp = (BusinessPerson)p;

    bp.name = "山田太郎";
    bp.age = 20;
    System.out.println(bp.show());
  }

}
