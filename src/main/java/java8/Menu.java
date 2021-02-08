package java8;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Menu{
    private static Dishes salad1, salad2, salad3;
    private static Dishes burger1, burger2, burger3;
    private static Dishes drink1, drink2, drink3;

    public static List<Dishes> dishesList = new ArrayList<Dishes>();

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

    private static BiPredicate<Dishes, Integer> priceIsBiggerThan = (dish, value) -> dish.getPrice() > value;
    private static BiPredicate<Dishes, Integer> priceIsLessThan = (dish, value) -> dish.getPrice() < value;
    private static BiPredicate<Dishes, Integer> priceIsEqual = (dish, value) -> dish.getPrice() == value;
    private static Predicate<Dishes> isVeggie = Dishes::getVegeterian;

    public static void printVegeterian(){
        List<Dishes> isVeggieList = new ArrayList<>();
        isVeggieList = dishesList.stream().filter(isVeggie).collect(Collectors.toList());

        System.out.println("\nThere are " + isVeggieList.size() + " vegeterian dishes:");
        printDishesList(isVeggieList);
    }

    public static void checkAnyMatch(String operator, int price){
        BiPredicate<Dishes, Integer> predicate = getPredicate(operator);

        if (dishesList.stream().anyMatch(dish -> predicate.test(dish, price))){
            System.out.println("At least one dish has price " + operator + " " + price);
        }else{
            System.out.println("None of the dishes has price " + operator + " " + price);
        }
    }

    public static void checkAllMatches(String operator, int price){
        BiPredicate<Dishes, Integer> predicate = getPredicate(operator);

        if (dishesList.stream().allMatch(dish -> predicate.test(dish, price))){
            System.out.println("All the dishes have price " + operator + " " + price);
        }else{
            System.out.println("Not all or none dishes have price " + operator + " " + price);
        }
    }

    public static void checkNoneMatches(String operator, int price){
        BiPredicate<Dishes, Integer> predicate = getPredicate(operator);

        if (dishesList.stream().noneMatch(dish -> predicate.test(dish, price))){
            System.out.println("None of the dishes has price " + operator + " " + price);
        }else{
            System.out.println("One or more dishes have price " + operator + " " + price);
        }
    }

    private static BiPredicate<Dishes, Integer> getPredicate(String operator){
        BiPredicate<Dishes, Integer> predicate;

        switch (operator){
            case ">": {
                return priceIsBiggerThan;
            }
            case "<": {
                return priceIsLessThan;
            }
            case "=": {
                return priceIsEqual;
            }
        }
        return null;
    }

    private static Dishes getDishWithSmallestPrice(String category){
        List<Dishes> dishesCategoryList = new ArrayList<>();

        dishesCategoryList = getDishesCategory(category);
        sortDishesByPrice(dishesCategoryList); //sort category list
        return dishesCategoryList.get(0);      //return dish with the smallest price
    }

    private static Comparator<Dishes> nameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

    //I haven't made this method with Java8 yet, had some difficulties
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
