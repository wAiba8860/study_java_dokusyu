package to.msn.wings.studyjava.chap09;

import java.util.ArrayList;
import java.util.List;

public class GenericBoundedStudy {

    public static void exampleGeneric() {

        // String型専用のリスト
        List<String> stringList = new ArrayList<>();
        stringList.add("こんにちは");
        // コンパイルエラー Stringしか入れられない
        // stringList.add(123);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(100);
        // コンパイルエラー
        // integerList.add("さようなら");

        Number num = 100; // IntegerはNumberの一種だから代入できる

        // エラー Type mismatch: cannot convert from List<Integer> to List<Number>
        // List<Number> NumberList = integerList;


        // 以下の代入が許されると
        // List<Number> numberList = integerList;

        // numberListはNumberのリストなので、Doubleを追加できるはず
        // numberList.add(3.14);


        // しかし、numberListの実際の型はintegerListだった
        // そのリストから値を取り出すと
        // Integer value = integerList.get(0); //Doubleを取り出すことになりエラー
    }

    // 数値のリスト（IntegerやDoubleなど）を受け取って、合計値を計算するメソッド
    public static double sum(List<? extends Number> numberList) {
        double total = 0.0;
        for (Number num : numberList) {
            total += num.doubleValue(); // 取り出した要素は少なくともNumberだと保証されている
        }

        // The method add(int, capture#2-of ? extends Number) in the type List<capture#2-of ?
        // extends Number> is not applicable for the arguments (int)
        // numberList.add(123) //コンパイルエラー
        return total;
    }

    public static void main(String[] args) {

        // 上限境界のリスト
        List<Integer> integerList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);

        System.out.println(sum(integerList));
        System.err.println(sum(doubleList));


        // 下限境界のリスト
        // Integerリスト
        List<Integer> integerList2 = new ArrayList<>();
        addIntegers(integerList2);
        System.out.println(integerList2);

        // Numberのリスト（Integerの親）
        List<Number> numberList = new ArrayList<>();
        addIntegers(numberList);
        System.out.println(numberList);

        // Objectのリスト（Integerの親）
        List<Object> objectList = new ArrayList<>();
        addIntegers(objectList);
        System.out.println(objectList);

        List<Number> numberList2 = new ArrayList<>();
        numberList2.add(3.14);
        List<? super Integer> list = numberList2;
        // エラー！
        // Integer i = list.get(0);
    }

    // 何ができる？(読み取り)

    // numberList から要素を取り出す（getする）ことができます。取り出した要素は、
    // その正体が Integerか Double かは分かりませんが、
    // 少なくとも Number であることは保証されています。なので、
    // Number 型の変数で受け取ることができます。


    // 何ができない？(書き込み)

    // numberList に新しい要素を追加（addする）ことはできません（null以外）。なぜなら、
    // コンパイラは numberList の本当の型を知らないからです。
    // もしそれが List<Double>
    // だったら Integer を追加できませんし、逆もまた然りです。安全のため、書き込みは禁止されています。

    // 覚え方:extends は、中身を**取り出して使う（Producer）場合に使い、「読み取り専用」**のイメージです。


    // Integerのリスト、またはその親クラスのリストに、1から3までの整数を追加するメソッド
    public static void addIntegers(List<? super Integer> list) {
        // List<Integer>,List<Number>,List<Object>のいずれであっても、Integerはその要素になれる
        list.add(1);
        list.add(2);
        list.add(3);

        Object obj = list.get(0); // Objectとしてしか取り出せない
        // Type mismatch: cannot convert from capture#6-of ? super Integer to Number
        // Number num = list.get(0); コンパイルエラー
    }

    // 何ができる？(書き込み)

    // list に Integer 型の要素を追加（addする）ことができます。
    // なぜなら、この listの型が List<Integer>、List<Number>、List<Object> のいずれであっても、Integer は安全にその要素になれるからです。

    // 何ができない？(読み取り)

    // list から取り出した要素を
    // Integer 型として扱うことはできません。唯一保証されているのは、
    // それが Object の一種であることだけです。なぜなら、
    // list の正体が List<Number> や List<Object> かもしれず、その場合、
    // 中には Integer 以外のもの（
    // 例えば Double）が入っている可能性があるからです。

    // 覚え方:super は、中に要素を**追加して消費させる（Consumer）場合に使い、「書き込み専用」**のイメージです。
}
