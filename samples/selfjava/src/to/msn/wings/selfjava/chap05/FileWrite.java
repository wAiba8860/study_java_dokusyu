package to.msn.wings.selfjava.chap05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWrite {
  public static void main(String[] args) {
    try {
      Files.write(
        Paths.get("C:/data/list.txt"),
        List.of(
          "春はあけぼの。やうやう白くなりゆく山際すこしあかりて、紫だちたる雲の細くたなびきたる。",
          "夏は夜。月の頃はさらなり、闇もなほ螢飛びちがひたる、雨などの降るさへをかし。",
          "秋は夕暮れ。夕日はなやかにさして、山の端(は)いと近くなりたるに、烏のねどころへ行くとて、三つ四つ二つなど飛びゆくさへあはれなり。まいて雁などのつらねたるが、いとちひさく見ゆる、いとをかし。日入りはてて、風の音、蟲の音など、いとあはれなり。",
          "冬はつとめて。雪の降りたるは、いふべきにもあらず。霜などのいと白きも、またさらでもいと寒きに、火など急ぎおこして、炭持てわたるも、いとつきづきし。昼になりて、ぬるくゆるびもていけば、炭櫃(すびつ)・火桶の火も、白き灰がちになりぬるはわろし。"
        ),
        StandardCharsets.UTF_8
      );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
