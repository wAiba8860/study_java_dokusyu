package to.msn.wings.studyjava.chap09;

public record PersonRecord(String name, int age) {
    public PersonRecord {
        if (age < 0) {
            throw new IllegalArgumentException();
        }
    }

    public PersonRecord() {
        this("名無権兵衛", 30);
    }

}

// 以下のクラスと等価

// public final class PersonRecord extends Record {
// private final String name;
// private final int age;

// // コンストラクター
// public PersonRecord(String name, int age) {
// this.name = name;
// this.age = age;
// }

// // フィールドアクセスのためのゲッター
// public String name() {
// return this.name;
// }

// public int age() {
// return this.age;
// }

// // その他のメソッド
// @Override
// public int hadhCode() {
// }

// @Override
// public boolean equals(Object obj) {
// if(this == obj) return true;
// if(obj instanceof PersonRecord p){
// return this.name.equals(p.name) && this.age == p.age;
// }
// }

// @Override
// public String toString() {
// return "PersonRecord[name =" + this.name + ", age=" + this.age + "]";
// }
// }