package java8;

import OOP.inheritance.abstraction.Cashier;

public class BurgerKing {

    public static void main(String[] args) {
        Visitor visitor = new Visitor("Solomiya", 20);
        Cashier cashier = new Cashier("Vasyl", 29);
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

    }

    private static void drawSeparator(){
        System.out.println("\n------------------");
    }
}
