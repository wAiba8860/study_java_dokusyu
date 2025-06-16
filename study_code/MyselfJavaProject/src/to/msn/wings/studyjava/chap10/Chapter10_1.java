package to.msn.wings.studyjava.chap10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter10_1 {

    public static void main(String[] args) {
        streamThen();
    }

    public static void methodRefUnuseBasic() {
        // 文字列配列dataの内容を順に出力
        var data = new String[] { "春はあけぼの", "夏はよる", "秋は夕暮れ" };
        var un = new MethodRefUnuse();
        un.walkArray(data);
    }

    public static void MethodRefUseBasic() {
        var data = new String[] { "はるはあけぼの", "夏は夜", "秋は夕暮れ" };
        var u = new MethodRefUse();
        System.out.println("staticメソッド");
        u.walkArray(data, MethodRefUse::addQuote);
        System.out.println("インスタンス・メソッド");
        u.walkArray(data, u::addQuote2);
    }

    public static void CounterBasic() {
        var data = new String[] { "春は曙", "夏は夜", "秋は夕暮れ" };
        var u = new MethodRefUse();
        var c = new Counter();
        u.walkArray(data, c::addLength);
        System.out.println(c.getResult());
    }

    public static void MethodLambdaBasic() {
        var data = new String[] { "春はあけぼの", "夏は夜", "秋は夕暮れ" };
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
        var data = new String[] { "バラ", "あさがお", "チューリップ" };
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

    public static void streamFilter() {
        Stream.of("https://www.shoeisha.co.jp/", "SEshop", "https://codezine.jp", "https://wings.msn.to/",
                "WingsProject")
                .filter(s -> s.startsWith("https://"))
                .forEach(System.out::println);
    }

    public static void streamMap() {
        Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                // .map(s -> s.length()).forEach(System.out::println);
                .mapToInt(s -> s.length()).forEach(System.out::println);
    }

    public static void streamFlat() {
        var list = List.of(List.of("あいう", "かきく", "さしす"),
                List.of("たちつ", "なにぬ"),
                List.of("はひふ", "まみむ"));
        list.stream()
                // .flatMap(v -> v.stream()).forEach(System.out::println);
                // .map(v -> v.stream()).forEach(System.out::println);
                .flatMap(v -> v.stream().map(str -> str.substring(0, 1))).forEach(System.out::println);
    }

    public static void streamMulti() {
        var list = List.of(List.of("あいう", "かきく", "さしす"),
                List.of("たちつ", "なにぬ"),
                List.of("はひふ", "まみむ"));
        list.stream().<String>mapMulti((sublist, consumer) -> {
            for (var str : sublist) {
                consumer.accept(str);
            }
        }).forEach(System.out::println);
    }

    public static void streamSort() {
        Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                // .sorted().forEach(System.out::println);
                // .sorted((String str1, String str2) -> {
                // return (str1.length() - str2.length());
                // })
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    public static void streamLimit() {
        IntStream.range(1, 20).skip(4).limit(10).forEach(System.out::println);
    }

    public static void streamDrop() {
        IntStream.of(-2, -5, 0, 3, -1, -2).dropWhile(i -> i < 0).forEach(System.out::println);
    }

    public static void streamTake() {
        IntStream.of(-2, -5, 0, 3, -1, 2).takeWhile(i -> i < 0).forEach(System.out::println);
    }

    public static void streamPeek() {
        Stream.of("さかな", "あか", "こだま", "きんもくせい")
                .peek(System.out::println)
                .sorted()
                .forEach(System.out::println);
    }

    public static void streamDistinct() {
        Stream.of("あか", "さかな", "あか", "こだま", "こだま")
                .distinct()
                .forEach(System.out::println);
    }

    public static void streamDistinctObj() {
        var set = new HashSet<>();
        Stream.of(new PersonStream("山田", 40),
                new PersonStream("高野", 30),
                new PersonStream("大川", 35),
                new PersonStream("山田", 45))
                .filter(p -> set.add(p.name))
                .forEach(System.out::println);
    }

    public static void streamCast() {
        IntStream.rangeClosed(1, 5).asDoubleStream().forEach(System.out::println);
    }

    public static void streamBoxed() {
        IntStream.range(1, 5).boxed()
                .forEach(System.out::println);
        IntStream.range(1, 5).mapToObj(Integer::valueOf)
                .forEach(System.out::println);
    }

    public static void streamUnboxed() {
        Stream.of(1, 2, 3, 4)
                // アンボクシング（Integer -> int）
                .mapToInt(i -> i).forEach(System.out::println);
    }

    public static void mapToPrimitiveExample() {
        // 文字列リストから数値として解釈できるものだけをIntStreamとして扱う
        List<String> list = Arrays.asList("Hello", "10", "20", "Bye");
        list.stream().filter(value -> value.matches("\\d+")) // 数値文字列だけをフィルタリング
                .mapToInt(Integer::parseInt) // intにパースしてIntStreamへ
                .forEach(System.out::println);
    }

    public static void streamForEach() {
        Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                .parallel() // 並列化
                // .forEach(v -> System.out.println(v));
                .forEachOrdered(v -> System.out.println(v)); // 並列処理でも順序を保証
    }

    public static void streamFind() {
        var str = Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら", "もも")
                .parallel()
                .filter(s -> s.startsWith("さ"))
                // .findFirst();
                .findAny();
        System.out.println(str.orElse("--"));
        System.out.println(str);
    }

    public static void streamMatch() {
        System.out.println(
                IntStream.of(1, 10, 5, -5, 12)
                        // .allMatch(v -> v >= 0)); false
                        .anyMatch(v -> v >= 0));
    }

    public static void streamTrans() {
        var list = Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                .filter(s -> s.startsWith("さ"))
                .toArray();
        System.out.println(Arrays.toString(list));
    }

    public static void streamTrans2() {
        var list = Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                .filter(s -> s.startsWith("さ"))
                // .collect(Collectors.toList());
                .toList();
        System.out.println(list);
    }

    public static void streamCollectMap() {
        System.out.println(
                Stream.of(
                        new PersonMap("山田太郎", "tyamada@example.com"),
                        new PersonMap("鈴木花子", "hsuzuki@exapmle.com"),
                        new PersonMap("井上三郎", "sinoue@example.com"),
                        new PersonMap("佐藤久美", "ksatou@example"),
                        new PersonMap("山田太郎", "yamataro@example.com"))
                        .collect(Collectors.toMap(PersonMap::getName, PersonMap::getEmail, (s, a) -> s + "/" + a)));
    }

    public static void streamMin() {
        var str = Stream.of("めばる", "さんま", "ひらめ", "いわし", "ほっけ")
                .min(Comparator.naturalOrder());
        System.out.println(str.orElse("null"));
    }

    public static void streamCount() {
        System.out.println(
                Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                        .filter(s -> s.length() > 3)
                        .count());
    }

    public static void streamSum() {
        var list = new int[] { 5, 1, 10, -3 };
        System.out.println(IntStream.of(list).sum());
        System.out.println(IntStream.of(list).average().orElse(0));
    }

    public static void streamReduce() {
        System.out.println(
                Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                        .sorted()
                        .reduce((result, str) -> result + "," + str)
                        .orElse(""));

        // forループ
        var list = new String[] { "バラ", "あさがお", "チューリップ", "さくら" };
        Arrays.sort(list);
        var result = "";
        for (var str : list) {
            result += str + ",";
        }
        System.out.println(result);
    }

    public static void streamReduce2() {
        System.out.println(
                Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                        .sorted()
                        .parallel()
                        .reduce("ひまわり", (result, str) -> result + "," + str));
    }

    public static void streamReduce3() {
        System.out.println(
                Stream.of("153", "211", "112", "350", "418", "208")
                        .parallel()
                        .reduce(0,
                                // 個々の要素を演算
                                (result, value) -> result + Integer.parseInt(value),
                                // 分散された結果をまとめ
                                (result1, result2) -> result1 + result2));
    }

    public static void streamCollect() {
        System.out.println(
                Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                        .sorted()
                        .collect(
                                ArrayList<String>::new,
                                (list, str) -> list.add(str),
                                (list1, list2) -> list1.addAll(list2)));
    }

    public static void streamCollectOf() {
        System.out.println(
                Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                        .sorted()
                        .collect(Collector.of(ArrayList<String>::new, (list, str) -> list.add(str), (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        },
                                Collector.Characteristics.IDENTITY_FINISH)));
    }

    public static void streamCollectOf2() {
        System.out.println(
                Arrays.toString(
                        Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                                .sorted()
                                .collect(Collector.of(ArrayList<String>::new, (list, str) -> list.add(str),
                                        (list1, list2) -> {
                                            list1.addAll(list2);
                                            return list1;
                                        }, list -> list.toArray()))));
    }

    public static void streamJoining() {
        System.out.println(
                Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                        .sorted()
                        .collect(Collectors.joining(",", "<", ">")));
    }

    public static void streamGrouping() {
        System.out.println(
                Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                        .sorted()
                        .collect(Collectors.groupingBy(str -> str.length())));
    }

    public static void streamGrouping2() {
        System.out.println(
                Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                        .sorted()
                        .collect(Collectors.groupingBy(
                                str -> str.length(),
                                Collectors.joining("/"))));
    }

    public static void streamPartition() {
        System.out.println(
                Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                        .sorted()
                        .collect(
                                Collectors.partitioningBy(
                                        str -> str.length() > 3)));
    }

    public static void streamThen() {
        System.out.println(
                Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                        .sorted()
                        .collect(
                                Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)));
    }
}