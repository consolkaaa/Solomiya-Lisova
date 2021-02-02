package OOP.Relationships.Composition;

import OOP.Polymorphism.Burgers;
import OOP.Polymorphism.Drinks;
import OOP.Polymorphism.Salads;

import java.util.ArrayList;

public class Order {

    public ArrayList<Salads> orderedSalads = new ArrayList<Salads>();
    public ArrayList<Burgers> orderedBurgers = new ArrayList<Burgers>();
    public ArrayList<Drinks> orderedDrinks = new ArrayList<Drinks>();

    public void printCheck(){
        System.out.println("You ordered:");
        System.out.println(orderedBurgers );
        System.out.println(orderedDrinks );
        System.out.println(orderedSalads );
        System.out.println();
    }

}
