package to.msn.wings.studyjava.chap10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rensyu10_1 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        practice1();
        System.out.println("[2]:");
        practice2();
    }

    public static void practice1() {
        // (int i) -> {return i * i;}

        var pra = new HashMap<>(Map.of(1, 4));
        pra.compute(1, (Integer k, Integer v) -> {
            return v * v;
        });

        var praList = new ArrayList<>(List.of(3, 6, 9));
        praList.replaceAll(value -> value * value);
        System.out.println(pra);
        System.out.println(praList);
    }

    public static void practice2() {
        var list = new ArrayList<>(List.of("メロン", "ストロベリー", "オレンジ", "パイナップル", "シャインマスカット"));
        list.removeIf((String value) -> {
            return value.length() < 5;
        });
        System.out.println(list);
    }
}
