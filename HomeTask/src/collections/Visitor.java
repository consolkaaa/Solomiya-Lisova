package collections;

import OOP.inheritance.Person;

public class Visitor extends Person {

    public Visitor(String name, int age) {
        super(name, age);
    }

    public void seeMenu(){
        Menu.printDishesList();
    }

    public void seeMenuCategory(String category){
        try {
            Menu.showMenuCategory(category);
        } catch (Exception e){
            System.out.println("No such category");     //FIX
        }
    }


}
