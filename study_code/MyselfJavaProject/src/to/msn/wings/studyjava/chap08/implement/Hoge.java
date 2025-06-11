package to.msn.wings.studyjava.chap08.implement;

public interface Hoge {
    // void foo();
    CharSequence foo();
}

interface Hoge2 {
    String foo();
}

class HogeImol implements Hoge, Hoge2 {

    @Override
    public String foo() {
        return "";
    }
}