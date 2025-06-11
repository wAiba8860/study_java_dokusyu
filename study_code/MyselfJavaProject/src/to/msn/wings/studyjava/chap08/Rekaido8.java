package to.msn.wings.studyjava.chap08;

public class Rekaido8 {

    public static void main(String[] args) {
        System.out.println("[1]:");
        System.out.println("x:superを使う, x:必須ではなく推奨 Overrideをつけることによってエラーがわかりやすくなる");
        System.out.println(
                "!o! x:抽象クラス配下の抽象メソッドは本体をもてないが、その他のメソッドは本体を持てる, !x! o:ダウンキャストする場合、instanceof演算子による型チェックは必須 ,x:extends implementsが可能");
        System.out.println("[2]:");
        var p = new Parent();
        p.run();
        System.out.println("[3]:");
        var a = new Animal("ねこ", 10);

        System.out.println(a.intro());
        System.out.println("[4]:");
        var ps = new Practice4Sub();
        ps.value = 123.456;
        System.out.println(ps.show());
        System.out.println("[5]:");
    }

}

interface Father {
    // static void run() {
    default void run() {
        System.out.println("I am a father.");
    }
}

interface Mother {
    // static void run() {
    default void run() {
        System.out.println("I am a mother.");
    }
}

class Parent extends Person implements Father, Mother {
    public void run() {
        Father.super.run();
        Mother.super.run();
    }
}

class Animal {
    // publicではなくprivate
    private String name;
    private int age;

    // thisがない
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // コンストラクター
    // voidが不必要
    // superではなくthis
    public Animal() {
        this("名無権兵衛", 0);
    }

    // アクセサーメソッド
    public String getName() {
        return this.name;
    }

    // セッターだからvoid(返り値なし)
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0) {
            age = 0;
        }
        this.age = age;
    }

    // メソッド
    // $ではなく%
    public String intro() {
        return String.format("私の名前は%s。%d歳です。", getName(), getAge());
    }
}

class Practice4 {
    public double value;

    public String show() {
        return String.format("値は%.2f", this.value);
    }
}

class Practice4Sub extends Practice4 {
    @Override
    public String show() {
        return String.format("[%s]", super.show());
    }
}

interface Mammal {
    // abstractインターフェースは中身を持てない
    void move();
}

// extendsではなくimplements
class Hamster implements Mammal {
    private String name;

    public Hamster(String name) {
        this.name = name;
    }

    // Overrideはアノテーション
    @Override
    public void move() {
        System.out.printf("%sは、トコトコ歩きます。", this.name);
    }
}