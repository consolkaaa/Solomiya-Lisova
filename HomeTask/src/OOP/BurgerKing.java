package OOP;

import OOP.relationships.aggregation.Kitchen;
import OOP.relationships.composition.Visitor;
import OOP.inheritance.abstraction.Cashier;

public class BurgerKing {

    public static void main(String[] args) {
        Visitor visitor = new Visitor("Solomiya", 20);
        Cashier cashier = new Cashier("Vasyl", 29);
        Kitchen kitchen = new Kitchen();

        visitor.seeMenu();
        cashier.takeOrder(visitor);

//        Salads salad = Salads.SALAD1;
//        salad.showCategory();

        System.out.println("\nNumber of turned on cookers: " + kitchen.checkNumberOfCookersOn());


    }
}
