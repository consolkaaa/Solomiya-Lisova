package OOP.Inheritance.Abstraction;

//Inheritance and abstraction
public class Cashier extends Employee {
    public int dailyCash = 0;

    public Cashier(String name, int age) {
        super(name, age);
    }

    public void sayHello(){
        System.out.println("\nHello, would you like to order anything?\n");
    };

    //Implementation of an abstract method
    @Override
    public void employ() {
        employed = true;
        System.out.println("Congratulations on being employed as a cashier!");
    }
}
