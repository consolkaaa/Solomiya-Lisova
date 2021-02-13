package java8;

import java8.Dishes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Order {

    @MakeWithout(withoutMeat = false, withoutOnions = false)
    public List<Dishes> orderedDishes = new ArrayList<>();
    private LocalDateTime dateAndTime=  LocalDateTime.now();

    private MakeWithout makeWithout;

    public Order(List<Dishes> orderedDishes){
        this.orderedDishes = orderedDishes;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    private int totalprice = 0;

    private BiPredicate<Dishes, MakeWithout> withoutBoth = (dish,without) -> without.withoutMeat() & without.withoutOnions();
    private BiPredicate<Dishes, MakeWithout> withoutMeat = (dish,without) -> without.withoutMeat() & !without.withoutOnions();
    private BiPredicate<Dishes, MakeWithout> withoutOnion = (dish,without) -> !without.withoutMeat() & without.withoutOnions();
    private BiPredicate<Dishes, MakeWithout> withBoth = (dish,without) -> !without.withoutMeat() & !without.withoutOnions();

    private BiConsumer<BiPredicate, Double> check = (predicate, n) -> orderedDishes.stream().filter(dish -> predicate.test(dish, makeWithout)).
            forEach(dish -> {
                double lowedPrice = Math.round(dish.getPrice() * n);
                System.out.println(dish.getName() + "\t\t" + lowedPrice);
                totalprice += Math.round(lowedPrice);
            });


    public void printCheck() {
        System.out.println("\nYour order is:\n");

        Field[] fields = Order.class.getDeclaredFields();
        Arrays.stream(fields).forEach(f -> {
            Annotation[] annotations = f.getDeclaredAnnotations();

            Arrays.stream(annotations).forEach(annotation -> {
                if(annotation.annotationType().equals(MakeWithout.class)) {
                    makeWithout = (MakeWithout) annotation;
                }
            });
        });

        if (makeWithout != null) {
            check.accept(withoutBoth, 0.8);
            check.accept(withoutMeat, 0.83);
            check.accept(withoutOnion, 0.97);
            check.accept(withBoth, 1.0);

            System.out.println("Total price is: " + totalprice);
        } else {
            orderedDishes.stream().forEach(dish -> {
                System.out.println(dish.getName() + "\t\t" + dish.getPrice());
                totalprice +=  dish.getPrice();
            });
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy, HH:mm");
        System.out.println("\nOrder time: " + getDateAndTime().format(formatter));
    }
}



