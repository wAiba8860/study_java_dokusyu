package to.msn.wings.selfjava.chap09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResources {

  public static void main(String[] args) {
    try (var in = new FileInputStream("C:/data/nothing.gif")) {
      var data = -1;
      while ((data = in.read()) != -1) {
        System.out.printf("%02X ", data);
      }
    } catch (FileNotFoundException e) {
      System.out.println("ファイルが見つかりませんでした。");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
