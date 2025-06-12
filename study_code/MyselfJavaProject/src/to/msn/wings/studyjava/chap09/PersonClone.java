package to.msn.wings.studyjava.chap09;

public class PersonClone implements Cloneable {

    private String firstName;
    private String lastName;
    private String[] memos;

    public PersonClone(String firstName, String lastName, String[] memos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memos = memos;
    }

    @Override
    public PersonClone clone() {
        PersonClone p = null;
        try {
            p = (PersonClone) super.clone();
            p.memos = this.memos.clone();
        } catch (CloneNotSupportedException e) {
            // TODO: handle exception
            throw new AssertionError();
        }
        return p;
    }

    @Override
    public String toString() {
        // return this.lastName + this.firstName;
        return String.format("%s%s (%s)", this.lastName, this.firstName, this.memos[1]);
    }
}