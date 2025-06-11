package to.msn.wings.studyjava.chap09;

public class Chapter9_1 {
    public static void main(String[] args) {
        equalsBasic();
    }

    public static void toStringBasic() {
        var p = new Person("太郎", "山田");
        System.out.println(p);
        var p2 = new Person("花子", "山田");
        System.out.println(p.equals(p2));
    }

    public static void equalsBasic() {
        var p = new Person("太郎", "山田");
        var bp1 = new BusinessPerson("太郎", "山田", "営業");
        var bp2 = new BusinessPerson("太郎", "山田", "総務");
        System.out.println(p.equals(bp1));
        System.out.println(bp1.equals(p));
        System.out.println(p.equals(bp2));
        System.out.println(bp2.equals(bp1));
    }

}