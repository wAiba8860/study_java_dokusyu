package to.msn.wings.studyjava.chap08.implement;

interface HogeDefault {

    default void log(String msg) {
        System.out.println("Hoge: " + msg);
    }
}

interface InnerHogeDefault {
    default void log(String msg) {
        System.out.println("Hoge2: " + msg);
    }

}

class HogeImplDefault implements HogeDefault, InnerHogeDefault {

    @Override
    public void log(String msg) {
        HogeDefault.super.log(msg);
    }

}

class Main {
    public static void main(String[] args) {
        var temp = new HogeImplDefault();
        temp.log("Java");
    }
}