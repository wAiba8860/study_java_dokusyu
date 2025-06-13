package to.msn.wings.studyjava.chap09;

public class GenericConstraint<T extends Comparable<T>> {
    public int Hoge(T x, T y) {
        return x.compareTo(y);
    }

    public static void main(String[] args) {
        var m = new GenericConstraint<String>();
        // Comparableを実装していないのでエラー
        // var n = new GenericConstraint<Person>();
    }
}
