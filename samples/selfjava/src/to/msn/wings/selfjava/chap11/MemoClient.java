package to.msn.wings.selfjava.chap11;

@Memo("検証用")
@Memo("列挙")
@Memo("出力")
public class MemoClient {
  public static void main(String[] args) {
    var memo = MemoClient.class.getAnnotationsByType(Memo.class);
    for (var m : memo) {
      System.out.println(m.value());
    }
  }
}
