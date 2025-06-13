package to.msn.wings.studyjava.chap09;

public class Rensyu9_3 {

    public static void main(String[] args) {
        System.out.println("[1]:");
        for (var wd : Weekday.values()) {
            System.out.println(wd.ordinal() + " : " + wd.name());
        }
    }

    public enum Weekday {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday,
    }
}
