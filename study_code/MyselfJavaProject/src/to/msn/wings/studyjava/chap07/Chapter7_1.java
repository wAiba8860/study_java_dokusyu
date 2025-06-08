package to.msn.wings.studyjava.chap07;

import java.util.regex.Pattern;

public class Chapter7_1 {

    public static void main(String[] args) {
        fieldBasic();
        methodBasic();
        overloadAntiClient();
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
    }

    // public String[] split(String regex, int limit) {
    // return Pattern.compile(regex).split(this, limit);
    // }

    // public String[] split(String regex) {
    // return split(regex,0);
    // }

    public static void overloadAntiClient() {
        var c = new OverloadAnti();
        var list =
                new CharSequence[] {"春はあけぼの", new StringBuilder("夏は夜"), new StringBuffer("秋は夕暮れ")};

        for (var cs : list) {
            c.show(cs);
        }
    }
}


