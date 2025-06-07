package to.msn.wings.studyjava.chap06;

import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Chapter6_3 {

    public static void main(String[] args) {
        MapTreeSort();
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
}
