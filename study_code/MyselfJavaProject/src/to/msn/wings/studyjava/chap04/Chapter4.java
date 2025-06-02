package to.msn.wings.studyjava.chap04;

public class Chapter4 {
    public static void main(String[] args) {
        breakNest();
        breakLimit();
        // for (var value : args) {
        // System.out.println("こんにちは、" + value + "さん！");
        // }
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
            case "日本酒", "ビール", "ワイン" -> {
                yield "醸造酒です";
            }
            // case "日本酒", "ビール", "ワイン" -> "醸造酒です";
            case "ブランデー", "ウイスキー" -> "蒸留酒です";
            default -> "不明";
        });
    }

    public static void switchMatch() {
        // Object型には任意の型の値を代入できる
        Object obj = -90;

        switch (obj) {
            case Integer i -> System.out.println(Math.abs(i));
            case String str -> System.out.println(str.substring(0, 1));
            case null -> System.out.println("nullです");
            default -> System.out.println("意図しない値です");
        }
    }

    public static void switchException() {
        String str = "";
        System.out.println(switch (str) {
            case "Hoge" -> "ほげ";
            case null, default, "" -> "無効";
        });
    }

    public static void switchWhen() {
        Object obj = 123;

        switch (obj) {
            case Integer i when i >= 15 -> System.out.println("15以上の整数です");
            case Integer i -> System.out.println("整数です");
            case String str when str.length() < 10 -> System.out.println("10文字未満の文字列です");
            default -> System.out.println("意図しない型です");
        }
    }

    public static void whileBasic() {
        var i = 1;
        while (i < 6) {
            System.out.println(i + "番目のループです");
            i++;
        }
    }

    public static void whileDo() {
        var i = 1;
        do {
            System.out.println(i + "番目のループです");
            i++;
        } while (i < 6);
    }

    public static void forFloat() {
        // 正しく動作しない
        for (var i = 0.1f; i <= 1.0; i += 0.1f) {
            System.out.println(i);
        }
    }

    public static void forBlock() {
        for (var i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                i++;
            }
            System.out.println(i);
        }
    }

    public static void forComma() {
        for (var i = 1; i < 6; System.out.println(i + "番目のループです"), i++)
            ;
    }

    public static void forComma2() {
        for (int i = 1, j = 1; i < 6; i++, j++) {
            System.out.println(i * j);
        }
    }

    public static void foreachFor() {
        var data = new String[] { "うめ", "さくら", "もも" };
        for (var i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        for (var value : data) {
            System.out.println(value);
        }
    }

    public static void breakBasic() {
        int i;
        int sum = 0;

        for (i = 1; i <= 100; i++) {
            sum += i;
            if (sum > 1000) {
                break;
            }
        }

        System.out.println("合計が1000を超えるのは、1～" + i + "を加算したときです");
    }

    public static void continueBasic() {
        var sum = 0;
        for (var i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                continue;
            }
            sum += i;
        }
        System.out.println("合計値は" + sum + "です");
    }

    public static void breakNest() {
        for (var i = 1; i < 10; i++) {
            for (var j = 1; j < 10; j++) {
                var result = i * j;
                if (result > 50) {
                    break;
                }
                System.err.printf(" %2d", result);
            }
            System.out.println();
        }
    }

    public static void breakLimit() {
        limit: for (var i = 1; i < 10; i++) {
            for (var j = 1; j < 10; j++) {
                var result = i * j;
                if (result > 50) {
                    break limit;
                }
                System.err.printf(" %2d", result);
            }
            System.out.println();
        }
    }
}
