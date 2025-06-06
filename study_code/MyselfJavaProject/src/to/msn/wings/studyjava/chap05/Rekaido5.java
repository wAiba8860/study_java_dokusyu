package to.msn.wings.studyjava.chap05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Rekaido5 {

    public static void main(String[] args) {
        System.out.println("[1]:");
        practice1();
        System.out.println("[2]:");
        practice2();
        System.out.println("[3]:");

        try (
                var writer = Files.newBufferedWriter(Paths.get("C:/開発用/Java/data/data.dat"),
                        Charset.forName("Windows-31J"), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(String.join(",", args));

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("[4]:");
        practice4();

    }

    public static void practice1() {
        var str1 = "となりのきゃくはよくきゃくくうきゃくだ";
        System.out.println(str1.lastIndexOf("きゃく"));

        var str2 = "%1$sの気温は%2$.2fです";
        System.out.println(String.format(str2, "千葉", 17.256));

        var str3 = "彼女の名前は花子です。";
        System.out.println(str3.replace("彼女", "妻"));

        System.out.println(LocalDateTime.now().plusDays(5).plusHours(6));

        var ymd1 = LocalDate.of(2024, 3, 12);
        var ymd2 = LocalDate.of(2024, 11, 5);

        var period = Period.between(ymd1, ymd2);

        System.out.println("日付の差" + period.getYears() + "年" +
                period.getMonths() + "ヶ月" + period.getDays() + "日間");
    }

    public static void practice2() {
        var ptn = Pattern.compile("[a-z0-9.!#$%&'*+/=?^_{|}~-]+@[a-z0-9]+(?:\\.[a-z0-9-]+)*", Pattern.CASE_INSENSITIVE);

        try (var reader = Files.newBufferedReader(Paths.get("C:/開発用/Java/data/contact.txt"))) {

            var line = "";
            while ((line = reader.readLine()) != null) {
                var match = ptn.matcher(line);
                while (match.find()) {
                    System.out.println(match.group(0));
                }
            }

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void practice4() {
        System.out.println(Math.pow(6, 3));
        System.out.println(Math.abs(-15));

        int[] p = new int[] {
                110, 14, 38, 32
        };
        Arrays.sort(p);
        System.out.println(Arrays.toString(p));
    }
}