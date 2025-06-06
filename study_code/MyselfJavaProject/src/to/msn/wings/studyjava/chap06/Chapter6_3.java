package to.msn.wings.studyjava.chap06;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Chapter6_3 {

    public static void main(String[] args) {
        MapHashIdentity();
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
}
