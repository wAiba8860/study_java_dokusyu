package to.msn.wings.studyjava.chap07;

public class ArgsOverload {

    void hoge(int x, int y) {
        System.out.println("int_x_y");
    }

    void hoge(int... x) {
        System.out.println("int...");
    }
}