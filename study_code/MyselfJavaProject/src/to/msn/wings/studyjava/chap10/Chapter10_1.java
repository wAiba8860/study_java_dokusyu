package to.msn.wings.studyjava.chap10;

import java.util.function.Consumer;

public class Chapter10_1 {

    public static void main(String[] args) {
        MethodLambdaBasic();
    }

    public static void methodRefUnuseBasic() {
        // 文字列配列dataの内容を順に出力
        var data = new String[] {"春はあけぼの", "夏はよる", "秋は夕暮れ"};
        var un = new MethodRefUnuse();
        un.walkArray(data);
    }

    public static void MethodRefUseBasic() {
        var data = new String[] {"はるはあけぼの", "夏は夜", "秋は夕暮れ"};
        var u = new MethodRefUse();
        System.out.println("staticメソッド");
        u.walkArray(data, MethodRefUse::addQuote);
        System.out.println("インスタンス・メソッド");
        u.walkArray(data, u::addQuote2);
    }

    public static void CounterBasic() {
        var data = new String[] {"春は曙", "夏は夜", "秋は夕暮れ"};
        var u = new MethodRefUse();
        var c = new Counter();
        u.walkArray(data, c::addLength);
        System.out.println(c.getResult());
    }

    public static void MethodLambdaBasic() {
        var data = new String[] {"春はあけぼの", "夏は夜", "秋は夕暮れ"};
        var ml = new MethodLambda();
        ml.walkArray(data, (String value) -> {
            System.out.printf("[%s]\n", value);
        });
        ml.walkArray(data, (String value) -> System.out.printf("[%s]\n", value));
        ml.walkArray(data, value -> System.out.printf("[%s]\n", value));
        ml.walkArray(data, new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.printf("[%s]\n", value);
            }
        });
    }
}
