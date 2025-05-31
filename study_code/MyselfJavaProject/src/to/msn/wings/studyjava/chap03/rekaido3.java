package to.msn.wings.studyjava.chap03;

public class rekaido3 {
    public static void main(String[] args) {
        System.out.println("[1]:1,算術演算子 2,代入演算子 3,if+switch 4,短絡演算子x !論理演算子! 5,&+^+|+<<+>>");
        System.out.println("[2]:x=6,y=4,builder1,builder2 = いろはにほへと");
        practice2();
        System.out.println("[3]:strがnullの場合endsWithメソッドは例外を吐くためコードが途中で終了して期待通りの出力がされないため");
        System.out.println("[4]:1,優先順位 2,結合則 3,高い 4,同等 5,=代入演算子");
    }

    public static void practice2() {
        var x = 6;
        var y = x;
        y -= 2;

        var builder1 = new StringBuilder("いろは");
        var builder2 = builder1;
        builder1.append("にほへと");

        System.out.println("x=" + x + "y=" + y);
        System.out.println("builder1=" + builder1 + "builder2=" + builder2);
    }

    public static void practice3() {
        String str = ".java";
        if (str != null && str.endsWith(".java")) {
            System.out.println("拡張子は.javaです");
        }
    }
}
