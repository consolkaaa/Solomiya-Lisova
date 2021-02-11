package java8;

import OOP.inheritance.Person;
import collections.Dishes;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

    @MakeWithout(withoutMeat = true, withoutOnions = false)
    public void makeOrder(){
        Order order = new Order();

//        @MakeWithout(withoutMeat = false, withoutOnions = false) Menu.burger1;
//        Menu.dishesList.get(0);

//        order.orderedDishes.add(@MakeWithout(withoutMeat = false, withoutOnions = false) Menu.burger1;
//        order.orderedDishes.add(Menu.salad1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy, HH:mm");
        System.out.println("\nOrder time is: " + order.getDateAndTime().format(formatter));
    }

}


