package to.msn.wings.studyjava.chap06;

import java.util.ArrayList;
import java.util.List;

public class Rensyu6_1 {

    public static void main(String[] args) {
        System.out.println("[1]:");
        System.out.println("ジェネリクスとは汎用的なクラス／メソッドを特定の方にひもづけるためのしくみ");
        System.out.println("非ジェネリクスなコレクションでは、すべての要素はObject型としてみなされる");
        System.out.println("ジェネリクスを扱うことによって、型安全を保証できる。");

        System.out.println("[2]:");
        var data = new ArrayList<Integer>(List.of(16, 24, 30, 39));
    }
}