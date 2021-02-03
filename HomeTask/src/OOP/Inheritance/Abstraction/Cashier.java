package OOP.Inheritance.Abstraction;

import OOP.Relationships.Composition.Visitor;

//Inheritance and abstraction
public class Cashier extends Employee {
    public int dailyCash = 0;

    public Cashier(String name, int age) {
        super(name, age);
    }

    public void takeOrder(Visitor visitor){
        System.out.println("Hello, would you like to order anything?\n");
        visitor.seeMenu();
        visitor.makeNewOrder();
    };

    //Implementation of an abstract method
    @Override
    public void hire() {
        employed = true;
        System.out.println("Congratulations on being employed as a cashier!");
    }

}
