package to.msn.wings.studyjava.chap02;

public class rensyu2_2 {
    public static void main(String[] args) {
        System.out.println("[1]:byte,int,long,float,double,string,char,boolean");
        System.out.println("[2]:基本型はデータをそのまま格納するが、参照型はデータが補完されているアドレスを格納する。");
        test();
    }

    public static void test() {
        var str = """
                夏は夜。
                月のころはさらなり、\
                闇をなほ、"ほたる"の多く飛びちがひたる。
                """;
        var list = new int[][] {
                { 1, 2 },
                { 2, 4, 5, 6 },
                { 3, 7, 9 },
        };
        System.out.println(str);
        System.out.println(list[1][2]);
        System.out.println(list.length);
        System.out.println(33333333333L);
        System.out.println('あ');
        System.out.println('\u3042');
        System.out.println("You Are 'GREAT' player!");
    }
}