package to.msn.wings.studyjava.chap04;

public class rensyu4_2 {
    public static void main(String[] args) {
        System.out.println("[1]:whileは前置処理、doWhileは後置処理なので、whileは条件に合わなければ処理が一度も実行されないことがあるが、doWhileは一度は処理が実行される");

        for (var i = 1; i < 10; i++) {
            for (var j = 1; j < 10; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println("");
        }

    }
}