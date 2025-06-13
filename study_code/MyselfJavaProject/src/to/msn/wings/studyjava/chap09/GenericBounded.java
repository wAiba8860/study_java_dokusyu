package to.msn.wings.studyjava.chap09;

import java.util.List;

public class GenericBounded {

    // List<Parent>型のリストを受取、その内容を出力
    public void show(List<? extends Parent> list) {
        for (var p : list) {
            System.out.println(p.getName());
        }
    }
}

class Parent {
    public String name;

    public Parent(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class Child extends Parent {
    public Child(String name) {
        super(name);
    }
}
