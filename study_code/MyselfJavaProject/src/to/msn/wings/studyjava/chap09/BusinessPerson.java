package to.msn.wings.studyjava.chap09;

import java.util.Objects;

public class BusinessPerson extends Person {
    // 所属部門
    private String department;

    public BusinessPerson(String firstName, String lastName, String department) {
        super(firstName, lastName);
        this.department = department;
    }

    @Override
    public boolean equals(Object obj) {
        // 同一性の判定
        if (this == obj) {
            return true;
        }
        // 比較対象がnullならば常に等しくない
        if (obj == null) {
            return false;
        }
        // 同値性の判定
        // if (obj instanceof BusinessPerson bp) {
        // return super.equals(bp) && Objects.equals(this.department, bp.department);
        // }
        if (obj instanceof Person) {
            // BusinessPerson型の場合、すべてのフィールドで比較
            if (obj instanceof BusinessPerson bp) {
                return super.equals(bp) && Objects.equals(this.department, bp.department);
            } else {
                return super.equals(obj);
            }
        }
        return false;
    }
}