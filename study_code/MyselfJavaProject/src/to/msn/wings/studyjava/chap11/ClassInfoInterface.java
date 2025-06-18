package to.msn.wings.studyjava.chap11;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface ClassInfoInterface {
    String value() default "";

    String version() default "";

    String description() default "";
}

// @ClassInfoInterface(version = "2.1", description = "アノテーションの動作テスト")
@ClassInfoInterface("2.5")
class AnnotationClient {
    public static void main(String[] args) {
        var clazz = AnnotationClient.class;
        var info = clazz.getAnnotation(ClassInfoInterface.class);
        System.out.println("バージョン: " + (info.value().equals("") ? info.version() : info.value()));
        System.out.println("説明: " + info.description());

        if (clazz.isAnnotationPresent(ClassInfoInterface.class)) {
            System.out.println("確認できました");
        }
    }
}
