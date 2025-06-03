package to.msn.wings.studyjava.chap05;

import java.util.regex.Pattern;

public class Chapter5_3 {
    public static void main(String[] args) {
        regSplit();
    }

    public static void regMatches() {
        var tel = new String[] {"080-0000-0000", "084-000-0000", "184-0000"};
        var rx = "\\d{2,4}-\\d{2,4}-\\d{4}";

        for (var t : tel) {
            System.out.println(Pattern.matches(rx, t) ? t : "アンマッチ");
        }
    }

    public static void regMatcher() {
        var str = "会社の電話は0123-99-0000です。自宅は000-123-4567だよ。";
        var ptn = Pattern.compile("(\\d{2,4})-(\\d{2,4})-(\\d{4})");
        var match = ptn.matcher(str);

        while (match.find()) {
            System.out.println("開始位置:" + match.start());
            System.out.println("終了位置:" + match.end());
            System.out.println("マッチング文字列:" + match.group());
            System.out.println("市外局番:" + match.group(1));
            System.out.println("市内局番:" + match.group(2));
            System.out.println("加入者番号:" + match.group(3));
            System.out.println("----------");
        }
    }

    public static void regIgnore() {
        var str = "仕事用はwings@example.comです。プライベート用はYAMA@example.comです。検証用.....@aaaaa";
        var ptn = Pattern.compile("[a-z0-9.!#$%&'*+/=?^_{|}~-]+@[a-z0-9-]+(\\.[a-z0-9-]+)*",
                Pattern.CASE_INSENSITIVE);
        var match = ptn.matcher(str);

        while (match.find()) {
            System.out.println(match.group(0));
        }
    }

    public static void regMulti() {
        var str = "10人のインディアン。\n1年生になったら。";
        var ptn = Pattern.compile("^\\d*", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        var match = ptn.matcher(str);

        while (match.find()) {
            System.out.println(match.group(0));
        }
    }

    public static void regSingle() {
        var str = "初めまして。\nよろしくお願いします。";
        var ptn = Pattern.compile("^.+", Pattern.DOTALL);
        var match = ptn.matcher(str);

        while (match.find()) {
            System.out.println(match.group(0));
        }
    }

    public static void regComment() {
        var str = "仕事用はwings@example.comです。プライベート用はYAMA@example.comです。検証用.....@aaaaa";
        var ptn = Pattern.compile("""
                [a-z0-9.!\\#$%&'*+/=?^_{|}~-]+  # local
                @                               # delimiter
                [a-z0-9-]+(\\.[a-z0-9-]+)*      # domain
                """, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS);
        var match = ptn.matcher(str);

        while (match.find()) {
            System.out.println(match.group(0));
        }
    }

    public static void regLongest() {
        var tags =
                "<p><strong>WINGS</strong>サイト<a href = 'index.html'><img src='wings.jpg'/></a></p>";
        var ptn = Pattern.compile("<.+?>");
        var match = ptn.matcher(tags);
        while (match.find()) {
            System.out.println(match.group(0));
        }
    }

    public static void regMatcherNamed() {
        var str = "会社の電話は0123-99-0000です。自宅は000-123-4567だよ。";
        var ptn = Pattern.compile("(?<area>\\d{2,4})-(?<city>\\d{2,4})-(?<local>\\d{4})");
        var match = ptn.matcher(str);

        while (match.find()) {
            System.out.println("開始位置:" + match.start());
            System.out.println("終了位置:" + match.end());
            System.out.println("マッチング文字列:" + match.group());
            System.out.println("市外局番:" + match.group("area"));
            System.out.println("市内局番:" + match.group("city"));
            System.out.println("加入者番号:" + match.group("local"));
            System.out.println("----------");
        }
    }

    public static void regAfter() {
        var str =
                "<p>サポートサイト<a href = \"https://www.wings.msn.to/\">https://www.wings.msn.to/</a></p>";
        // var ptn = Pattern.compile("<a href = \"(.+?)\">\\1</a>");
        // 名前付き
        var ptn = Pattern.compile("<a href = \"(?<link>.+?)\">\\k<link></a>");
        var match = ptn.matcher(str);
        if (match.find()) {
            System.out.println(match.group("link"));
        }
    }

    public static void regNoRef() {
        var str = "仕事用はwings@example.comです。プライベート用はYAMA@example.comです。検証用.....@aaaaa";
        var ptn = Pattern.compile("([a-z0-9.!#$%&'*+/=?^_{|}~-]+)@([a-z0-9-]+(?:\\.[a-z0-9-]+)*)",
                Pattern.CASE_INSENSITIVE);
        var match = ptn.matcher(str);

        while (match.find()) {
            System.out.println(match.group(0));
            System.out.println(match.group(1));
            System.out.println(match.group(2));
            // System.out.println(match.group(3));
            System.out.println("---------------");
        }
    }

    private static void match(Pattern ptn, String input) {
        var match = ptn.matcher(input);
        while (match.find()) {
            System.out.println(match.group(0));
        }
        System.out.println("-----------");
    }

    public static void regRead() {
        var re1 = Pattern.compile("いろ(?=はに)");
        var re2 = Pattern.compile("いろ(?!はに)");
        var re3 = Pattern.compile("(?<=。)いろ");
        var re4 = Pattern.compile("(?<!。)いろ");

        var msg1 = "いろはにほへと";
        var msg2 = "いろものですね。いろいろと";

        match(re1, msg1);
        match(re1, msg2);
        match(re2, msg1);
        match(re2, msg2);
        match(re3, msg1);
        match(re3, msg2);
        match(re4, msg1);
        match(re4, msg2);
    }

    public static void regUnicodeProp() {
        var str = "WINGSプロジェクトは2003年に発足した執筆者コミュニティです。";
        var ptn = Pattern.compile("\\p{IsKatakana}+");
        var match = ptn.matcher(str);
        while (match.find()) {
            System.out.println(match.group(0));
        }
    }

    public static void regReplaceAll() {
        var str = "サポートサイトはhttps://www.wings.msn.to/です。";
        System.out.println(str.replaceAll("(?i)http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w ./?%&=-]*)?",
                "<a href=\"$0\">$0</a>"));
    }

    public static void regReplace() {
        var str = "名前は桜。桜と呼ばれます。";
        System.out.println(str.replace("桜", "サクラ"));
    }

    public static void regReplaceNamed() {
        var str = "仕事用はwings@example.comです。";
        System.out.println(str.replaceAll(
                "(?i)(?<localName>[a-z0-9.!#$%&'*+/=?^_{|}~-]+)@(?<domain>[a-z0-9-]+(?:\\.[a-z0-9-]+)*)",
                "${domain}の${localName}"));
    }

    public static void regSplit() {
        var str = "にわに3わうらにわに51わにわとりがいる";
        var re = Pattern.compile("\\d{1,}わ");
        var result = re.split(str);
        System.out.println(String.join(" ", result));
    }
}
