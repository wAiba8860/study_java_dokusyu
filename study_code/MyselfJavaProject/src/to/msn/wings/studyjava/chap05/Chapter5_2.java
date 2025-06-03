package to.msn.wings.studyjava.chap05;

import java.time.LocalDateTime;
import java.util.Locale;
import static java.lang.StringTemplate.STR;
import static java.util.FormatProcessor.FMT;

public class Chapter5_2 {
    public static void main(String[] args) {
        strFormatted();
    }

    public static void strFormat() {
        System.out.println(String.format("%sは%s、%d歳です", "サクラ", "女の子", 1));

        System.out.println(String.format("名前は%1$s、%3$d歳です。%1$sは、元気です。", "サクラ", "女の子", 1));

        System.out.println(String.format("%5sです", "サクラ"));

        System.out.println(String.format("%-5sです", "サクラ"));

        System.out.println(String.format("%2sです", "サクラ"));

        System.out.println(String.format("10進数 %08d", 12345));

        System.out.println(String.format("16進数 %#x", 12345));

        System.out.println(String.format("小数点数 %.2f", 123.456));

        System.out.println(String.format("指数／小文字 %.2e", 123.456));

        System.out.println(String.format("指数／大文字 %.2E", 123.456));

        var d = LocalDateTime.now();
        System.out.println(String.format("%tF", d));

        System.out.println(String.format("%tr", d));

        System.out.println(String.format("%1$tY年 %1$tm月 %1$td日", d));

        System.out.println(String.format(Locale.GERMAN, "%f", 1234.567));

        System.out.println(String.format(Locale.US, "%tr", d));

        System.out.printf("%.2sです。\n", "サクラ");
    }

    public static void strFormatted() {
        var str = "名前は%1$s、%3$d歳です。%1$sは、元気です。";
        System.out.println(str.formatted("サクラ", "女の子", 1));
    }

    // public static void strTemplate(){
    // var name ="鈴木 一誠";
    // System.out.println(STR."こんにちは、\{name}さん！");
    // System.out.println(STR."こんにちは、\{name.split(" ")[1]}さん！");
    // }

    // public static void fmtTemplate(){
    // var pref = "千葉";
    // var temp = 26.8;
    // var humi = 55.0;

    // System.out.println(FMT."""
    // %5s\{pref}県の気象
    // 温度:%5.1f\{temp}℃
    // 湿度:%5.1f\{humi}%
    // """);
    // }
}