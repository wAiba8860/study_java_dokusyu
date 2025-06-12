package to.msn.wings.studyjava.chap09;

public class Rensyu9_2 {

    public static void main(String[] args) {
        System.out.println("[1]:");
        System.out.println("catchブロックは例外を補足した時点でそのブロックを抜けるので、より狭義的なExceptionから順にcatchブロックを記述するべき（Exception eなどは一番下位）");
        System.out.println("[2]:");
        System.out.println("非検査例外は開発者が修正するべき問題であり態々例外処理をかくものではない、検査例外は開発者の意図しないものなので予測される例外はできる限り補足できるようにする");
        System.out.println("できるかぎり標準例外を利用するように心がける、独自例外をスローすることはそれだけコードの可読性が下がる");
        System.out.println("例外対象があいまりになりがちなので、Exceptionでの補足は避ける");
    }
}