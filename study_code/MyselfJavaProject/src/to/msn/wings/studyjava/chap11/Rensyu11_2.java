package to.msn.wings.studyjava.chap11;

import mylib.lib.MainLib;
import mylib.internal.Sublib;

public class Rensyu11_2 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        System.out.println("[2]:");
        practice2();
    }

    @Deprecated(since = "9")
    public static void practice1() {

    }

    public static void practice2() {
        try {
            var clazz = String.class;
            var con = clazz.getConstructor(String.class);
            var str = con.newInstance("こんにちは、Java");
            var m = clazz.getDeclaredMethod("substring", int.class, int.class);
            System.out.println(m.invoke(str, 6, 10));

        } catch (

        Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void moduleClient() {
        var main = new MainLib();
        main.run();
    }
}
