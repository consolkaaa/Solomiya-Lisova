package OOP.inheritance.abstraction;

import OOP.inheritance.Person;

//Inheritance and abstraction
public abstract class Employee extends Person {
    public boolean employed = true;

    public Employee(String name, int age) {
        super(name, age);
    }

    public abstract void hire();

    public void fire(){
        employed = false;
        System.out.println("Oops, you're fired");
    }
}
