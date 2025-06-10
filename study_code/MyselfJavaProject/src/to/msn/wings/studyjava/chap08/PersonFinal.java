package to.msn.wings.studyjava.chap08;

import java.util.Date;

public final class PersonFinal {

    private final String name;
    private final int age;
    private final Date birth;

    // コンストラクター
    public PersonFinal(String name, int age, Date birth) {
        this.name = name;
        this.age = age;
        // this.birth = birth;
        this.birth = new Date(birth.getTime());
    }

    // ゲッターメソッド
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    // public Date getBirth() {
    // return this.birth;
    // }

    public Date getBirth() {
        return new Date(this.birth.getTime());
    }
}