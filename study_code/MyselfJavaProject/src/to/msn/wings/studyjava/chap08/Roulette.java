package to.msn.wings.studyjava.chap08;

import java.util.Random;

public class Roulette extends Random {
    // ルーレットの上限値
    private int bound;

    // 委譲先のオブジェクトをフィールドに保持
    private Random random = new Random();

    public Roulette(int bound) {
        this.bound = bound;
    }

    // 必要に応じて処理を委譲
    public int nextInt() {
        return this.random.nextInt(this.bound);
    }

    // boundフィールドを上限とする値を取得
    // @Override
    // public int nextInt() {
    // return nextInt(this.bound);
    // }

    // 他の不要なメソッドは無効化 (8.2.3)
    // @Override
    // public boolean nextBoolean() {
    // throw new UnsupportedOperationException();
    // }

}
