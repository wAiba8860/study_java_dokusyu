package to.msn.wings.selfjava.chap09.records;

record Value<T>(T value) {}

public class RecordGeneric {
  public static void main(String[] args) {
    Value<Object> obj = new Value<>("Hoge");
    System.out.println(switch (obj) {
      case Value<Object>(String value) -> "文字列長：" + value.length();
      case Value<Object>(Integer value) -> "絶対値：" + Math.abs(value);
      default -> "Unknown...";
    });
  }  
}
