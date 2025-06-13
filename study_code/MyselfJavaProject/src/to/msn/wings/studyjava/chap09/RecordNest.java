package to.msn.wings.studyjava.chap09;

//Nameレコードを配下に保持するStudentレコード
record Name(String first, String last) {
}

record NameStudent(Name name, int age) {
}

public class RecordNest {

    public static void main(String[] args) {
        Object obj = new NameStudent(new Name("太郎", "山田"), 18);
        if (obj instanceof NameStudent(Name(var first, var last), int age)) {
            System.out.println(first + last + ": " + age);
        }
    }
}