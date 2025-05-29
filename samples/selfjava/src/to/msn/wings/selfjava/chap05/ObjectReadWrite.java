package to.msn.wings.selfjava.chap05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectReadWrite {

  public static void main(String[] args) {
    final var file = "C:/data/article.ser";
    try (var out = new ObjectOutputStream(new FileOutputStream(file))) {
      out.writeObject(new Article("最新Javaアップデート解説",
        "https://codezine.jp/article/corner/839", false));
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (var in = new ObjectInputStream(new FileInputStream(file))) {
      var a = (Article)in.readObject();
      System.out.println(a);
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }
}
