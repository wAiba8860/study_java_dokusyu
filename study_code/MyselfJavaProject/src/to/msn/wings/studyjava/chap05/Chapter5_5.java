package to.msn.wings.studyjava.chap05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Chapter5_5 {
    public static void main(String[] args) {
        arraysExample();
    }

    public static void streamWrite() {
        try (var writer = Files.newBufferedWriter(Paths.get("C:\\開発用\\Java\\data\\data.log"), StandardCharsets.UTF_8,
                StandardOpenOption.APPEND)) {
            writer.write(LocalDateTime.now().toString());
            writer.newLine();
            // writer.write(LocalDateTime.now().toString() + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileWrite() {
        var filePath = "C:\\開発用\\Java\\data\\list.txt";
        List<String> lines = List.of(
                "春はあけぼの。やうやう白くなり行く、山ぎはすこし…",
                "夏は夜。月のころはさらなり。やみもなほ、ほたるの…",
                "秋は夕暮れ。夕日のさして山の端いと近うなりたるに…",
                "冬はつとめて。雪の降りたるは、いふべきにもあらず…");
        try {
            Files.write(Paths.get(filePath),
                    lines,
                    StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void streamRead() {
        try (var reader = Files.newBufferedReader(Paths.get("C:\\開発用\\Java\\data\\sample.txt"))) {
            var line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void binaryReadWrite() {
        try (var in = new BufferedInputStream(new FileInputStream("C:\\開発用\\Java\\data\\input.png"));
                var out = new BufferedOutputStream(new FileOutputStream("C:\\開発用\\Java\\data\\output.png"));) {
            var data = -1;
            while ((data = in.read()) != -1) {
                out.write((byte) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Article implements Serializable {
        private static final long serialVersionUID = 1L;
        public String title;
        public String url;
        public transient boolean expired;

        public Article(String title, String url, boolean expired) {
            this.title = title;
            this.url = url;
            this.expired = expired;
        }

        public String toString() {
            return String.format("%s %s", title, url);
        }
    }

    public static void objectReadWrite() {
        final var file = "C:\\開発用\\Java\\data\\article.ser";

        try (var out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(new Article("最新Javaアップデート情報", "https://codezine.jp/article/corner/839", false));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (var in = new ObjectInputStream(new FileInputStream(file))) {
            var a = (Article) in.readObject();
            System.out.println(a);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void mathEx() {
        System.out.println(Math.abs(-100));
        System.out.println(Math.max(3, 6));
        System.out.println(Math.min(3, 6));
        System.out.println(Math.ceil(1234.567));
        System.out.println(Math.floor(1234.567));
        System.out.println(Math.round(123.456));
        System.out.println(Math.sqrt(10000));
        System.out.println(Math.cbrt(10000));
        System.out.println(10 / 3);
        System.out.println(Math.ceilDiv(10, 3));
        System.out.println(10 % 3);
        System.out.println(Math.ceilMod(10, 3));
        System.out.println(-10 / 3);
        System.out.println(Math.floorDiv(-10, 3));
        System.out.println(-10 % 3);
        System.out.println(Math.floorDiv(-10, 3));
        System.out.println(Math.pow(2, 4));
        System.out.println(Math.sin(Math.toRadians(30)));
        System.out.println(Math.cos(Math.toRadians(60)));
        System.out.println(Math.tan(Math.toRadians(45)));
        System.out.println(Math.log(100));
        System.out.println(Math.log10(100));
    }

    public static void bigNumber() {
        long result = 1;
        for (var i = 1; i < 26; i++) {
            result *= i;
            System.out.println(result);
        }
    }

    public static void bigNumber2() {
        var result = BigInteger.valueOf(1);
        for (var i = 1; i < 26; i++) {
            result = result.multiply(BigInteger.valueOf(i));
            System.out.println(result);
        }
    }

    public static void randomExample() {
        Random rand = new Random();
        System.out.println(rand.nextBoolean());
        System.out.println(rand.nextFloat());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextInt(400) + 100);
        System.out.println(rand.nextLong());

        var data = new byte[5];
        rand.nextBytes(data);
        for (var b : data) {
            System.out.println(b);
        }
    }

    public static void formatNumber() {
        var num1 = 1234.5678;
        var nf1 = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        var nf2 = NumberFormat.getIntegerInstance();
        var nf3 = NumberFormat.getNumberInstance();
        System.out.println(nf1.format(num1));
        System.out.println(nf2.format(num1));
        System.out.println(nf3.format(num1));

        var num2 = 0.567;
        var nf4 = NumberFormat.getPercentInstance();
        System.out.println(nf4.format(num2));

        var num3 = 123_456_789;
        var nf5 = NumberFormat.getCompactNumberInstance();
        var nf6 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        System.out.println(nf5.format(num3));
        nf5.setMaximumFractionDigits(2);
        System.out.println(nf5.format(num3));
        System.out.println(nf6.format(num3));
    }

    public static void arraysExample() {
        var array1 = new String[] {
                "dog", "cat", "mouse", "fox", "lion"
        };
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.binarySearch(array1, "mouse"));

        var array2 = new String[] {
                "あ", "い", "う", "え", "お"
        };
        var array3 = Arrays.copyOf(array2, 2);
        System.out.println(Arrays.toString(array3));

        var array4 = Arrays.copyOfRange(array2, 1, 7);
        System.out.println(Arrays.toString(array4));

        Arrays.fill(array4, 4, 6, "--");
        System.out.println(Arrays.toString(array4));
    }
}
