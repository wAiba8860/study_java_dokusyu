package to.msn.wings.studyjava.chap06;

import java.util.ArrayList;
import java.util.List;

public class Rensyu6_2 {

    public static void main(String[] args) {
        System.out.println("[1]:");
        PList();
    }

    public static void PList() {
        var list = new ArrayList<Integer>(List.of(10, 15, 30));
        var list2 = new ArrayList<Integer>(List.of(60, 90));

        list.remove(0);
        list.set(1, 20);
        list.addAll(list.size(), list2);
        for (var i : list) {
            System.out.println(i);
        }
    }
}