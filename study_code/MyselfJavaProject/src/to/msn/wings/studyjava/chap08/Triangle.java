package to.msn.wings.studyjava.chap08;

public class Triangle extends Shape {

    public Triangle(double width, double height) {
        super(width, height);
    }

    // 三角形の面積を取得
    @Override
    public double getArea() {
        return this.width * this.height / 2;
    }
}
