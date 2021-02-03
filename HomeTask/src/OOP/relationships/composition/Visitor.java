package OOP.relationships.composition;

import OOP.inheritance.Person;
import OOP.polymorphism.Burgers;
import OOP.polymorphism.Drinks;
import OOP.polymorphism.Salads;

public class Visitor extends Person {

    //Visitor has an order, order makes no sense without visitor
    //Composition
    Order order =  new Order();

    public Visitor(String name, int age) {
        super(name, age);
    }

    //method not finished yet
    public void makeNewOrder(){
        order.orderedBurgers.add(Burgers.BURGER1);
        order.orderedDrinks.add(Drinks.DRINK3);
        order.orderedSalads.add(Salads.SALAD1);
        order.printCheck();
    }

    public void seeMenu(){
        System.out.println("On the menu:");
        Salads.showMenu();
        Burgers.showMenu();
        Drinks.showMenu();
    }
}
