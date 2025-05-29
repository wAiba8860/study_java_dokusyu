package to.msn.wings.selfjava.chap11;

public class Article {
  private String title;
  private String url;

  public Article(String title, String url) {
    this.title = title;
    this.url = url;
  }

  @Override
  public String toString() {
    return String.format("タイトル：%s（%s）",
        this.title, this.url);
  }
}
