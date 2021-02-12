package java8;

import OOP.inheritance.Person;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Visitor extends Person {

    @MakeWithout(withoutMeat = false, withoutOnions = false)
    List<Dishes> orderList = new ArrayList<>();

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

   // @MakeWithout(withoutMeat = true, withoutOnions = false)
    public void makeOrder(@MakeWithout(withoutMeat = true, withoutOnions = false) List<Dishes> orderList){

        Order order = new Order(orderList);
        order.printCheck();
    }

}


