package to.msn.wings.studyjava.chap06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chapter6_2 {

    public static void main(String[] args) {
        ListLinked();
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
}