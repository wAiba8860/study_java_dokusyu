package to.msn.wings.studyjava.chap07;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String show() {
        return String.format("%s (%d歳)です。", this.name, this.age);
    }

}
