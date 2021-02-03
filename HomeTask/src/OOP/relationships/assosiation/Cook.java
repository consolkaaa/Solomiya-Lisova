package OOP.relationships.assosiation;

import OOP.inheritance.abstraction.Employee;

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


