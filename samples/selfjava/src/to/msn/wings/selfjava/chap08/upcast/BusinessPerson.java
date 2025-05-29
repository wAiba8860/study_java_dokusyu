package to.msn.wings.selfjava.chap08.upcast;

public class BusinessPerson extends Person {
  public BusinessPerson() {}

  @Override
  public String show() {
    return String.format("会社員の%s（%d歳）です。", this.name, this.age);
  }
}