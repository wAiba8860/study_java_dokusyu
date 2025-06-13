package to.msn.wings.studyjava.chap09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Chapter9_1 {
    public static void main(String[] args) {
        // var p = new Chapter9_1();
        // try {
        // p.readHttpPages();
        // } catch (MySampleException e) {
        // // TODO: handle exception
        // e.printStackTrace();
        // }

        enumBit();

    }

    public static void toStringBasic() {
        var p = new Person("太郎", "山田");
        System.out.println(p);
        var p2 = new Person("花子", "山田");
        System.out.println(p.equals(p2));
    }

    public static void equalsBasic() {
        var p = new Person("太郎", "山田");
        var bp1 = new BusinessPerson("太郎", "山田", "営業");
        var bp2 = new BusinessPerson("太郎", "山田", "総務");
        System.out.println(p.equals(bp1));
        System.out.println(bp1.equals(p));
        System.out.println(p.equals(bp2));
        System.out.println(bp2.equals(bp1));
    }

    public static void compareBasic() {
        var data = new PersonCompare[] {new PersonCompare("タロウ", "マツダ"),
                new PersonCompare("リコ", "モリヤマ"), new PersonCompare("コウスケ", "モリタ"),
                new PersonCompare("マリコ", "モリヤ"), new PersonCompare("ソウジ", "ムラカミ"),
                new PersonCompare("エミ", "ヤマダ")};
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void cloneBasic() {
        var p1 = new PersonClone("太郎", "山田", new String[] {"あいう", "えお"});
        var p2 = p1.clone();
        System.out.println(p1 == p2);
        System.out.println(p2);
    }

    public static void tryBasic() {
        try {
            var in = new FileInputStream("C:/data/nothing.gif");
            var data = -1;
            while ((data = in.read()) != -1) {
                System.out.printf("%02X ", data);
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("ファイルが見つかりませんでした");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tryBad() {
        var data = new String[] {"Java", "C#", "Python"};
        try {
            var i = 0;
            // 無限ループ（指定のインデックスが範囲外になったところで例外＝終了）
            // while (true) {
            // System.out.println(data[i++]);
            // }
            for (var d : data) {
                System.out.println(d);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    public static void tryFinally() {
        FileInputStream in = null;
        try {
            in = new FileInputStream("C:/data/nothing.gif");
            var data = -1;
            while ((data = in.read()) != -1) {
                System.out.printf("%02X ", data);
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("ファイルが見つかりませんでした。");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 例外の有無に関わらずファイルをクローズ
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public static void tryWithResources() {
        try (var in = new FileInputStream("C:/data/nothing.gif")) {
            var data = -1;
            while ((data = in.read()) != -1) {
                System.out.printf("%02X ", data);
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("ファイルが見つかりませんでした。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tryMulti() {
        try (var in = new FileInputStream("C:/data/nothing.gif")) {
            var data = -1;
            while ((data = in.read()) != -1) {
                System.out.printf("%02X ", data);
            }
        } catch (IOException
        // | URISyntaxException
        e) {
            // TODO: handle exception
            System.out.println("ファイルが見つかりませんでした。");
            e.printStackTrace();
        }
    }

    // public FileInputStream(File file) throws FileNotFoundException{
    // if(name == null){
    // throw new NullPointerException();
    // }
    // if(file.isInvalid()){
    // throw new FileNotFoundException("Invalid file path");
    // }
    // }

    private static double getTrapezoidArea(double upper, double lower, double height) {
        // 引数がゼロ以下の場合に例外を発生
        assert upper > 0 && lower > 0 && height > 0 : "負数は指定できません";
        return (upper + lower) * height / 2;
    }

    // public static void rethrow(boolean flag) throws MySampleException,
    // MyLibException {
    // try {
    // if (flag) {
    // throw new MySampleException();
    // } else {
    // throw new MyLibException();
    // }

    // } catch (Exception e) {
    // // TODO: handle exception
    // throw e;
    // }
    // }

    public void readHttpPages() throws MySampleException {
        // public void readHttpPages() throws IOException, InterruptedException {
        try (var reader = Files.newBufferedReader(Paths.get("C:data/link.txt"))) {

            var line = "";
            // ページにアクセスしてその結果を出力
            while ((line = reader.readLine()) != null) {

                // Httpクライアントを生成
                var client = HttpClient.newHttpClient();

                // リクエストを準備
                var req = HttpRequest.newBuilder().uri(URI.create("https://codezine.jp/")).build();

                // レスポンスを取得
                var res = client.send(req, HttpResponse.BodyHandlers.ofString());

                // 取得したコンテンツを出力
                System.out.println(res.body());
            }
        } catch (IOException | InterruptedException e) {
            // TODO: handle exception
            // throw e;
            throw new MySampleException(e);
        }
    }

    public static void enumConstClient() {
        // var ecs = new EnumConstSeason();
        // ecs.processSeason(EnumConstSeason.Season.AUTUMN);

        // 列挙型で想定しないint型を許容しないコード
        // この行はコンパイルエラーになります（int型をSeason型に変換できないため）。
        // 列挙型がint型を許容しないのはこのためです。
        // ecs.processSeason(4);
    }

    public static void enumMethod() {
        for (var se : Season.values()) {
            System.out.println(se.ordinal() + ":" + se.toString());
        }

        var s = Season.valueOf("SPRING");
        System.out.println(s instanceof Season);
        System.out.println(s);
    }

    public static void enumBasic() {
        System.out.println(Season.SPRING);
        System.out.println(Season.SPRING.toString());
        System.out.println(Season.SPRING.toSeasonValue());

        for (var se : Season.values()) {
            se.show();
        }
    }

    public static void enumBit() {
        var ptn = Pattern.compile("^[a-z0-9._-]*", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

        var flags = Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.COMMENTS;
        if ((flags & Pattern.COMMENTS) != 0) {
            System.out.println("COMMENTSは有効です");
        }

        if ((flags & (Pattern.CASE_INSENSITIVE | Pattern.MULTILINE)) == (Pattern.CASE_INSENSITIVE
                | Pattern.MULTILINE)) {
            System.out.println("含まれています");
        }

        // Pattern.compile("^[a-z0-9._-]*",EnumSet.of(PatternFlag.CASE_INSENSITIVE,PatternFlag.MULTILINE));
    }

}
