package to.msn.wings.studyjava.chap11;

import java.util.Arrays;
import java.util.List;

public class Person {
    private String lastName;
    private String firstName;

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    @Deprecated
    @SuppressWarnings("all")
    public String toString() {
        return String.format("名前は、%s %s です。", this.lastName, this.firstName);
    }

    public static void annotationBasic() {
        var i = new Chapter11_2(108);
    }
}
