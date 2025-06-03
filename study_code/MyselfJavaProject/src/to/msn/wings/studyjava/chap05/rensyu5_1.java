package to.msn.wings.studyjava.chap05;

public class rensyu5_1 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        practice1();
        System.out.println("[2]:");
        practice2();
    }

    public static void practice1() {
        var str = "プログラミング言語";

        System.out.println(str.substring(4, 7));
    }

    public static void practice2() {
        var str = "鈴木\t太郎\t男\t50歳\t広島県";

        System.out.println(String.join("&", str.split("\t")));
    }
}