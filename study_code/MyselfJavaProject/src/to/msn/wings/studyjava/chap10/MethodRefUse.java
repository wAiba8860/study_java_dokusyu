package to.msn.wings.studyjava.chap10;

public class MethodRefUse {
    // 配列要素の処理方法をメソッド参照で受け取れるように
    public void walkArray(String[] data, Output output) {
        for (var value : data) {
            output.print(value);
        }
    }

    // Output型に対応したメソッド（渡された文字列をブラケットでくくる）
    static void addQuote(String value) {
        System.out.printf("[%s]\n", value);
    }

    void addQuote2(String value) {
        System.out.printf("[%s]\n", value);
    }
}


// String型の引数を受取、戻り値はvoidであるメソッド型
@FunctionalInterface
interface Output {

    void print(String str);
}


// 関数型インターフェイスではない
// Invalid '@FunctionalInterface' annotation; Hoge1 is not a functional interface
// @FunctionalInterface
// interface Hoge1 {
// default void print() {};
// }


// // Invalid '@FunctionalInterface' annotation; Hoge2 is not a functional interface
// @FunctionalInterface
// interface Hoge2 {
// boolean equals(Object obj);
// }


// これは関数型インターフェイス
@FunctionalInterface
interface Hoge {
    void print(String str); // 抽象メソッドはこれだけ

    default void print() {};

    boolean equals(Object obj);
}
