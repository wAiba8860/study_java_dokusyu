package to.msn.wings.selfjava.chap11.sub;

public class AnnotationPackage {
  public static void main(String[] args) {
    var p = AnnotationPackage.class.getPackage();
    var dep = p.getAnnotation(Deprecated.class);
    System.out.println(dep.since() + "以降、非推奨" +
      (dep.forRemoval() ? "（削除予定）" : ""));
  }
}
