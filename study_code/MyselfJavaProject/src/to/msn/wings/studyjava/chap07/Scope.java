package to.msn.wings.studyjava.chap07;

public class Scope {

    public String data = "フィールド";

    public String show() {
        var data = "ローカル";
        // return data;
        return this.data;
    }
}