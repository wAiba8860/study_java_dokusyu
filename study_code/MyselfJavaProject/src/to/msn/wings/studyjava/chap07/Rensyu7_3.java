package to.msn.wings.studyjava.chap07;

public class Rensyu7_3 {

    public static void main(String[] args) {
        System.out.println("[1]:");
        // var p = new PMyClass(55, 170);
        // p.getBmi();
        PMyClass.height = 170;
        PMyClass.weight = 55;
        PMyClass.getBmi();
    }
}

final class PMyClass {
    // public double weight;
    // public double height;

    public static double weight;
    public static double height;

    // public PMyClass(double weight, double height) {
    // this.weight = weight;
    // this.height = height;
    // }

    public static void getBmi() {
        System.out.println("BMIは" + weight / (height * height) + "です");
    }
}