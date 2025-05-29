package to.msn.wings.selfjava.chap05;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.Normalizer;
import java.text.Normalizer.Form;

public class NormalizeBasic {
  public static void main(String[] args) {
    var types = new Form[] { Form.NFD, Form.NFC, Form.NFKD, Form.NFKC };
    var chs = new String[] { "ギガ", "ｷﾞｶﾞ", "ギガ", "㌐" };

    try(var writer = Files.newBufferedWriter(
      Paths.get("c:/data/data.txt"), StandardOpenOption.CREATE)) {
      for (var type: types) {
        writer.write("■ " + type + "\n");
        for (var ch: chs) {
          writer.write(ch + " => " + Normalizer.normalize(ch, type));
          writer.newLine();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
