package to.msn.wings.studyjava.chap08.implement;

public interface Parent {

    default void log(String msg) {
        System.out.println("Parent: " + msg);
    }
}

interface HogeChild extends Parent {
}

interface Hoge2Child extends Parent {

    default void log(String msg) {
        System.out.println("Hoge2: " + msg);
    }
}

class ParentHogeImpl implements HogeChild, Hoge2Child {
}

class MainHoge {
    public static void main(String[] args) {
        var ho = new ParentHogeImpl();
        ho.log("TEMP");
    }
}