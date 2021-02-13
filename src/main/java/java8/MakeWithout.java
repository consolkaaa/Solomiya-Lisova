package java8;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MakeWithout {
    public boolean withoutOnions() default true;
    public boolean withoutMeat() default true;
}
