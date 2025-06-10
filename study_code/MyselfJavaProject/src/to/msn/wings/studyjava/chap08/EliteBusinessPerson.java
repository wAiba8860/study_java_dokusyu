package to.msn.wings.studyjava.chap08;

public class EliteBusinessPerson extends BusinessPerson {

    @Override
    public String work() {
        var result = super.work();
        System.out.println(result);
        return String.format("%sいつでもテキパキと", result);
    }
}