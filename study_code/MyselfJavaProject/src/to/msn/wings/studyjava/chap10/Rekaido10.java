package to.msn.wings.studyjava.chap10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Rekaido10 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        System.out.println("x:匿名クラスよりもラムダ式／メソッド参照の方が可読性に優れるため");
        System.out.println("x:引数は省略できるが()が必要");
        System.out.println("x:終端処理は省略できない");
        System.out.println("x:sequentialメソッドを利用することで直列化が可能");
        System.out.println("x:保証されない forEachOrderedメソッドを利用する");
        System.out.println("[2]:");

        var data = List.of("ラベンダー", "ミント", "ローズマリー");
        // 3文字より長い文字列だけを抽出
        var result = grep(data, v -> {
            return v.length() > 3;
        });
        System.out.println(result);

        System.out.println("[3]:");
        practice3();

    }

    public static <T> List<T> grep(List<T> list, Predicate<T> cond) {
        var result = new ArrayList<T>();
        for (var value : list) {
            if (cond.test(value)) {
                result.add(value);
            }
        }
        return result;
    }

    @FunctionalInterface
    public interface Hoge {
        void print(String str);
    }

    @FunctionalInterface
    public interface Foo<T, R> {
        R process(T v1, T v2);
    }

    public static void practice3() {
        var data1 = new ArrayList<>(List.of("ABCDE", "OP", "WXYZ", "HIJKL"));
        data1.replaceAll(value -> {
            if (value.length() > 3) {
                return value.substring(0, 3);
            } else {
                return value;
            }
        });
        System.out.println(data1);

        Stream.of("シュークリーム", "プリン", "マドレーヌ", "ババロア").sorted((v1, v2) -> v1.length() - v2.length())
                .forEach(System.out::println);

        var list = new int[] {60, 95, 75, 80, 70};
        System.out.println(IntStream.of(list).max().orElse(0) + "点");
        System.out.println(IntStream.of(list).average().orElse(0) + "点");
    }
}
