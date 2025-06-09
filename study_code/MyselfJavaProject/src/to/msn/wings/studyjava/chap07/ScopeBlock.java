package to.msn.wings.studyjava.chap07;

public class ScopeBlock {

    static void main(String[] args) {
        // エラー
        // var data = "ローカルスコープ";
        {
            var data = "ブロックスコープ1";
            System.out.println(data);
        }
        {
            var data = "ブロックスコープ2";
            System.out.println(data);
        }
        var data = "ローカルスコープ";
        System.out.println(data);
    }
}