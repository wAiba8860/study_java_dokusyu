package to.msn.wings.studyjava.chap09;

class MyClassNotStatic {
    private String str1 = "包含・インスタンス";
    private static String str2 = "包含・クラス";

    // 非staticメンバークラスの定義
    private class MyHelperNotStatic {
        private String str1 = "ネスト・インスタンス";
        private static final String str2 = "ネスト・クラス";

        public void show() {
            System.out.println(MyClassNotStatic.this.str1);
            System.out.println(MyClassNotStatic.str2);
        }
    }

    public void run() {
        var helper = new MyHelperNotStatic();
        helper.show();
        System.out.println(helper.str1);
        System.out.println(MyHelperNotStatic.str2);
    }
}
