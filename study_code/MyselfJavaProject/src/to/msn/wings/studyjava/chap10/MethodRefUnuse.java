package to.msn.wings.studyjava.chap10;

public class MethodRefUnuse {
    // 文字列配列の内容をブラケット付きで出力
    public void walkArray(String[] data) {
        for (var value : data) {
            System.out.printf("[%s]\n", value);
        }
    }
}
