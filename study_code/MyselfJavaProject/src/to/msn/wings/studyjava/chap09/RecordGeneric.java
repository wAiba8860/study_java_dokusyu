package to.msn.wings.studyjava.chap09;

//T型の値を保持するValueレコード
record Value<T>(T value) {
}

public class RecordGeneric {
    public static void main(String[] args) {
        // Value<Object> obj = new Value<>("Hoge");
        Value<Object> obj = new Value<>(-3193801);
        System.out.println(switch (obj) {
            case Value<Object>(String value) -> "文字列長: " + value.length();
            case Value<Object>(Integer value) -> "絶対値: " + Math.abs(value);
            default -> "Unknown...";
        });
    }
}
