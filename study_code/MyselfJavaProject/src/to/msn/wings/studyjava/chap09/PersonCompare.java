package to.msn.wings.studyjava.chap09;

import java.util.Comparator;
import java.util.Objects;

public class PersonCompare implements Comparable<PersonCompare> {
    private String firstNameKana;
    private String lastNameKana;

    public PersonCompare(String firstNameKana, String lastNameKana) {
        this.firstNameKana = firstNameKana;
        this.lastNameKana = lastNameKana;
    }

    // 名字、名前カナで大小を判定
    @Override
    public int compareTo(PersonCompare o) {
        if (Objects.equals(this.lastNameKana, o.lastNameKana)) {
            return Objects.compare(this.lastNameKana, o.firstNameKana,
                    Comparator.nullsFirst(Comparator.naturalOrder()));
        } else {
            return Objects.compare(this.lastNameKana, o.lastNameKana,
                    Comparator.nullsFirst(Comparator.naturalOrder()));
        }
    }

    @Override
    public String toString() {
        return this.lastNameKana + " " + this.firstNameKana;
    }
}
