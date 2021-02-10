package java8;

import OOP.inheritance.Person;

import java.time.format.DateTimeFormatter;
import java.util.List;

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

    public void makeOrder(){
        Order order = new Order();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy, HH:mm");
        System.out.println("\nOrder time is: " + order.getDateAndTime().format(formatter));
    }

}


