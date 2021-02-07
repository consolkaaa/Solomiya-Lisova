package java8;

import OOP.inheritance.Person;

public class Visitor extends Person {

    public Visitor(String name, int age) {
        super(name, age);
    }

    public void seeMenu(){
        Menu.showMenu();
    }

    public void seeMenuCategory(String category){
        try {
            Menu.showMenuCategory(category);
        } catch (Exception e){
            System.out.println("No such category");     //FIX
        }
    }

    public void seeSmallestPricesInEachCategory(){
        Menu.traverse();
    }

    public void seeVegeterian(){
        Menu.printVegeterian();
    }

}


