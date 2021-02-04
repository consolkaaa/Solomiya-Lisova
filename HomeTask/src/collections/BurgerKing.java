package collections;

import collections.Menu;
import collections.Visitor;
import OOP.inheritance.abstraction.Cashier;

public class BurgerKing {

    public static void main(String[] args) {
        Visitor visitor = new Visitor("Solomiya", 20);
        Cashier cashier = new Cashier("Vasyl", 29);

//        visitor.seeMenu();
//
//        Menu.sortDishesByPrice();
//        visitor.seeMenu();

        //Salads Burgers Drinks
//        Menu.showMenuCategory("Salads");
//        Menu.showMenuCategory("Burgers");
//        Menu.showMenuCategory("Drinks");
//        Menu.showMenuCategory("g");

          visitor.seeMenuCategory("Burrs");

    }
}
