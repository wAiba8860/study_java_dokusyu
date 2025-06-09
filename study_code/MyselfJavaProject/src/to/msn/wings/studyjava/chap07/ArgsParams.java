package to.msn.wings.studyjava.chap07;

public class ArgsParams {

    public int totalProducts(int initial, int... values) {
        // if (values.length == 0) {
        // throw new IllegalArgumentException("1つ以上の引数を指定してください。");
        // }
        var result = initial;
        for (var value : values) {
            result *= value;
        }
        return result;
    }
}