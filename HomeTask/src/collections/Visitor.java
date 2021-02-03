package collections;

import OOP.inheritance.Person;

public class Visitor extends Person {

    //Menu menu = new Menu();

    //Visitor has an order, order makes no sense without visitor
    //Composition
    //Order order =  new Order();

    public Visitor(String name, int age) {
        super(name, age);
    }

    public void seeMenu(){
        System.out.println("On the menu:\n");
        for (Dishes dish: Menu.dishesList) {
            System.out.println(dish.name);
        }
    }
}
