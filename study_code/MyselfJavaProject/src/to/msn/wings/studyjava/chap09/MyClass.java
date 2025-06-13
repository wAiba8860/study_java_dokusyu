package to.msn.wings.studyjava.chap09;

public class MyClass {
    // staticメンバークラスの定義
    public static class MyHelper {
        public void show() {
            System.out.println("Nested class is running!");
        }
    }

    public void run() {
        var helper = new MyHelper();
        helper.show();
    }
}
