package java8;

import java8.Dishes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurgerKing {

    public static void main(String[] args) {
        Visitor visitor = new Visitor("Solomiya", 20);
        Menu menu = new Menu();

        visitor.seeMenu();
        drawSeparator();

        // Salads Burgers Drinks
        visitor.seeMenuCategory("Burgers");
        drawSeparator();

        Menu.showSortedDishes();
        drawSeparator();

        Menu.checkAnyMatch("=", 80);
        drawSeparator();

        Menu.checkAllMatches("<", 100);
        drawSeparator();

        Menu.checkNoneMatches(">", 100);
        drawSeparator();

        visitor.seeVegeterian();
        drawSeparator();

        visitor.seeSmallestPricesInEachCategory();
        drawSeparator();

        System.out.println("\nANNOTATIONS");
        List<Dishes> order1 = new ArrayList<>();
        order1.add(Menu.burger1);
        order1.add(Menu.salad1);

        visitor.makeOrder(order1);

    }

    private static void drawSeparator(){
        System.out.println("\n------------------");
    }
}
