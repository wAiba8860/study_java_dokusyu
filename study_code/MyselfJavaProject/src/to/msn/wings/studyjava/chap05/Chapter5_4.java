package to.msn.wings.studyjava.chap05;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Chapter5_4 {
    public static void main(String[] args) {
        timeBetween();
    }

    public static void timeNow() {
        System.out.println(LocalDateTime.now());
        System.out.println(OffsetDateTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
    }

    public static void timeOf() {
        var ldt1 = LocalDateTime.of(2024, 1, 10, 10, 20, 30, 513);
        var ldt2 = LocalDateTime.of(2024, Month.JANUARY, 10, 10, 20, 30);
        // var ldt3 = LocalDateTime.of(2024, 1, 40, 10, 20, 30);
        System.out.println(ldt1);
        System.out.println(ldt2);
        // System.out.println(ldt3);

        var ld = LocalDate.of(2024, 1, 10);
        var lt = LocalTime.of(10, 20, 30);
        var ldt4 = LocalDateTime.of(ld, lt);
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt4);

        var odt = OffsetDateTime.of(2024, 1, 10, 10, 20, 30, 999, ZoneOffset.ofHours(9));
        var ot = OffsetTime.of(10, 20, 30, 999, ZoneOffset.ofHours(9));
        System.out.println(odt);
        System.out.println(ot);

        var zdt = ZonedDateTime.of(2024, 1, 10, 10, 20, 30, 999, ZoneId.of("Asia/Tokyo"));
        System.out.println(zdt);

        // for (var id : ZoneId.getAvailableZoneIds()) {
        // System.out.println(id);
        // }
    }

    public static void timeParse() {
        System.out.println(LocalDate.parse("2024-01-10", DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDate.parse("2024-123", DateTimeFormatter.ISO_ORDINAL_DATE));
        System.out.println(LocalDate.parse("2024-W40-5", DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(ZonedDateTime.parse("2024-01-10T10:20:30.000000999+09:00[Asia/Tokyo]",
                DateTimeFormatter.ISO_DATE_TIME));
    }

    public static void timeEquals() {
        var dt1 = LocalDateTime.of(2023, 12, 31, 10, 2, 30);
        var dt2 = LocalDateTime.of(2024, 1, 10, 10, 20, 30);

        System.out.println(dt1.equals(dt2));
        System.out.println(dt1.isBefore(dt2));
        System.out.println(dt1.isAfter(dt2));
    }

    public static void timeGet() {
        var dt = LocalDateTime.of(2024, 1, 10, 10, 20, 30, 123);

        System.out.println(dt.getYear() + "年" + dt.getMonthValue() + "月" + dt.getDayOfMonth() + "日"
                + dt.getDayOfWeek() + " " + dt.getHour() + "時" + dt.getMinute() + "分"
                + dt.getSecond() + "秒" + dt.getNano() + "ナノ秒");

        System.out.println("月名は" + dt.getMonth() + " 今年" + dt.getDayOfYear() + "日目");
    }

    public static void timeGet2() {
        var dt = LocalDateTime.of(2024, 1, 10, 10, 20, 30, 123);
        var week = new String[] {"", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日", "日曜日"};

        System.out.println(dt.get(ChronoField.YEAR) + "年" + dt.get(ChronoField.MONTH_OF_YEAR) + "月"
                + dt.get(ChronoField.DAY_OF_MONTH) + "日" + week[dt.get(ChronoField.DAY_OF_WEEK)]
                + " " + dt.get(ChronoField.HOUR_OF_DAY) + "時" + dt.get(ChronoField.MINUTE_OF_HOUR)
                + "分" + dt.get(ChronoField.SECOND_OF_MINUTE) + "秒"
                + dt.get(ChronoField.NANO_OF_SECOND) + "ナノ秒");
    }

    public static void timeFormat() {
        var dt1 = LocalDateTime.of(2024, 1, 10, 10, 20, 30);
        var dt2 = ZonedDateTime.of(2024, 1, 10, 10, 20, 30, 0, ZoneId.of("Asia/Tokyo"));

        System.out.println(dt1.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(dt2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
        System.out.println(dt1.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(dt2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
    }

    public static void timePattern() {
        var dt1 = LocalDateTime.of(2024, 1, 1, 10, 20, 30);
        var dt2 = ZonedDateTime.of(2024, 1, 1, 10, 20, 30, 0, ZoneId.of("Asia/Tokyo"));

        System.out.println(dt1.format(DateTimeFormatter.ofPattern("y.MM.dd H:m:s")));
        System.out.println(dt2.format(DateTimeFormatter.ofPattern("Y年L月d日（E）a K時m分s秒（z）")));
    }

    public static void timeFormatLocale() {
        // locale = Locale.US;
        var locale = Locale.JAPAN;
        // zone = ZoneId.of("America/Chicago");
        var zone = ZoneId.of("Asia/Tokyo");
        var dt = ZonedDateTime.of(LocalDateTime.now(), zone);

        System.out.println(dt.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(locale)));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("Y年L月d日（E）a K時m分s秒（z）", locale)));
    }

    public static void timeJapanese() {
        var d = JapaneseDate.of(JapaneseEra.REIWA, 6, 12, 31);
        System.out.println(d);

        var df = DateTimeFormatter.ofPattern("Gy年MM月dd日");
        System.out.println(d.format(df));
    }

    public static void timeBetween() {
        var dt1 = LocalDateTime.of(2022, 12, 31, 0, 0, 0);
        var dt2 = LocalDateTime.of(2024, 3, 3, 10, 20, 30);

        var period = Period.between(dt1.toLocalDate(), dt2.toLocalDate());
        System.out.println("日付の差:" + period.getYears() + "年" + period.getMonths() + "ヶ月"
                + period.getDays() + "日間");

        var duration = Duration.between(dt1, dt2);
        var nowDuration = Duration.between(dt2, LocalDateTime.now());
        System.out.println("時間の差:" + duration.toHours() + "時間");
        System.out.println("現在までの時間の差" + nowDuration.toHours() + "時間");
    }
}
