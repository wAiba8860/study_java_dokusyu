package to.msn.wings.studyjava.chap07;

public class FactoryClass {

    private FactoryClass() {

    }

    public static FactoryClass getInstance() {
        return new FactoryClass();
    }
}