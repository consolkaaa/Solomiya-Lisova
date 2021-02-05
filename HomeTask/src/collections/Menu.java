package collections;

import collections.Dishes;

import java.util.*;

public class Menu{
    private static Dishes salad1, salad2, salad3;
    private static Dishes burger1, burger2, burger3;
    private static Dishes drink1, drink2, drink3;

    public static List<Dishes> dishesList = new ArrayList<Dishes>();
    //public static Map<Integer,Dishes> dishNumber = new TreeMap<>();

    public Menu(){
        salad1 = new Dishes("salad1",81, 300, "Salads", true);
        salad2 = new Dishes("salad2", 75, 420, "Salads", false);
        salad3 = new Dishes("salad3",60, 370, "Salads", false);

        burger1 = new Dishes("burger1",80, 500, "Burgers", false);
        burger2 = new Dishes("burger2",70, 600, "Burgers", false);
        burger3 = new Dishes("burger3",64, 560, "Burgers", true);

        drink1 = new Dishes("drink1",37, 120, "Drinks", true);
        drink2 = new Dishes("drink2",29, 130, "Drinks", false);
        drink3 = new Dishes("drink3",34, 70, "Drinks", true);

        dishesList = Arrays.asList(salad1, salad2, salad3, burger1, burger2, burger3, drink1, drink2, drink3);

    }

    private static Comparator<Dishes> priceComparator= new Comparator<Dishes>(){
        @Override
        public int compare(Dishes o1, Dishes o2) {
            return Integer.compare(o1.getPrice(), o2.getPrice());
        }
    };

    private static Comparator<Dishes> nameComparator= new Comparator<>(){
        @Override
        public int compare(Dishes o1, Dishes o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static void printDishesList(List<Dishes> list){
        for (Dishes dish: list) {
            System.out.println(dish.getName() + "\t\t" + dish.getPrice());
        }
    }

    public static List<Dishes> getDishesCategory(String category){
        List<Dishes> categoryList = new ArrayList<>();

        for (Dishes dish: dishesList) {
            if (category.equals(dish.getCategory())){
                categoryList.add(dish);
            }
        }
        return categoryList;
    }

    public static void showMenuCategory(String category){
        System.out.println("\nCategory:\t" + category);
        System.out.println("Dish\t\tPrice");
        printDishesList(getDishesCategory(category));
    }

    public static void showMenu(){
        System.out.println("\nOn the menu:");
        showMenuCategory("Salads");
        showMenuCategory("Burgers");
        showMenuCategory("Drinks");
    }

    private static void sortDishesByPrice(List<Dishes> dishesList){
        Collections.sort(dishesList, priceComparator);
    }

    public static void showSortedDishes(){
        System.out.println("\nSorted dishes by price:");
        sortDishesByPrice(dishesList);
        printDishesList(dishesList);
    }

    public static void checkPrice(String criteria, int value){
        int number = countDishesByPrice(criteria, value);

        if (number == dishesList.size()){
            System.out.println("\nAll the dishes correspond to your criteria \"price" + criteria + value + "\"");
        }
        else if (number >= 1){
            System.out.println("\nOne or more dish corresponds to your criteria \"price" + criteria + value + "\"");
        }
        else{
            System.out.print("\nThere is no dish corresponding to your criteria \"price" + criteria + value + "\"\n");
        }
    }

    private static int countDishesByPrice(String check, int value){
        Collections.sort(dishesList, priceComparator);

        int counter = 0;

        switch (check){
            case ">": {
                for (Dishes dish:dishesList) {
                    if (dish.getPrice() > value){
                        counter++;
                    }
                }
            } break;
            case "<": {
                for (Dishes dish:dishesList) {
                    if (dish.getPrice() < value){
                        counter++;
                    }
                }
            }break;
            case "=": {
                for (Dishes dish:dishesList) {
                    if (dish.getPrice() == value){
                        counter++;
                    }
                }
            } break;
        }
        return counter;
    }

    private static Dishes getDishWithSmallestPrice(String category){
        List<Dishes> dishesCategoryList = new ArrayList<>();

        dishesCategoryList = getDishesCategory(category);
        sortDishesByPrice(dishesCategoryList); //sort category list
        return dishesCategoryList.get(0);      //return dish with the smallest price
    }

    public static void traverse(){
        List<Dishes> smallestPrice = new ArrayList<>();

        smallestPrice.add(getDishWithSmallestPrice("Salads"));
        smallestPrice.add(getDishWithSmallestPrice("Burgers"));
        smallestPrice.add(getDishWithSmallestPrice("Drinks"));
        smallestPrice.sort(nameComparator);
        System.out.println("\nDishes with the smallest price from each category (sorted alphabetically):");
        printDishesList(smallestPrice);
    }

}
