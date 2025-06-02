package to.msn.wings.studyjava.chap04;

public class rensyu4_1 {
    public static void main(String[] args) {
        var testResult = 75;

        if (testResult >= 90) {
            System.out.println("優");
        } else if (testResult >= 70) {
            System.out.println("良");
        } else if (testResult >= 50) {
            System.out.println("可");
        } else {
            System.out.println("不可");
        }
    }
}