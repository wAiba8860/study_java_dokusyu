package to.msn.wings.studyjava.chap06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Chapter6_3 {

    public static void main(String[] args) {
        MapHashLinked();
    }

    public static void MapHash() {
        var map = new HashMap<String, String>(
                Map.of("Rose", "バラ", "Sunflower", "ひまわり", "Morning Glory", "あさがお"));
        System.out.println(map.containsKey("Rose"));
        System.out.println(map.containsValue("バラ"));
        System.out.println(map.isEmpty());

        for (var key : map.keySet()) {
            System.out.println(key);
        }

        for (var value : map.values()) {
            System.out.println(value);
        }

        map.replace("Rose", "薔薇");
        map.replace("Sunflower", "ひまわり", "向日葵");

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void MapHashIdentity() {
        var key1 = Integer.valueOf(256);
        var key2 = Integer.valueOf(256);

        var data = new IdentityHashMap<Integer, String>() {
            // var data = new HashMap<Integer, String>() {
            {
                put(key1, "Hoge");
                put(key2, "Foo");
            }
        };
        System.out.println(data);
    }

    public static void MapTree() {
        var data = new TreeMap<String, String>(
                Map.of("Rose", "バラ", "Sunflower", "ひまわり", "Morning Glory", "あさがお"));
        for (var key : data.keySet()) {
            System.out.println(key);
        }
    }

    public static void MapTreeSort() {
        // ソート順を指定したTreeMap
        // var data = new TreeMap<String, String>((x, y) -> x.length() - y.length());
        var data = new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return x.length() - y.length();
            }
        });
        data.put("Rose", "バラ");
        data.put("Sunflower", "ひまわり");
        data.put("Morning Glory", "あさがお");
        System.out.println(data);
    }

    public static void SortList() {
        var data = new String[] {"バラ", "ひまわり", "チューリップ", "さくら"};
        Arrays.sort(data, (x, y) -> x.length() - y.length());
        System.out.println(Arrays.toString(data));

        var list = new ArrayList<String>(List.of("バラ", "ひまわり", "チューリップ", "さくら"));
        list.sort((x, y) -> x.length() - y.length());
        System.out.println(list);
    }

    public static void MapNavigable() {
        var data = new TreeMap<String, String>() {
            {
                put("peak", "高くなる");
                put("peach", "もも");
                put("peace", "1切れ");
                put("piece", "平和");
            }
        };

        var key = "pear";

        if (data.containsKey(key)) {
            System.out.println(key + "は" + data.get(key) + "です。");
        } else {
            System.out.print("検索中の単語は");
            System.out.print(data.lowerKey(key) + "または");
            System.out.print(data.higherKey(key));
            System.out.println("ですか？");
        }
    }

    public static void MapHashLinked() {

        var data = new LinkedHashMap<String, String>(10, 0.7f, true) {
            {
                put("aaa", "あいうえお");
                put("bbb", "かきくけこ");
                put("ccc", "さしすせそ");
                put("ddd", "たちつてと");
            }
        };
        System.out.println(data.get("ccc"));
        System.out.println(data.get("aaa"));
        System.out.println(data.get("bbb"));
        System.out.println(data.get("ddd"));

        System.out.println(data);
    }
}
