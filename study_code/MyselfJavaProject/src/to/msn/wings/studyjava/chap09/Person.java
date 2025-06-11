package to.msn.wings.studyjava.chap09;

import java.util.Objects;

public class Person {
    // 名前
    private String firstName;
    // 名字
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // 名前／名字ともに等しければ同値とする
    @Override
    public boolean equals(Object obj) {
        // 同一性の判定
        if (this == obj) {
            return true;
        }
        // 比較対象がnullならば常に等しくない
        if (obj == null) {
            return false;
        }
        // 同値性の判定
        if (obj instanceof Person p) {
            return Objects.equals(this.firstName, p.firstName) && Objects.equals(this.lastName, p.lastName);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("名前は、%s %s です。", this.lastName, this.firstName);
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }
}