package to.msn.wings.studyjava.chap07;

public class Rensyu7_2 {

    public static void main(String[] args) {
        System.out.println("[1]:");
        var p = new PCircle(10);
        System.out.println(p.getArea());
    }
}

class PCircle {
    private double radius;

    public PCircle(double radius) {
        this.radius = radius;
    }

    public PCircle() {
        this(1);
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }
}