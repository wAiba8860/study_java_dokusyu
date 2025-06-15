package to.msn.wings.studyjava.chap10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter10_1 {

    public static void main(String[] args) {
        streamRange();
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

    public static void collReplace() {
        var list = new ArrayList<String>(List.of("バラ", "チューリップ", "あさがお"));
        list.replaceAll((String v) -> {
            if (v.length() < 3) {
                return v;
            } else {
                return v.substring(0, 3);
            }
        });
        System.out.println(list);
    }

    public static void collReplaceMap() {
        var map = new HashMap<>(Map.of("orange", "みかん", "apple", "りんご", "strawberry", "いちご"));
        map.replaceAll((k, v) -> k.charAt(0) + v);
        System.out.println(map);
    }

    public static void collRemove() {
        var list = new ArrayList<>(List.of("バラ", "チューリップ", "あさがお", "ヒヤシンス"));
        list.removeIf((String v) -> v.length() > 4);
        System.out.println(list);
    }

    // compute / computeIfPresent用の設定メソッド（キーの頭文字を値に付与）
    public static String trans(String key, String value) {
        return key.charAt(0) + value;
    }

    // computeIfAbsent用の設定メソッド（キーそのものを値にも設定）
    public static String trans(String key) {
        return key;
    }

    public static void collCompute() {
        var map = new HashMap<String, String>(Map.of("orange", "みかん"));

        // computeメソッド（無条件に値を設定）
        // map.compute("orange", Chapter10_1::trans);
        // map.compute("melon", Chapter10_1::trans);
        // System.out.println(map);

        // computeIfPresentメソッド（値が存在する場合だけ設定）
        // map.computeIfPresent("orange", Chapter10_1::trans);
        // map.computeIfPresent("melon", Chapter10_1::trans);
        // System.out.println(map);

        // computeIfAbsentメソッド（値が存在しない場合だけ設定）
        map.computeIfAbsent("orange", Chapter10_1::trans);
        map.computeIfAbsent("melon", Chapter10_1::trans);
        System.out.println(map);
    }

    // marge用の結合関数
    public static String concat(String v1, String v2) {
        if (v2.isBlank()) {
            return null;
        }
        return v1 + "," + v2;
    }

    public static void collMerge() {
        var map = new HashMap<String, String>(Map.of("orange", "みかん"));
        map.merge("melon", "メロン", Chapter10_1::concat);
        map.merge("orange", "オレンジ", Chapter10_1::concat);
        map.merge("orange", "オレンジ", Chapter10_1::concat);
        System.out.println(map);

        map.merge("orange", "", Chapter10_1::concat);
        System.out.println(map);
    }

    public static void streamBasic() {
        // データソースを準備
        var list = List.of("ant", "elephant", "hamster");

        // ストリームによる処理
        var result = list.stream().filter(s -> s.length() > 3).map(String::toUpperCase);

        System.out.println(result);
        result.forEach(System.out::println);
    }

    public static void streamBasic2() {
        // リスト
        var list = List.of("ant", "elephant", "hamster");
        list.stream().forEach(System.out::println);
        System.out.println("------------------------");

        // 配列
        var data = new String[] {"バラ", "あさがお", "チューリップ"};
        Arrays.stream(data).forEach(System.out::println);
        System.out.println("------------------------");

        // マップ
        var map = Map.of("orange", "みかん", "apple", "りんご", "strawberry", "いちご");
        map.entrySet().stream().forEach(System.out::println);
    }

    public static void streamOf() {
        var stream = Stream.of("first", "second", "third");
        stream.forEach(System.out::println);
    }

    public static void streamGeneral() {
        var stream = Stream.generate(() -> {
            var r = new Random();
            return r.nextInt(100);
        });
        stream.limit(10).forEach(System.out::println);
    }

    public static void streamIterate() {
        var stream = Stream.iterate(1, num -> num * 2);
        stream.limit(10).forEach(System.out::println);
    }

    public static void streamBuild() {
        var builder = Stream.builder().add("いちじく").add("にんじん").add("さんしょ");
        builder.build().forEach(System.out::println);
    }

    public static void streamConcat() {
        var stream1 = Stream.of("いちじく", "ニンジン", "さんしょ");
        var stream2 = Stream.of("しいたけ", "ごぼう", "むくろじゅ");
        Stream.concat(stream1, stream2).forEach(System.out::println);
    }

    public static void streamRange() {
        IntStream.range(10, 20).forEach(System.out::print);
        System.out.println("\n");
        System.out.println("------------------------");
        IntStream.rangeClosed(10, 20).forEach(System.out::print);
    }
}
