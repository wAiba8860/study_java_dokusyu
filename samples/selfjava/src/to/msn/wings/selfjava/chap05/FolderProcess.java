package to.msn.wings.selfjava.chap05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FolderProcess {

  public static void main(String[] args) {
    try {
      var dir1 = Paths.get("C:/data/selfjava");
      var dir2 = Paths.get("C:/Windows");

      Files.createDirectories(dir1);
      System.out.println(Files.exists(dir1));
      System.out.println(Files.isDirectory(dir1));
      try (var s = Files.list(dir2)) {
        s.filter(v -> v.getFileName().toString().endsWith(".log")).
          forEach(System.out::println);
      }
      var dir3 = Files.copy(dir1, Paths.get("C:/data/selfjava/test"),
        StandardCopyOption.REPLACE_EXISTING);
      Files.move(dir3, Paths.get("C:/data/selfjava/sub"),
          StandardCopyOption.REPLACE_EXISTING);
      Files.delete(Paths.get("C:/data/selfjava/sub"));
      Files.deleteIfExists(Paths.get("C:/data/selfjava/sub"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
