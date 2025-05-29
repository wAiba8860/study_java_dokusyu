package to.msn.wings.selfjava.chap08.upcast;

public class CastUp {

  public static void main(String[] args) {
    Person bp = new BusinessPerson();
    bp.name = "山田太郎";
    bp.age = 20;
    System.out.println(bp.show());
  }
}
