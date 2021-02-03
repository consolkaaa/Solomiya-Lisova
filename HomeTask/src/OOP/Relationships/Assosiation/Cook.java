package OOP.Relationships.Assosiation;

import OOP.Inheritance.Abstraction.Employee;

public class Cook extends Employee {
    private int dishesCooked = 0;

    public Cook(String name, int age) {
        super(name, age);
    }

    //Cook using cooker
    //Association
    public void cookNewDish(Cooker cooker){
        cooker.isOn = true;
        dishesCooked++;
    }

    @Override
    public void hire() {
        employed = true;
        System.out.println("Congratulations on being employed as a cook!");
    }
}


