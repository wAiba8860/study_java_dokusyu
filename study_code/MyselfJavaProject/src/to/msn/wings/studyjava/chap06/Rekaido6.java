package to.msn.wings.studyjava.chap06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rekaido6 {

    public static void main(String[] args) {
        System.out.println("[1]:");
        practice1();
        System.out.println("[2]:");
        practice2();
        System.out.println("[3]");
        practice3();
    }

    public static void practice1() {
        System.out.println(
                "x:ArrayListは内部的に配列を採用しているため、先頭の要素の操作は低速,x:要素の移動が不要で、リンクの付替えだけで済むので比較的高速,x:Setは順序付けなし,o,x:スタックは後入れ先出しLastInFirstOut キューは先入れ先出しFirstInFirstOut");
    }

    public static void practice2() {
        var map = new HashMap<String, String>(
                Map.of("cucumber", "キュウリ", "lettuce", "レタス", "spinach", "ホウレンソウ"));

        map.put("carrot", "ニンジン");
        map.remove("spinach");
        map.replace("cucumber", "胡瓜");

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void practice3() {
        // 型パラメーターがない
        var list = new ArrayList<Integer>(List.of(1, 2, 3, 4));
        list.add(100);
        list.set(2, 30);
        // インデックス指定ミス
        list.remove(3);
        // 型宣言がIntegerではなくString
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
