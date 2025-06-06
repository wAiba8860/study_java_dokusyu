package to.msn.wings.studyjava.chap06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Chapter6_2 {

    public static void main(String[] args) {
        SetTree();
    }

    public static void ListArray() {
        var list = new ArrayList<Integer>(List.of(10, 15, 30, 60));
        var list2 = new ArrayList<Integer>(List.of(1, 5, 3, 6));
        var list3 = new ArrayList<Integer>(List.of(1, 2, 3));

        for (var i : list) {
            System.out.println(i / 5);
        }

        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.contains(30));
        System.out.println(list.indexOf(30));
        System.out.println(list.lastIndexOf(30));
        System.out.println(list.isEmpty());
        System.out.println(list.remove(0));
        System.out.println(list);

        list.addAll(list2);
        System.out.println(list);

        list.removeAll(list3);
        System.out.println(list);

        list.set(0, 100);
        var data = list.toArray();
        System.out.println(Arrays.toString(data));
    }

    public static void ListLinked() {
        var list = new ArrayList<String>(List.of("うさぎ", "たつ", "へび"));
        System.out.println(list);

        list.addFirst("とら");
        list.addLast("うま");

        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list);
    }

    public static void SetBasic() {
        var hs = new HashSet<Integer>(List.of(1, 20, 30, 10, 30, 60, 15));
        var hs2 = new HashSet<Integer>(List.of(10, 20, 99));

        System.out.println(hs);
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());
        System.out.println(hs.contains(1));
        System.out.println(hs.containsAll(hs2));
        System.out.println(hs.remove(1));
        System.out.println(hs);

        hs.addAll(hs2);
        System.out.println(hs);

        hs.retainAll(hs2);
        System.out.println(hs);

        var hs3 = new HashSet<Integer>(List.of(1, 10, 20));
        hs.removeAll(hs3);
        System.out.println(hs);
    }

    public static void SetTree() {
        var ts = new TreeSet<Integer>(List.of(1, 20, 30, 10, 60, 15));
        System.out.println(ts);
        System.out.println(ts.descendingSet());
        System.out.println(ts.ceiling(15));
        System.out.println(ts.lower(15));
        System.out.println(ts.tailSet(15));
        System.out.println(ts.headSet(30, true));
    }
}
