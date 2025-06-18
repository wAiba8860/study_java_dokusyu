package to.msn.wings.studyjava.chap11;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import mylib.lib.MainLib;
import mylib.internal.SubLib;

public class Chapter11_2 {
    private Integer value;

    public static void main(String[] args) {
        moduleClient2();
    }

    public static void personOverride() {
        var p = new Person("ai", "setsuna");
        System.out.println(p.toString());
    }

    /**
     * @deprecated It is rarely appropriate to use this constructor. The static factory
     *             {@link #valueOf(int)} is generally a better choice, as it is likely to yield
     *             significantly better space and time performance.
     */
    @Deprecated(since = "9")
    public Chapter11_2(int value) {
        this.value = value;
    }

    public static void annotationSuppress() {
        @SuppressWarnings({"unused", "deprecation", "cast", "all"})
        // 未使用警告が表示されなくなる
        var i = 0;
    }

    public void hoge(List<String>... args) {
        // 可変長引数args経由の潜在的なヒープ汚染
    }

    @SafeVarargs
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Object[]型に対して、List<Integer>型を代入（OK）
        String s = stringLists[0].get(0); // 実態はInteger型なのでエラー
    }

    public static void reflectInstance() {
        // Fileクラスを取得
        var clazz = File.class;

        try {
            // コンストラクター経由でFileオブジェクトを生成
            var c = clazz.getConstructor(String.class);
            var fl = c.newInstance("C:/data/data.txt");
            System.out.println(fl);

            // サイズ2の配列を生成
            var list = (File[]) Array.newInstance(File.class, 2);
            Array.set(list, 0, fl);
            System.out.println(Arrays.toString(list));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void reflectMethod() {
        // Fileクラスを取得
        var fl = File.class;

        // File配下のpublicメソッドを列挙
        for (var m : fl.getMethods()) {
            System.out.println(m.getName());
        }
    }

    public static void reflectInvoke() {
        // Fileクラスを取得
        var clazz = File.class;

        // Fileオブジェクトを生成
        try {
            var f1 = clazz.getConstructor(String.class).newInstance("C:/data/data.txt");
            var f2 = clazz.getConstructor(String.class).newInstance("C:/data/sample.txt");

            // renameToメソッドを取得＆実行
            Method m = clazz.getMethod("renameTo", File.class);
            System.out.println(m.invoke(f1, f2));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void reflectField() {
        var clazz = Person.class;
        try {
            var con = clazz.getConstructor(String.class, String.class);
            var p = con.newInstance("太郎", "山田");
            var last = clazz.getDeclaredField("lastName");
            last.setAccessible(true);
            last.set(p, "鈴木");
            System.out.println(last.get(p));
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                | InvocationTargetException | NoSuchFieldException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void moduleClient() {
        var main = new MainLib();
        main.run();
    }

    public static void moduleClient2() {
        var clazz = MainLib.class;
        var con = clazz.getConstructor();
        var m = con.newInstance();
        var name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(m));
    }
}
