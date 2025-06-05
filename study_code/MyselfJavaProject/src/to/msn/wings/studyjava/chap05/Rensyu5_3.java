package to.msn.wings.studyjava.chap05;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Rensyu5_3 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        practice1();
        System.out.println("[2]:");
        practice2();
    }

    public static void practice1() {
        var dt = LocalDateTime.now();
        System.out.println(dt.getMonthValue() + "月" + dt.getMinute() + "分");
    }

    public static void practice2() {
        var dt = LocalDateTime.now();
        System.out.println(dt.plus(20, ChronoUnit.DAYS));
        var period = Period.ofDays(20);
        System.out.println(dt.plus(period));
    }
}