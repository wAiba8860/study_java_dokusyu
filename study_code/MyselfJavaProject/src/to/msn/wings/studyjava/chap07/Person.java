package to.msn.wings.studyjava.chap07;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Person {

    private String name;
    private int age;
    private LocalDateTime updated;

    {
        this.updated = LocalDateTime.now();
    }

    public Person(String firstName, String lastName, LocalDate birth) {
        this.name = lastName + " " + firstName;
        this.age = Period.between(birth, LocalDate.now()).getYears();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        this("名無権兵衛", 20);
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
