package to.msn.wings.selfjava.chap03;

public class Increment {

  public static void main(String[] args) {
    var i = 3;
    var j = ++i;
    System.out.println(i);
    System.out.println(j);

    var m = 3;
    var n = m++;
    System.out.println(m);
    System.out.println(n);
  }
}
