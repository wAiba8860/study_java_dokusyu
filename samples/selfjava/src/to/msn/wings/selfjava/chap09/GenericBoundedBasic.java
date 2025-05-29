package to.msn.wings.selfjava.chap09;

import java.util.List;

public class GenericBoundedBasic {

  public static void main(String[] args) {
    var cli = new GenericBounded();
    var data1 = List.of(
      new Parent("かえる"), new Parent("にわとり"), new Parent("とんぼ"));
    var data2 = List.of(
      new Child("おたまじゃくし"), new Child("ひよこ"), new Child("やご"));
    cli.show(data1);
    cli.show(data2);
  }
}
