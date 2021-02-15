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

        System.out.println("\nDECORATOR");

        DishDecorator decorator1 = new DishDecorator(Menu.salad1);
        Menu.salad1 = decorator1.addExtraAvocado();

        DishDecorator decorator2 = new DishDecorator(Menu.burger1);
        Menu.burger1 = decorator2.addExtraCheese();

        DishDecorator decorator3 = new DishDecorator(Menu.drink3);
        Menu.drink3 = decorator3.addExtraIce();

        List<Dishes> order1 = Arrays.asList(
                Menu.salad1,
                Menu.burger1,
                Menu.drink3);

        visitor.makeOrder(order1);
        drawSeparator();
    }

    private static void drawSeparator(){
        System.out.println("\n------------------");
    }
}
