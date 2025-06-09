package to.msn.wings.studyjava.chap07;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class Chapter7_1 {

    public static void main(String[] args) {
        argsOverloadClient();
    }

    public static void fieldBasic() {
        var p1 = new Person("山田太郎", 30);

        var p2 = new Person("鈴木花子", 25);
        // p2.name = "鈴木花子";
        // p2.age = 25;

        System.out.printf("%s (%d歳) \n", p1.getName(), p1.getAge());
        System.out.printf("%s (%d歳) \n", p2.getName(), p2.getAge());
    }

    public static void methodBasic() {
        var p = new Person("山田太郎", 30);
        System.out.println(p.show());
        var p2 = new Person();
        System.out.println(p2.show());
    }

    // public String[] split(String regex, int limit) {
    // return Pattern.compile(regex).split(this, limit);
    // }

    // public String[] split(String regex) {
    // return split(regex,0);
    // }

    public static void overloadAntiClient() {
        var c = new OverloadAnti();
        var list = new CharSequence[] { "春はあけぼの", new StringBuilder("夏は夜"), new StringBuffer("秋は夕暮れ") };

        for (var cs : list) {
            c.show(cs);
        }
    }

    public static void scopeBasic() {
        var s = new Scope();
        System.out.println(s.show());
        System.out.println(s.data);
    }

    public static void scopeBlock() {
        ScopeBlock.main(null);
    }

    public static void myClass() {
        // MyClass()だとエラー
        var mp = new MyClass(2);
    }

    public static void factory() {
        var fc = FactoryClass.getInstance();
    }

    public static Integer valueOf(int i) {
        // 一定範囲の値はキャッシュ済みのオブジェクトを返す
        // if (i >= IntegerCache.low && i <= IntegerCache.high) {
        // return IntegerCache.cache[i + (-IntegerCache.low)];
        // }
        return new Integer(i);
    }

    // public static Calendar getInstance(TimeZone zone) {
    // return createCalendar(zone, Locale.getDefault(Locale.Category.FORMAT));
    // }

    // private static Calendar createCalendar(TimeZone zone, Locale aLocale) {

    // if (aLocale.hasExtensions()) {
    // String caltype = aLocale.getUnicodeLocaleType("ca");
    // // ロケールに応じてカレンダーを選定
    // if (caltype != null) {
    // switch (caltype) {
    // case "buddhist":
    // cal = new BuddhistCalender(zone, aLocale);
    // break;

    // case "japanese":
    // cal = new JapaneseImperialCalender(zone, aLocale);
    // break;

    // case "gregory":
    // cal = new GregorianCalendar(zone, aLocale);

    // default:
    // break;
    // }

    // }

    // }
    // return cal;
    // }

    public static void staticBasic() {
        System.out.println(Figure.getTriangleArea(10, 20));
        // var f = new Figure();
        // System.out.println(f.getTriangleArea(10, 20));
        System.out.println(Figure.pi);
        Figure.getCircleArea(5);
    }

    public static void constantBasic() {
        System.out.println(MyApp.BOOK_TITLE);
        // MyApp.BOOK_TITLE = "本気でおぼえるJava";
        var app = new MyApp("Teach Yourself Java");
        System.out.println(app.APP_NAME);
    }

    public static void orderBasic() {
        var o = new Order();
    }

    public static void argsParamsBasic() {
        var v = new ArgsParams();
        System.out.println(v.totalProducts(12, 15, -1));
        System.out.println(v.totalProducts(5, 7, 8, 2, 4, 3));
    }

    public static void argsParamsBasicBad() {
        var v = new ArgsParams();
        // System.out.println(v.totalProducts());
    }

    public static void argsOverloadClient() {
        var arg = new ArgsOverload();
        arg.hoge(10, 13);
    }
}
