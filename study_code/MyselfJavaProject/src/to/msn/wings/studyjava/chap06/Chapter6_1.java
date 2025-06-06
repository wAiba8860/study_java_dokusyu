package to.msn.wings.studyjava.chap06;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Chapter6_1 {
    public static void main(String[] args) {
        CollUnmodifyRef();
    }

    public static void example() {
        List<String> data = new ArrayList<>();

        ArrayList<String> data2 = new ArrayList<>();
        LinkedList<String> data3 = new LinkedList<>();

        List data4 = new ArrayList<>();
        data4.add("あいうえお");
        data4.add("かきくけこ");
        String str = (String) data4.get(0);
        System.out.println(str);

        // List data5 = new ArrayList<>();
        // data5.add(12345);
        // String str = (String)data5.get(0);

        // ジェネリクス
        List<String> data6 = new ArrayList<>();
        data6.add("あいうえお");
        String str2 = data6.get(0);
        // エラー data6.add(12345);

        // var map = new HashMap<String,Person>();
        var data7 = new ArrayList<String>();
        var data8 = new ArrayList<>();

        // return Collections.emptyList();

        var set = Collections.singleton("バラ");
        var data9 = Collections.synchronizedList(new ArrayList<String>());

        var map = new ConcurrentHashMap<String, String>();
        var list = new CopyOnWriteArrayList<String>();
    }

    public static void collInitial() {
        var data = new ArrayList<>() {
            {
                add("バラ");
                add("ひまわり");
                add("あさがお");
            }
        };
    }

    public static void collUnmodifyOf() {
        var data = List.of("バラ", "あさがお", "ひまわり");
        System.out.println(data);

        var map = Map.of("Rose", "バラ", "Sunflower", "ひまわり", "Morning Glory", "あさがお");
    }

    public static void CollForeach() {
        var data = List.of("バラ", "あさがお", "ひまわり");

        for (var s : data) {
            System.out.println(s);
        }

        var itr = data.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void iteratorRemove() {
        var data = new ArrayList<>(List.of("バラ", "あさがお", "ひまわり"));

        var itr = data.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            itr.remove();
        }
        System.out.println(data);
    }

    public static void iteratorRemoveBad() {
        // エラーConcurrentModificationException
        var data = new ArrayList<>(List.of("バラ", "あさがお", "ひまわり"));
        for (var s : data) {
            System.out.println(s);
            data.remove(s);
        }
    }

    public static void iteratorList() {
        var data = new ArrayList<>(List.of("バラ", "あさがお", "ひまわり"));
        var itr = data.listIterator(data.size());
        while (itr.hasPrevious()) {
            System.out.println(itr.previous());
        }
    }

    public static void CollAsList() {
        var data = new String[] {
                "バラ", "ひまわり", "あさがお"
        };

        var list = Arrays.asList(data);
        list.set(0, "チューリップ");

        System.out.println(list);
        System.out.println(Arrays.toString(data));

        // エラーUnsupported
        // list.add("さくら");
        // list.remove(0);

        var list2 = new ArrayList<>(Arrays.asList(data));
        System.out.println(list2);

        list2.add("さくら");
        list2.remove(0);
        System.out.println(list2);
        System.out.println(Arrays.toString(data));
    }

    public static void CollAddAll() {
        var data = new String[] {
                "バラ", "ひまわり", "あさがお"
        };
        var list = new ArrayList<String>();
        Collections.addAll(list, data);
        list.set(0, "チューリップ");
        list.add("さくら");
        list.remove(0);

        System.out.println(list);
        System.out.println(Arrays.toString(data));
    }

    public static void CollToArray() {
        var data = new ArrayList<String>(List.of("バラ", "ひまわり", "あさがお"));

        // リストと同じサイズの配列strsに中身をコピー
        var strs = new String[data.size()];
        data.toArray(strs);

        // 値を変更して、配列／リストの内容を確認
        data.set(0, "チューリップ");
        System.out.println(Arrays.toString(strs));
        System.out.println(data);
    }

    public static void CollUnmodify() {
        var data = new ArrayList<String>() {
            {
                add("バラ");
                add("ひまわり");
                add("あさがお");
            }
        };

        var udata = Collections.unmodifiableList(data);
        udata.set(0, "チューリップ");
        udata.remove(0);
    }

    public static void CollUnmodifyRef() {
        var data = new ArrayList<StringBuilder>(Arrays.asList(
                new StringBuilder("ひふみ"),
                new StringBuilder("よいむ"),
                new StringBuilder("なやこ")));

        var udata = Collections.unmodifiableList(data);
        udata.get(0).append("いちにさん");
        System.out.println(udata);
    }
}