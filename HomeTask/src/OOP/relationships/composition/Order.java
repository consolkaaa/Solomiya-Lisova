package OOP.relationships.composition;

import OOP.polymorphism.Burgers;
import OOP.polymorphism.Drinks;
import OOP.polymorphism.Salads;

import java.util.ArrayList;

public class Order {

    public ArrayList<Salads> orderedSalads = new ArrayList<>();
    public ArrayList<Burgers> orderedBurgers = new ArrayList<>();
    public ArrayList<Drinks> orderedDrinks = new ArrayList<>();

    public void printCheck(){
        System.out.println("You ordered:");
        System.out.println(orderedBurgers );
        System.out.println(orderedDrinks );
        System.out.println(orderedSalads );
        System.out.println();
    }

}
