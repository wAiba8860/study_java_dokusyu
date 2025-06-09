package to.msn.wings.studyjava.chap07;

public class Rensyu7_1 {

    public static void main(String args[]) {
        System.out.println("[1]:");
        System.out.println("[2]:");
        System.out.println("フィールド変数はクラス全体で有効な変数");
        System.out.println("ローカル変数はフィールドのメソッド内で有効な変数");
        System.out.println("フィールド変数の宣言場所はクラスのトップレベルで、ローカル変数はメソッド内で宣言する");

    }

}

// クラスブロックにprotectedは不可
class pClass {
    // フィールド変数にvarは不可
    public int data = 10;

    public void hoge(int data) {
        if (data < 0) {
            // 引数dataと重複している
            data = 0;
        }
        System.out.println(data);
    }
}