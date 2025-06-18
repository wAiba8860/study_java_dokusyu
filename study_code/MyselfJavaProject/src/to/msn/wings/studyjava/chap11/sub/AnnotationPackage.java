package to.msn.wings.studyjava.chap11.sub;

public class AnnotationPackage {
    public static void main(String[] args) {
        annotationPackage();
    }

    public static void annotationPackage() {
        var p = AnnotationPackage.class.getPackage();
        var dep = p.getAnnotation(Deprecated.class);
        System.out.println(dep.since() + "以降非推奨" + (dep.forRemoval() ? "（削除予定）" : ""));
    }
}
