package to.msn.wings.studyjava.chap08;

import java.time.ZonedDateTime;

public class Person {
    // フィールドはprivate扱い
    // private String name;
    // private int age;
    protected String name;
    protected int age;
    public ZonedDateTime birth = ZonedDateTime.now();

    // nameフィールドのゲッター
    public String getName() {
        return this.name;
    }

    // nameフィールドのセッター
    public void setName(String name) {
        this.name = name;
    }

    // ageフィールドのゲッター
    public int getAge() {
        return this.age;
    }

    // ageフィールドのセッター
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("年齢は正数で指定してください");
        }
        this.age = age;
    }

    public final String showFinal() {
        return String.format("%s(%d)歳です。", this.name, this.age);
    }

    public String show() {
        return String.format("%s (%d) 歳です。", this.name, this.age);
    }
}
