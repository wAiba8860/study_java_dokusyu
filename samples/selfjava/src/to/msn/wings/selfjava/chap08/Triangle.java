package to.msn.wings.selfjava.chap08;

public class Triangle extends Shape {
  public Triangle(double width, double height) {
    super(width, height);
  }

  @Override
  public double getArea() {
    return this.width * this.height / 2;
  }
}
