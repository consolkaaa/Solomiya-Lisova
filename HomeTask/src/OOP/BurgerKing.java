package OOP;

import OOP.Polymorphism.IMenu;
import OOP.Relationships.Aggregation.Kitchen;
import OOP.Relationships.Composition.Visitor;
import OOP.Inheritance.Abstraction.Cashier;

public class BurgerKing {

    public static void main(String[] args) {
        Visitor visitor = new Visitor("Solomiya", 20);
        Cashier cashier = new Cashier("Vasyl", 29);
        Kitchen kitchen = new Kitchen();

        visitor.seeMenu();
        cashier.sayHello();
        visitor.makeNewOrder();

        System.out.println("Number of turned on cookers: " + kitchen.checkNumberOfCookersOn());







//
//        visitor.orderedBurgers.add(Burgers.BURGER1);
//        visitor.orderedDrinks.add(Drinks.DRINK3);
//        visitor.orderedSalads.add(Salads.SALAD1);


    }
}
