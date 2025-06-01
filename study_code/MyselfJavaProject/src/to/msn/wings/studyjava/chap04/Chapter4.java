package to.msn.wings.studyjava.chap04;

public class Chapter4 {
    public static void main(String[] args) {
        switchExp();
    }

    public static void ifBasic() {
        var i = 10;
        if (i == 10) {
            System.out.println("変数iは10です");
        } else {
            System.out.println("変数iは10ではありません");
        }
        System.out.println(i == 10 ? "変数iは10です" : "iは10ではありません");
    }

    public static void ifElse() {
        var i = 100;
        // (i>30)では最初の条件処理でif文を抜けてしまう
        if (i > 50) {
            System.out.println("iは50より大きいです");
        } else if (i > 30) {
            System.out.println("変数は30より大きく、50以下です");
        } else {
            System.out.println("iは30以下です");
        }
    }

    public static void ifNest() {
        var i = 1;
        var j = 0;
        if (i == 1) {
            if (j == 1) {
                System.out.println("変数i,jは1です");
            } else {
                System.out.println("変数iは1ですが、jは1ではありません");
            }

        } else {
            System.out.println("変数iは1ではありません");
        }
    }

    public static void ifOmit() {
        // 非推奨
        var i = 1;
        if (i == 1)
            System.out.println("変数iは1です");
        else
            System.out.println("変数iは1ではありません");
    }

    public static void switchBasic() {
        var rank = "甲";

        switch (rank) {
            case "甲":
                System.out.println("大変良いです");
                break;

            case "乙":
                System.out.println("良いです");
                break;

            case "丙":
                System.out.println("がんばりましょう");
                break;

            default:
                System.out.println("？？？");
                break;
        }
    }

    public static void switchFall() {
        var drink = "ビール";
        switch (drink) {
            case "日本酒":
            case "ビール":
            case "ワイン":
                System.out.println("醸造酒です");
                break;

            case "ブランデー":
            case "ウイスキー":
                System.out.println("蒸留酒です");
                break;
        }
    }

    public static void switchExp() {
        var drink = "ビール";
        System.out.println(switch (drink) {
            case "日本酒", "ビール", "ワイン" -> "醸造酒です";
            case "ブランデー", "ウイスキー" -> "蒸留酒です";
            default -> "不明";
        });
    }
}
