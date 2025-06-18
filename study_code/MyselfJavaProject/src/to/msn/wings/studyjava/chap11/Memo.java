package to.msn.wings.studyjava.chap11;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Repeatable(MemoList.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface Memo {
    String value() default "";
}

@Memo("検証用")
@Memo("列挙")
@Memo("出力")
class MemoClient {
    public static void main(String[] args) {
        var memo = MemoClient.class.getAnnotationsByType(Memo.class);
        for (var m : memo) {
            System.out.println(m.value());
        }
    }
}
