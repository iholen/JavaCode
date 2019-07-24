package practices.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实现一个注解
 *
 * @author huliang
 * @date 2019-06-04 14:45
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface MyAnnotation {
    String value() default "";
}
