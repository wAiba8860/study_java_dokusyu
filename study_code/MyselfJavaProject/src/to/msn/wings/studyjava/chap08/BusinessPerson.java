package to.msn.wings.studyjava.chap08;

import java.time.LocalDateTime;

public class BusinessPerson extends Person {

    public LocalDateTime birth = LocalDateTime.now();

    public String work() {
        return String.format("%d歳の%sは、働きます", this.age, this.name);
    }

    @Override
    public String show() {
        return String.valueOf(super.birth);
    }

    public void Student() {

    }

    // @Override
    // public String showFinal() {
    // return "会社員です";
    // }

    // @Override
    // public String show(){
    // 未サポート（showメソッドは利用不可）
    // throw new UnsupportedOperationException();
    // }
}