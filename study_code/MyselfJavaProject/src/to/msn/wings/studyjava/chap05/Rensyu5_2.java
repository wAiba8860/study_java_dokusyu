package to.msn.wings.studyjava.chap05;

import java.util.regex.Pattern;

public class Rensyu5_2 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        practice1();
        System.out.println("[2]:");
        practice2();
    }

    public static void practice1() {
        var str = "住所は〒160-0000 新宿区南町0-0-0です。\nあなたの住所は〒210-9999 川崎市北町1-1-1ですね";
        var ptn = Pattern.compile("[0-9]{3}-[0-9]{4}");
        var match = ptn.matcher(str);
        while (match.find()) {
            System.out.println(match.group(0));
        }
    }

    public static void practice2() {
        var str = "お問い合わせはsupport@example.comまで";
        var re = "(?i)[a-z0-9.!#$%&'*+/=?^_{|}~-]+@[a-z0-9-]+(?:\\.[a-z0-9-]+)*";
        System.out.println(str.replaceAll(re, "<a href=\"mailto:$0\">$0</a>"));
    }
}
