package java8;

import java8.Dishes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public List<Dishes> orderedDishes = new ArrayList<>();
    private LocalDateTime dateAndTime=  LocalDateTime.now();

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void printCheck(){
        int price = 0;

        for (Dishes dish: orderedDishes) {
            price += dish.getPrice();
        }
    }
}
