package to.msn.wings.studyjava.chap10;

public class PersonStream {
    public String name;
    public int age;

    public PersonStream(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s (%d歳) ", this.name, this.age);
    }
}
