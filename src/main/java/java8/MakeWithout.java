package java8;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface MakeWithout {
    public boolean withoutOnions() default true;
    public boolean withoutMeat() default true;

}
