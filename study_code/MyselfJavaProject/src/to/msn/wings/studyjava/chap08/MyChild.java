package to.msn.wings.studyjava.chap08;

public class MyChild extends MyParent {

    public MyChild(String name) {
        super(name);
        System.out.printf("子の%sです。\n", name);
    }
}