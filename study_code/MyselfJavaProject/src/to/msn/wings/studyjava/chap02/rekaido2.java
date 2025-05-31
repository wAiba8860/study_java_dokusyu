package to.msn.wings.studyjava.chap02;

public class rekaido2 {
    public static void main(String[] args) {
        System.out.println("[1]:dataの型宣言がされていない,System文の文末にセミコロンがない,!文字列リテラルはシングルクォートではなくダブルクウォートでくくる!");
        System.out.println("[2]:1,完全修飾子 2,!単純名! 3,インポート命令 4,!解決!");
        System.out.println("[3]:");
        practice3();
        System.out.println("[4]:o,x:文字列はダブル、単一文字はシングル,!x!,x,x:クラスフィールド（静的フィールド）はクラスをつけて直接呼び出せる");
        System.out.println("[5]:");
    }

    public static void practice3() {
        final double DISCOUNT = 0.9;
        var price = 500;
        var sum = price * DISCOUNT;
        System.out.println((int) sum);
    }

    public static void practice5() {
        var value = 10d;
        var str1 = """
                ようこそ
                Javaの世界へ
                """;
        String str2 = null;
        int[][] data = new int[5][4];
        var list = new int[][] {
                { 2, 3, 5 },
                { 1, 2 },
                { 19, 11, 12, 13 },
        };
    }
}