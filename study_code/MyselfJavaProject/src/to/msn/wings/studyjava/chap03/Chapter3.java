package to.msn.wings.studyjava.chap03;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Chapter3 {
    public static void main(String[] args) {
        condition();
    }

    public static void nonumber() {
        System.out.println(1 + 2);
        System.out.println("a" + 2);
        System.out.println(1 + "b");
        System.out.println("1" + "2");
        System.out.println("a" + LocalDateTime.now());
        // エラー System.out.println(1 + LocalDateTime.now());
        final int[] VALUES = { 10, 20, 30 };
        // エラー VALUES = new int[]{12,25,35};
        VALUES[0] = 100;
    }

    public static void concatString() {
        var result = "";
        for (var i = 0; i < 100000; i++) {
            result += "いろは";
        }
    }

    public static void concatBuilder() {
        var builder = new StringBuilder(100000);
        for (var i = 0; i < 100000; i++) {
            builder.append("いろは");
        }
        var result = builder.toString();
    }

    public static void Increment() {
        var i = 3;
        var j = ++i;
        System.out.println(i);
        System.out.println(j);

        var m = 3;
        var n = m++;
        System.out.println(m);
        System.out.println(n);
    }

    public static void divInteger() {
        System.out.println(3 / 4);
        double result = 3 / 4;
        System.out.println(result);
        System.out.println(3d / 4);
    }

    public static void divZero() {
        System.out.println(5 / 0);// エラー
        System.out.println(5 % 0);// エラー
        System.out.println(5d / 0);// Infinity
        System.out.println(5d % 0);// NaN
    }

    public static void calcFloat() {
        System.out.println(Math.floor((0.7 + 0.1) * 10));
    }

    public static void calcBigDecimal() {
        var bd1 = new BigDecimal("0.7");
        var bd2 = new BigDecimal("0.1");
        var bd3 = new BigDecimal("10");
        System.out.println(bd1.add(bd2).multiply(bd3));
    }

    public static void substitution() {
        var x = 1;
        var y = x;
        x += 10;
        System.out.println(x);
        System.out.println(y);

        var builder1 = new StringBuilder("あいう");
        var builder2 = builder1;
        builder1.append("えお");
        System.out.println(builder1.toString());
        System.out.println(builder2.toString());
    }

    public static void compareStringBuilder() {
        var builder1 = new StringBuilder("あいう");
        var builder2 = new StringBuilder("あいう");
        System.out.println(builder1 == builder2);// false
        System.out.println(builder1.equals(builder2));// false
        System.out.println(builder1.toString().equals(builder2.toString()));// true
    }

    public static void compareFloat() {
        System.out.println(0.2 * 3 == 0.6);
    }

    public static void compareBigDecimal() {
        var bd1 = new BigDecimal("0.2");
        var bd2 = new BigDecimal("3");
        var bd3 = new BigDecimal("0.6");
        var bool = bd1.multiply(bd2).compareTo(bd3);
        System.out.println(bool);
        if (bool == 0) {
            System.out.println("等しい");
        } else {
            System.out.println("異なる");
        }
    }

    public static void compareDouble() {
        final double EPSILON = 0.00001;
        var x = 0.2 * 3;
        var y = 0.6;
        System.out.println(Math.abs(x - y) < EPSILON);
    }

    public static void compareArray() {
        var data1 = new String[] { "あ", "い", "う" };
        var data2 = new String[] { "あ", "い", "う" };
        System.out.println(data1 == data2);// false
        System.out.println(data1.equals(data2));// false
        System.out.println(Arrays.equals(data1, data2));
    }

    public static void compareArrayDeep() {
        var data1 = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        var data2 = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println(Arrays.equals(data1, data2));
        System.out.println(Arrays.deepEquals(data1, data2));
    }

    public static void compareArrayMethod() {
        var data1 = new int[] { 1, 3 };
        var data2 = new int[] { 1, 2, 3 };
        var data3 = new int[] { 1, 2, 3 };
        var data4 = new int[] { 1, 3, 1 };
        var data5 = new int[] { 1, 2, 3, 4 };
        System.out.println(Arrays.compare(data1, data2));
        System.out.println(Arrays.compare(data2, data3));
        System.out.println(Arrays.compare(data3, data4));
        System.out.println(Arrays.compare(data3, data5));
    }

    public static void compareInteger() {
        Integer i1 = 108;
        Integer i2 = 108;
        System.out.println(i1 == i2);

        Integer j1 = 256;
        Integer j2 = 256;
        System.out.println(j1 == j2);
    }

    public static void condition() {
        var age = 30;
        System.out.println(age > 20 ? "大人です" : "子供です");
    }
}