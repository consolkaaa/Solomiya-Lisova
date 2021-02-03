package collections;

import collections.Dishes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    public Dishes salad1, salad2, salad3;
    private Dishes burger1, burger2, burger3;
    private Dishes drink1, drink2, drink3;

    public static List<Dishes> dishesList = new ArrayList<>();

    public Menu(){
        salad1 = new Dishes("salad1",99, 300, "Salads", true);
        salad2 = new Dishes("salad2", 129, 420, "Salads", false);
        salad3 = new Dishes("salad2",110, 370, "Salads", false);

        burger1 = new Dishes("salad2",50, 500, "Burgers", false);
        burger2 = new Dishes("salad2",70, 600, "Burgers", false);
        burger3 = new Dishes("salad2",64, 560, "Burgers", true);

        drink1 = new Dishes("salad2",29, 120, "Drinks", true);
        drink2 = new Dishes("salad2",45, 130, "Drinks", false);
        drink3 = new Dishes("salad2",34, 70, "Drinks", true);

        dishesList = Arrays.asList(salad1, salad2, salad3, burger1, burger2, burger3, drink1, drink2, drink3);
    }

//

    public static void show(){
//        System.out.println("On the menu:\n" + salad1.name);
//        for (Dishes dish: dishesList) {
//            System.out.println(dish.name);
//        }


    }
}
