package to.msn.wings.studyjava.chap09;

public enum Season {

    // 列挙定数に独自の実装を付与
    SPRING(0, "春") {
        @Override
        public void show() {
            System.out.println("春はあけぼの");
        }
    },
    SUMMER(1, "夏") {
        @Override
        public void show() {
            System.out.println("夏は夜");
        }
    },
    AUTUMN(2, "秋") {
        @Override
        public void show() {
            System.out.println("秋は夕暮れ");
        }
    },
    WINTER(3, "冬") {
        @Override
        public void show() {
            System.out.println("冬はつとめて");
        }
    };

    // フィールド宣言
    private int code; // 季節コード
    private String jpName; // 表示名

    // コンストラクター
    private Season(int code, String jpName) {
        this.code = code;
        this.jpName = jpName;
    }

    // メソッド
    public int toSeasonValue() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.jpName;
    }

    public abstract void show();
}
