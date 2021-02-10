package OOP.relationships.composition;

import OOP.inheritance.Person;
import collections.Dishes;
import collections.Menu;

public class Visitor extends Person {

    //Visitor has an order, order makes no sense without visitor
    //Composition
    Order order =  new Order();

    public Visitor(String name, int age) {
        super(name, age);
    }

    public void seeMenu(){
        System.out.println("On the menu:\n");
        for (Dishes dish: Menu.dishesList) {
            System.out.println(dish.getName());
        }
    }
}
