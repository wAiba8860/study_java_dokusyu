package to.msn.wings.studyjava.chap05;

public class Chapter5_1 {
    public static void main(String[] args) {
        strLength();
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
}
