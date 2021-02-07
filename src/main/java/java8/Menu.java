package java8;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public static void printDishesList(List<Dishes> list){
        list.stream().map(dish -> dish.getName() + "\t\t" + dish.getPrice())
                     .forEach(dishInfo -> System.out.println(dishInfo));
    }

    private static Predicate<Dishes> isVeggie = Dishes::getVegeterian;

    public static void printVegeterian(){
        List<Dishes> isVeggieList = new ArrayList<>();
        isVeggieList = dishesList.stream().filter(isVeggie).collect(Collectors.toList());

        System.out.println("\nThere are " + isVeggieList.size() + " vegeterian dishes:");
        printDishesList(isVeggieList);
    }

    private static BiPredicate<Dishes, String> belongsToCategory = (dish, category) -> category.equals(dish.getCategory());

    public static List<Dishes> getDishesCategory(String category){
        return dishesList.stream()
                .filter(dish -> belongsToCategory.test(dish,category))
                .collect(Collectors.toList());
    }

    public static void showMenuCategory(String category){
        System.out.println("\nCategory:\t" + category);
        System.out.println("Dish\t\tPrice");
        printDishesList(getDishesCategory(category));
    }

    public static void showMenu(){
        System.out.println("\nOn the menu:");
        dishesList.stream().map(dishes -> dishes.getCategory())
                  .distinct().forEach(Menu::showMenuCategory);
    }

    private static Comparator<Dishes> priceComparator = (o1, o2) -> Integer.compare(o1.getPrice(), o2.getPrice());

    private static void sortDishesByPrice(List<Dishes> dishesList){
        Collections.sort(dishesList, priceComparator);
    }

    public static void showSortedDishes(){
        System.out.println("\nSorted dishes by price:");
        sortDishesByPrice(dishesList);
        printDishesList(dishesList);
    }


//    public static void checkPrice(String operator, int value){
//        int number = countDishesByPrice(operator, value);
//
//        //dishesList.stream().filter()
//
//        if (number == dishesList.size()){
//            System.out.println("\nAll the dishes correspond to your criteria \"price" + operator + value + "\"");
//        }
//        else if (number >= 1){
//            System.out.println("\nOne or more dish corresponds to your criteria \"price" + operator + value + "\"");
//        }
//        else{
//            System.out.print("\nThere is no dish corresponding to your criteria \"price" + operator + value + "\"\n");
//        }
//    }

    private static int countDishesByPrice(String operator, int value){

        switch (operator){
            case ">": {
                return (int)dishesList.stream().filter(dish -> dish.getPrice() > value).count();
            }
            case "<": {
                return (int)dishesList.stream().filter(dish -> priceIsLessThan.test(dish,value)).count();
            }
            case "=": {
                return (int)dishesList.stream().filter(dish -> priceIsEqual.test(dish,value)).count();
            }
        }
        return 0;
    }

    private static BiPredicate<Dishes, Integer> priceIsBiggerThan = (dish, value) -> dish.getPrice() > value;
    private static BiPredicate<Dishes, Integer> priceIsLessThan = (dish, value) -> dish.getPrice() < value;
    private static BiPredicate<Dishes, Integer> priceIsEqual = (dish, value) -> dish.getPrice() == value;

    public static void checkAnyMatch(BiPredicate<Dishes, Integer> predicate, int value){
        if (dishesList.stream().anyMatch(dish -> predicate.test(dish, value))){
            //System.out.println("At least one dish has price " + operator + " than " + value);
        }
    }

    public static void checkAllMatches(BiPredicate<Dishes, Integer> predicate, int value){
        if (dishesList.stream().allMatch(dish -> predicate.test(dish, value))){
            //System.out.println("All the dishes have price " + operator + " than " + value);
        }
    }

    public static void checkNoneMatches(BiPredicate<Dishes, Integer> predicate, int value){
        if (dishesList.stream().noneMatch(dish -> predicate.test(dish, value))){
            //System.out.println("None of the dishes have price " + operator + " than " + value);
        }
    }

    private static Dishes getDishWithSmallestPrice(String category){
        List<Dishes> dishesCategoryList = new ArrayList<>();

        dishesCategoryList = getDishesCategory(category);
        sortDishesByPrice(dishesCategoryList); //sort category list
        return dishesCategoryList.get(0);      //return dish with the smallest price
    }

    private static Comparator<Dishes> nameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

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
