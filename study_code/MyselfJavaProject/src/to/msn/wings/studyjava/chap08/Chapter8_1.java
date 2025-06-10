package to.msn.wings.studyjava.chap08;

import java.util.Date;

public class Chapter8_1 {

    public static void main(String[] args) {
        polymorphismBasic();
    }

    public static void accessorBasic() {
        var p = new Person();
        p.setName("山田太郎");
        p.setAge(30);
        System.out.println(p.show());
        // エラー
        p.setAge(-30);
    }

    public static void immutableBasic() {
        // var p = new PersonFinal("山田太郎", 30);
        // System.out.println(p.getName());
    }

    public static void immutableFailure() {
        var birth = new Date();
        var p = new PersonFinal("山田太郎", 30, birth);
        System.out.println(p.getBirth());
        // インスタンス化に際して渡したオブジェクトを更新（日付を変更）
        birth.setDate(15);
        System.out.println(p.getBirth());

        var p2 = new PersonFinal("山田太郎", 30, new Date());
        System.out.println(p2.getBirth());
        var birth2 = p2.getBirth();
        // ゲッター経由で取得したオブジェクトを更新（日付を変更）
        birth2.setDate(20);
        System.out.println(p2.getBirth());
    }

    public static void inheritBasic() {
        var bp = new BusinessPerson();
        bp.setName("山田太郎");
        bp.setAge(30);
        System.out.println(bp.show());
        System.err.println(bp.work());
    }

    public static void hideBasic() {
        var bp = new BusinessPerson();
        // BusinessPerson.birthフィールドを表示
        System.out.println(bp.birth);
        // Person.birthフィールドを表示
        System.out.println(bp.show());
    }

    public static void inheritBaseCall() {
        var ebp = new EliteBusinessPerson();
        ebp.name = "山田太郎";
        ebp.age = 30;
        System.out.println(ebp.work());
    }

    public static void inheritConstruct() {
        var c = new MyChild("山田太郎");
    }

    public static void clazzSealed() {
        Person p = new BusinessPerson();

        // 型に応じてメッセージを表示
        System.out.println(switch (p) {
            case BusinessPerson bp -> "BusinessPerson";
            // case Student st -> "Student";
            case Person pp -> "Person";
        });
    }

    public static void castUp() {
        Person bp = new BusinessPerson();
    }

    public static void castDown() {
        Person p = new BusinessPerson();
        BusinessPerson bp = (BusinessPerson) p;
    }

    public static void typeDifference() {
        Person p = new BusinessPerson();
        p.name = "山田太郎";
        p.age = 30;
        // エラー:The method work() is undefined for the type Person
        // System.out.println(p.work());

        System.out.println(p.show());
    }

    public static void hideBasic2() {
        Person p = new BusinessPerson();
        System.out.println(p.birth);
        BusinessPerson bp = new BusinessPerson();
        System.out.println(bp.birth);
    }

    public static void exceptionExample() {
        Person p = new BusinessPerson();
        BusinessPerson bp = (BusinessPerson) p;
        // エラー
        // Student st = (Student)p;
        if (p instanceof Student) {
            Student st = (Student) p;
        }
        if (p instanceof Student st) {

        }
    }

    public static void typeGetBasic() {
        Person p1 = new Person();
        System.out.println(p1.getClass());
        Person p2 = new BusinessPerson();
        System.out.println(p2.getClass());
        var c = Person.class;
        System.out.println(c);
    }

    public static void polymorphismBasic() {
        Shape tri = new Triangle(10, 50);
        Shape rec = new Rectangle(10, 50);
        System.out.println(tri.getArea());
        System.out.println(rec.getArea());
    }
}
