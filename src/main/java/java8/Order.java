package java8;

import java8.Dishes;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    //@MakeWithout(withoutMeat = false, withoutOnions = false)
    private List<Dishes> orderedDishes = new ArrayList<>();
    private LocalDateTime dateAndTime=  LocalDateTime.now();

    public Order(List<Dishes> orderedDishes){
        this.orderedDishes = orderedDishes;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void printCheck(){
        int price = 0;

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
