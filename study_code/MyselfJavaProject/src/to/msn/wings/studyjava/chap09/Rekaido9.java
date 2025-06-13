package to.msn.wings.studyjava.chap09;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rekaido9 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        System.out.println("x:tryブロックで発生した例外が、catchブロックの例外の包含関係にある場合に実行｜catchブロックのそれと一致または派生クラスである場合に呼び出される");
        System.out.println("x:非staticはメモリの消費量が多いため可能な限りstaticとして宣言、または参照の存在がエンクロージングオブジェクトの破棄を妨げることがあるため");
        System.out.println("o");
        System.out.println("x:valuesメソッドの誤り、nameメソッドは列挙定数の定義名を返す");
        System.out
                .println("x:ジェネリクスは既定では不変の性質を持つ、よって型パラメーター同士に継承関係があってもArrayList<Child>型はArrayList<Parent>型の変数には代入できない");
        System.out.println("[2]:");
        System.out.println("[3]:");
        System.out.println("[4]:");
    }

    public static <T> boolean addAll(Collection<? super T> c, T... elements) {
        boolean result = false;
        for (T element : elements) {
            result |= c.add(element);
        }
        return result;
    }

    public static void weekdayPra() {
        var day = Weekday.valueOf("Monday");
        System.out.println(day instanceof Weekday);
    }

    // public static void tryCatch() {
    // try {

    // } catch (IOException | SQLException e) {
    // // TODO: handle exception
    // }
    // }

    public static <T> ArrayList<T> newArrayList(T... values) {
        return new ArrayList<T>(List.of(values));
    }

}

class PersonPra implements Cloneable {
    private String firstName;
    private String lastName;
    private String[] memos;

    public PersonPra(String firstName, String lastName, String[] memos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memos = memos;
    }

    @Override
    public PersonPra clone() {
        PersonPra p = null;
        try {
            p = (PersonPra) super.clone();
            p.memos = this.memos.clone();
        } catch (CloneNotSupportedException e) {
            // TODO: handle exception
            throw new AssertionError();
        }
        return p;
    }
}

class PersonPra4 {
    public String firstName;
    public String lastName;

    public PersonPra4(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("PersonPra4:%s %s ", this.firstName, this.lastName);
    }
}

enum Weekday {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
}

class Main {
    private static class Sub {

    }
}