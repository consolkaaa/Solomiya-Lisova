package collections;

import collections.Dishes;

import java.util.*;

public class Menu {
    private static Dishes salad1, salad2, salad3;
    private static Dishes burger1, burger2, burger3;
    private static Dishes drink1, drink2, drink3;

    public static List<Dishes> dishesList = new ArrayList<Dishes>();

    public Menu(){
        salad1 = new Dishes("salad1",99, 300, "Salads", true);
        salad2 = new Dishes("salad2", 129, 420, "Salads", false);
        salad3 = new Dishes("salad3",110, 370, "Salads", false);

        burger1 = new Dishes("burger1",50, 500, "Burgers", false);
        burger2 = new Dishes("burger2",70, 600, "Burgers", false);
        burger3 = new Dishes("burger3",64, 560, "Burgers", true);

        drink1 = new Dishes("drink1",29, 120, "Drinks", true);
        drink2 = new Dishes("drink2",45, 130, "Drinks", false);
        drink3 = new Dishes("drink3",34, 70, "Drinks", true);

        dishesList = Arrays.asList(salad1, salad2, salad3, burger1, burger2, burger3, drink1, drink2, drink3);
    }

    private static Comparator<Dishes> priceComparator= new Comparator<Dishes>(){
        @Override
        public int compare(Dishes o1, Dishes o2) {
            return Integer.compare(o1.getPrice(), o2.getPrice());
        }
    };

//    private static Comparator<Dishes> categoryComparator= new Comparator<Dishes>(){
//        @Override
//        public int compare(Dishes o1, Dishes o2) {
//            return o1.getCategory().compareTo(o2.getCategory());
//        }
//    };

    public static void sortDishesByPrice(){
        Collections.sort(dishesList, priceComparator);
        //printDishesList();
    }

    public static void printDishesList(){
        System.out.println("\nOn the menu:\n");
        System.out.println("Dish\t\tPrice");
        for (Dishes dish: dishesList) {
            System.out.println(dish.getName() + "\t\t" + dish.getPrice());
        }
    }

    public static void showMenuCategory(String category){
        System.out.println("\nCategory:");
        System.out.println("Dish\t\tPrice");
        for (Dishes dish : dishesList) {
            int comp = dish.getCategory().compareTo(category);
            if (comp == 0) {
                System.out.println(dish.getName() + "\t\t" + dish.getPrice());
            }
        }
    }

}
