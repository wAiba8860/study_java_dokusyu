package to.msn.wings.studyjava.chap09;

import java.util.Objects;

public class Rensyu9_1 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        var practice1 = new PracticePerson("山田", "太郎");
        var practice2 = new PracticePerson("山田", "太鼓");
        System.out.println(practice1.equals(practice2));
    }
}

class PracticePerson implements Cloneable {
    private String firstName;
    private String lastName;

    public PracticePerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof PracticePerson p) {
            return Objects.equals(this.firstName, p.firstName) &&
                    Objects.equals(this.lastName, p.lastName);
        }
        return false;
    }
}