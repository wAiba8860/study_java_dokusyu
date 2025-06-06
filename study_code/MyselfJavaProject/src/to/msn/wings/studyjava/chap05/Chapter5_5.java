package to.msn.wings.studyjava.chap05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.Normalizer.Form;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Chapter5_5 {
    public static void main(String[] args) {
        httpPost();
    }

    public static void streamWrite() {
        try (var writer = Files.newBufferedWriter(Paths.get("C:\\開発用\\Java\\data\\data.log"),
                StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write(LocalDateTime.now().toString());
            writer.newLine();
            // writer.write(LocalDateTime.now().toString() + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileWrite() {
        var filePath = "C:\\開発用\\Java\\data\\list.txt";
        List<String> lines = List.of("春はあけぼの。やうやう白くなり行く、山ぎはすこし…", "夏は夜。月のころはさらなり。やみもなほ、ほたるの…",
                "秋は夕暮れ。夕日のさして山の端いと近うなりたるに…", "冬はつとめて。雪の降りたるは、いふべきにもあらず…");
        try {
            Files.write(Paths.get(filePath), lines, StandardCharsets.UTF_8);
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
                var out = new BufferedOutputStream(
                        new FileOutputStream("C:\\開発用\\Java\\data\\output.png"));) {
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
            out.writeObject(
                    new Article("最新Javaアップデート情報", "https://codezine.jp/article/corner/839", false));
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
        var array1 = new String[] { "dog", "cat", "mouse", "fox", "lion" };
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.binarySearch(array1, "mouse"));

        var array2 = new String[] { "あ", "い", "う", "え", "お" };
        var array3 = Arrays.copyOf(array2, 2);
        System.out.println(Arrays.toString(array3));

        var array4 = Arrays.copyOfRange(array2, 1, 7);
        System.out.println(Arrays.toString(array4));

        Arrays.fill(array4, 4, 6, "--");
        System.out.println(Arrays.toString(array4));
    }

    public static void arrayShallow() {
        var list1 = new StringBuilder[] { new StringBuilder("ドレミファソ"), new StringBuilder("CDEFG"),
                new StringBuilder("ハニホヘト") };

        var list2 = Arrays.copyOf(list1, list1.length);

        list1[2].append("イロハ");
        System.out.println(Arrays.toString(list1));
        System.out.println(Arrays.toString(list2));
    }

    public static void arrayDeep() {
        var list1 = new StringBuilder[] { new StringBuilder("ドレミファソ"), new StringBuilder("CDEFG"),
                new StringBuilder("ハニホヘト") };

        var list2 = new StringBuilder[list1.length];
        for (var i = 0; i < list1.length; i++) {
            list2[i] = new StringBuilder(list1[i].toString());
        }

        list1[2].append("イロハ");
        System.out.println(Arrays.toString(list1));
        System.out.println(Arrays.toString(list2));
    }

    public static void normalizeBasic() {
        var types = new Form[] { Form.NFD, Form.NFC, Form.NFKD, Form.NFKC };
        var chs = new String[] { "ギガ", "ｷﾞｶﾞ", "キ゛カ゛", "㌐" };

        try (var writer = Files.newBufferedWriter(Paths.get("D:\\Java\\data\\data.txt"),
                StandardOpenOption.CREATE)) {
            for (var type : types) {
                writer.write("■ " + type + "\n");
                for (var ch : chs) {
                    writer.write(ch + " => " + Normalizer.normalize(ch, type));
                    writer.newLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileProcess() {
        try {
            var path1 = Paths.get("D:/Java/data/sample.txt");

            // ファイルは存在するか
            System.out.println(Files.exists(path1));

            // ファイルは読み取り可能か
            System.out.println(Files.isReadable(path1));

            // ファイルは書き込み可能か
            System.out.println(Files.isWritable(path1));

            // ファイルは実行可能か
            System.out.println(Files.isExecutable(path1));

            // ファイルのサイズを取得
            System.out.println(Files.size(path1));

            // ファイルをコピー（存在する場合は置換）
            var path2 = Files.copy(path1, Paths.get("D:/Java/data/copy.txt"),
                    StandardCopyOption.REPLACE_EXISTING);

            // ファイルを移動（存在する場合は置換）
            Files.move(path2, Paths.get("D:/Java/data/sub/copy.txt"),
                    StandardCopyOption.REPLACE_EXISTING);

            // ファイル名を変更（存在する場合は置換）
            var path3 = Files.move(path1, Paths.get("D:/Java/data/sub/rename.txt"),
                    StandardCopyOption.REPLACE_EXISTING);

            // Files.delete(path3);

            // ファイルが存在する場合にだけ削除
            // Files.deleteIfExists(path3);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void folderProcess() {

        var dir1 = Paths.get("D:/Java/data/selfJava");
        var dir2 = Paths.get("C:/Windows");

        try (var s = Files.list(dir2)) {
            // フォルダーを作成
            Files.createDirectories(dir1);

            // フォルダーが存在するか
            System.out.println(Files.exists(dir1));

            // フォルダーか
            System.out.println(Files.isDirectory(dir1));

            s.filter(v -> v.getFileName().toString().endsWith(".log")).forEach(System.out::println);

            var dir3 = Files.copy(dir1, Paths.get("D:/Java/data/selfJava/test"),
                    StandardCopyOption.REPLACE_EXISTING);

            Files.move(dir3, Paths.get("D:/Java/data/selfJava/sub"),
                    StandardCopyOption.REPLACE_EXISTING);

            // Files.delete(Paths.get("D:/data/selfJava/sub"));

            // Files.deleteIfExists(Paths.get("D:/Java/data/selfJava/sub"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void httpBasic() {
        try {

            // httpクライアントを生成
            var client = HttpClient.newHttpClient();

            // リクエストを準備
            var req = HttpRequest.newBuilder().uri(URI.create("https://codezine.jp")).build();

            // レスポンスを取得
            // var res = client.send(req, HttpResponse.BodyHandlers.ofString());

            // 取得したコンテンツを出力
            // System.out.println(res.body());
            // System.out.println(res.headers());

            // 非同期
            client.sendAsync(req, HttpResponse.BodyHandlers.ofString()).thenAccept(response -> {
                System.out.println(response.body());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void httpPost() {
        try {

            var client = HttpClient.newHttpClient();
            var req = HttpRequest.newBuilder().uri(URI.create("http://localhost/selfphp/JavaSample/post.php"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"name\": \"佐々木新之助\"}")).build();

            var res = client.send(req, HttpResponse.BodyHandlers.ofString());

            // 取得したコンテンツを出力
            System.out.println(res.body());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
