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
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Order {

    @MakeWithout(withoutMeat = true, withoutOnions = false)
    private List<Dishes> orderedDishes = new ArrayList<>();
    private LocalDateTime dateAndTime=  LocalDateTime.now();

    public Order(List<Dishes> orderedDishes){
        this.orderedDishes = orderedDishes;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    private int totalprice = 0;

    public void printCheck() {
         int price = 0;

        Predicate<Annotation> isMakeWithout = annotation -> annotation.annotationType().equals(MakeWithout.class);

        Field[] fields = Order.class.getDeclaredFields();
        Arrays.stream(fields).forEach(f -> {
            Annotation[] annotations = f.getDeclaredAnnotations();
            Arrays.stream(annotations).filter(isMakeWithout).forEach(annotation -> {
                MakeWithout makeWithout = (MakeWithout) annotation;

                orderedDishes.stream().forEach(dish -> {
                    if(makeWithout.withoutMeat() & makeWithout.withoutOnions()) {
                        dish.countWithoutProduct(0.8);
                    }else if(makeWithout.withoutMeat()){
                        dish.countWithoutProduct(0.83);
                    }else{
                        dish.countWithoutProduct( 0.97);
                    }
                    totalprice += dish.getPrice();
                });
            });
        });

//        Field[] fields = Order.class.getDeclaredFields();
//        Arrays.stream(fields).forEach(f -> {
//            Annotation[] annotations = f.getDeclaredAnnotations();
//            Arrays.stream(annotations).forEach(annotation -> {
//                if(annotation.annotationType().equals(MakeWithout.class)){
//                MakeWithout makeWithout = (MakeWithout) annotation;
//
//                orderedDishes.stream().forEach(dish -> {
//                    if(makeWithout.withoutMeat() & makeWithout.withoutOnions()) {
//                        dish.countWithoutProduct(0.8);
//                    }else if(makeWithout.withoutMeat()){
//                        dish.countWithoutProduct(0.83);
//                    }else{
//                        dish.countWithoutProduct( 0.97);
//                    }
//                    totalprice += dish.getPrice();
//                });
//            });
//        });


        for (Field field: fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation: annotations) {
                if(annotation.annotationType().equals(MakeWithout.class)){
                    MakeWithout makeWithout = (MakeWithout) annotation;

                    for (Dishes dish: orderedDishes) {
                        if(makeWithout.withoutMeat() & makeWithout.withoutOnions()) {
                            System.out.println(dish.getName() + "\t\t" + Math.round(dish.getPrice() * 0.8));
                        }else if(makeWithout.withoutMeat()){
                            System.out.println(dish.getName() + "\t\t" + Math.round(dish.getPrice() * 0.83));
                        }else{
                            System.out.println(dish.getName() + "\t\t" + Math.round(dish.getPrice() * 0.97));
                        }
                        price += dish.getPrice();
                    }
                }
            }
        }


        System.out.println("\nYour order is:\n");
        for (Dishes dish: orderedDishes) {
            System.out.println(dish.getName() + "\t\t" + dish.getPrice());
            price += dish.getPrice();
        }
        System.out.println("Total price: " + price);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy, HH:mm");
        System.out.println("\nOrder time: " + getDateAndTime().format(formatter));
    }


}



