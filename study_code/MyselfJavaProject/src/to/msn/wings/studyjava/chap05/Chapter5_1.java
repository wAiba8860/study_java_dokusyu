package to.msn.wings.studyjava.chap05;

public class Chapter5_1 {
    public static void main(String[] args) {
        strSplit();
    }

    public static void autoBoxing() {
        // Longはlongの誤り
        Long result = 0L;

        for (var i = 0; i < 10000; i++) {
            // アンボクシング（加算）＋ボクシング（代入）の発生
            result += i;
        }
        System.out.println(result);
    }

    public static void convertNumber() {
        System.out.println(Integer.parseInt("108"));
        System.out.println(Double.parseDouble("1.2345"));
        System.out.println(Integer.parseInt("FF", 16));
        System.out.println(Double.parseDouble("0.653e2"));
    }

    public static void convertString() {
        System.out.println(String.valueOf(108));
        System.out.println(Integer.toString(108));
        System.out.println(Double.valueOf(1.2345));
        System.out.println(Integer.toString(255, 16));
        System.out.println(Integer.toHexString(255));
    }

    public static void strLength() {
        var str1 = "WINGSプロジェクト";
        System.out.println(str1.length());

        var str2 = "𠮷野家";
        System.out.println(str2.length());

        System.out.println(str2.codePointCount(0, str2.length()));
    }

    public static void strCompare() {
        var str = "def";
        System.out.println(str.compareTo("abc"));
        System.out.println(str.compareTo("def"));
        System.out.println(str.compareTo("xyz"));
        System.out.println(str.compareToIgnoreCase("DEF"));
    }

    public static void strEquals() {
        var str = "Wings";
        System.out.println(str.equals("WINGS"));
        System.out.println(str.equalsIgnoreCase("WINGS"));
    }

    public static void strBlank() {
        var str1 = "";
        var str2 = "      ";

        System.out.println(str1.isEmpty());
        System.out.println(str1.isBlank());
        System.out.println(str2.isEmpty());
        System.out.println(str2.isBlank());
    }

    public static void strStrip() {
        var str = "  Wings Project  ";

        System.out.println(str.strip());
        System.out.println(str.stripLeading());
        System.out.println(str.stripTrailing());
    }

    public static void strIndex() {
        var str = "にわにはにわにわとりがいる";

        System.out.println(str.indexOf("にわ"));
        System.out.println(str.indexOf("にも"));
        System.out.println(str.lastIndexOf("にわ"));
        System.out.println(str.indexOf("にわ", 3));
        System.out.println(str.lastIndexOf("にわ", 3));
    }

    public static void strContains() {
        var str = "WINGSプロジェクト";

        System.out.println(str.contains("プロ"));
        System.out.println(str.startsWith("WINGS"));
        System.out.println(str.startsWith("WINGS", 3));
        System.out.println(str.endsWith("WINGS"));
    }

    public static void strSubstring() {
        var str = "WINGSプロジェクト";

        System.out.println(str.substring(5, 7));
        // エラーSystem.out.println(str.substring(5, 2));
        // エラーSystem.out.println(str.substring(-5));
        // エラーSystem.out.println(str.substring(15));
        System.out.println(str.substring(0, 7));
    }

    public static void strSubstring2() {
        var mail = "yamada@exmple.com";
        System.out.println(mail.substring(mail.lastIndexOf("@") + 1));
        System.out.println(mail.charAt(0));

        for (var i = 0; i < mail.length(); i++) {
            System.out.print(mail.charAt(i) + " ");
        }
    }

    public static void strCharAt() {
        var str = "𠮷";
        System.out.println((int) str.charAt(0));
    }

    public static void strSplit() {
        var str1 = "うめ,もも,さくら";
        var result1 = str1.split(",");
        System.out.println(String.join("&", result1));

        var str2 = "うめ,もも,さくらとあんず";
        var result2 = str2.split("[,と]");
        System.out.println(String.join("&", result2));

        var str3 = "うめ,もも,さくら";
        var result3 = str3.split("");
        System.out.println(String.join("&", result3));

        var str4 = "うめ,もも,さくら,あんず";
        var result4 = str4.split(",", 3);
        System.out.println(String.join("&", result4));

        System.out.println(String.join(",", "うめ", "もも", "さくら"));
    }

    public static void splitExample() {
        String text = "apple,banana,cherry,date,elderberry";

        // limit = 3 の場合 (limit > 0)
        // 分割回数は limit - 1 = 2 回
        String[] result1 = text.split(",", 3);
        // "apple" | "banana" | "cherry,date,elderberry"
        System.out.println("limit = 3:");
        for (String s : result1) {
            System.out.println("  \"" + s + "\"");
        }
        // 出力:
        // "apple"
        // "banana"
        // "cherry,date,elderberry"
        // 要素数は 3 (limitと一致)

        String text2 = "a,b,c";
        String[] result2 = text2.split(",", 2); // 分割回数は 1 回
        // "a" | "b,c"
        System.out.println("\nlimit = 2 (a,b,c):");
        for (String s : result2) {
            System.out.println("  \"" + s + "\"");
        }
        // 出力:
        // "a"
        // "b,c"
        // 要素数は 2 (limitと一致)

        String text3 = "a,b,c";
        String[] result3 = text3.split(",", 10); // 分割回数は 2 回 (区切り文字が3個未満のため)
        // "a" | "b" | "c"
        System.out.println("\nlimit = 10 (a,b,c):");
        for (String s : result3) {
            System.out.println("  \"" + s + "\"");
        }
        // 出力:
        // "a"
        // "b"
        // "c"
        // 要素数は 3 (limitより少ない) - 区切り文字が足りない場合は、limit数には達しない。

        String text4 = "a,b,,c,"; // 末尾に空文字列がある場合
        String[] result4_zero = text4.split(",", 0); // limit = 0 (デフォルトと同じ)
        System.out.println("\nlimit = 0 (a,b,,c,):");
        for (String s : result4_zero) {
            System.out.println("  \"" + s + "\"");
        }
        // 出力:
        // "a"
        // "b"
        // "" // 真ん中の空文字列は残る
        // "c"
        // 末尾の空文字列は破棄される。

        String text5 = "a,b,,c,"; // 末尾に空文字列がある場合
        String[] result5_negative = text5.split(",", -1); // limit < 0
        System.out.println("\nlimit = -1 (a,b,,c,):");
        for (String s : result5_negative) {
            System.out.println("  \"" + s + "\"");
        }
        // 出力:
        // "a"
        // "b"
        // ""
        // "c"
        // "" // 末尾の空文字列も残る
    }
}
