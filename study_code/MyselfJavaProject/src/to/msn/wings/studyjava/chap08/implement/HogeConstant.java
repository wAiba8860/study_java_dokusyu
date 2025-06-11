package to.msn.wings.studyjava.chap08.implement;

interface HogeConstant {

    int DATA = 0;
}

interface Hoge2Constant {

    String DATA = "This is data.";
}

class HogeImplConstant implements HogeConstant, Hoge2Constant {
    // int DATA = 0;

    public void foo() {

        // System.out.println(DATA);
    }
}