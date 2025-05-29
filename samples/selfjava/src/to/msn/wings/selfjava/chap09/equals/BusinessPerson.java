package to.msn.wings.selfjava.chap09.equals;

import java.util.Objects;

public class BusinessPerson extends Person {
  private String department;

  public BusinessPerson(String firstName, String lastName, String department) {
    super(firstName, lastName);
    this.department = department;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) { return true; }
    if (obj == null) { return false; }
    if (obj instanceof BusinessPerson bp) {
      return super.equals(bp) &&
        Objects.equals(this.department, bp.department);
    }
    return false;
  }

  // @Override
  // public boolean equals(Object obj) {
  //   if (obj instanceof Person) {
  //     if (obj instanceof BusinessPerson bp) {
  //       return super.equals(bp) &&
  //         Objects.equals(this.department, bp.department);
  //     } else {
  //       return super.equals(obj);
  //     }
  //   }
  //   return false;
  // }
}