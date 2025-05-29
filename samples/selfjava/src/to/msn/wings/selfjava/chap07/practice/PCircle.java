package to.msn.wings.selfjava.chap07.practice;

public class PCircle {
  public double radius;

  public PCircle(double radius) {
    this.radius = radius;
  }

  public PCircle() {
    this(1);
    // this.radius = 1;
  }

  public double getArea() {
    return this.radius * this.radius * Math.PI;
  }

  public static void main(String[] args) {
    var p = new PCircle(3.0);
    System.out.println(p.getArea());
    var p2 = new PCircle();
    System.out.println(p2.getArea());
  }
}
