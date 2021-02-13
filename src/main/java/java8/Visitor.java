package java8;

import OOP.inheritance.Person;

import java.awt.*;
import java.lang.reflect.Field;
import java.text.Annotation;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Visitor extends Person {

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

    public void makeOrder(List<Dishes> orderList){
        Order order = new Order(orderList);

        order.printCheck();
    }
}


