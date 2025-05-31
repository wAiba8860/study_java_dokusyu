package to.msn.wings.studyjava.chap01; //パッケージ宣言

import java.time.LocalDateTime; //インポート命令

public class ensyu { // クラス宣言
    // 現在日時を求める :コメントアウト

    public static void main(String[] args) { // 関数宣言→メソッド
        LocalDateTime time = LocalDateTime.now(); // メンバー→命令文
        System.out.println(time);
        System.out.println(
                "[1]:Javaはオブジェクト指向型のプログラミング言語で、メモリリークを自動で防いでくれるガーベージコレクションを搭載している。また、Javaはjava仮想マシンと呼ばれるソフトウェア上で動作する");
        System.out.println("[3]:mainメソッドから実行される・エントリーポイント");
        System.out.println("[4]:セミコロン");
        System.out.println("[5]:// /* */ /** */://は一行コメントアウト:/* */は複数行コメントアウト:/** */はドキュメンテーションコメントアウト");
    }
}