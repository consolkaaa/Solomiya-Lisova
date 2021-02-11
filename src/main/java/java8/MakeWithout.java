package java8;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE_PARAMETER})
public @interface MakeWithout {
    boolean withoutOnions() default true;
    boolean withoutMeat() default true;

}
