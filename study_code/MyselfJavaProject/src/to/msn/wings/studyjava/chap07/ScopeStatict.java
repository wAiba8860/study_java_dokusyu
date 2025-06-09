package to.msn.wings.studyjava.chap07;

public class ScopeStatict {
    // ◯
    String str1 = "いろはにほへと";
    String str2 = str1;
    // ✕
    // String str2 = str1;
    // String str1 = "いろはにほへと";

    public void show() {
        System.out.println(str);
    }

    String str = "いろはにほへと";
}