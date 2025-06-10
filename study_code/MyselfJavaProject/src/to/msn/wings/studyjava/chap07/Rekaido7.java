package to.msn.wings.studyjava.chap07;

public class Rekaido7 {

    public static void main(String[] args) {
        System.out.println("[1]:");
        System.out.println(
                "1,アクセス修飾子 2,protected 3,private,final 4,static修飾子 5,静的メンバー 6,フィールド定数 7,X static O final 8,可変長引数 9,... 10,配列");
        System.out.println("[2]:");
        System.out.println(
                "x:既定はパッケージプライベート , x:データ型が異なっていても、同名のフィールドでは定義できない , !o! X:重複は可能。その際に双方を区別するのがthisキーワード , x:ブロック内部でのみ使用可能 , o");
        System.out.println("[3]:");
        var hm = new Hamster("pi", 10);
        hm.show();
        System.out.println("[4]:");
        practice4Client();
        System.out.println("1,100 2,100");
        System.out.println("変更後は 1,100 2,10");
    }

    public static void practice4Client() {
        var value = new int[] { 10, 20, 30 };
        var p = new Practice4();
        System.out.println(p.change(value)[0]);
        System.out.println(value[0]);
    }
}

final class Hamster {
    private String name;
    private int age;

    public Hamster(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Hamster() {
        this("権兵衛", 0);
    }

    public void show() {
        System.out.printf("%s (%d) 歳です。\n", this.name, this.age);
    }

}

final class Practice4 {

    public int[] change(int[] value) {
        value[0] = 100;
        return value;
    }
}