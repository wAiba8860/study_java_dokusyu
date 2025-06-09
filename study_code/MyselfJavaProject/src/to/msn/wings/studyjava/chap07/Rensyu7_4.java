package to.msn.wings.studyjava.chap07;

public class Rensyu7_4 {

    public static void main(String[] args) {
        System.out.println("[1]");
        System.out.println(getAverage(31, 321, 231, 313123, 12313, 131, 222, 2));
    }

    public static double getAverage(double... values) {
        double sum = 0;
        double i = 0;
        for (var value : values) {
            sum += value;
            i++;
        }
        System.out.println(i);
        System.out.println(values.length);
        return sum / i;
    }
}