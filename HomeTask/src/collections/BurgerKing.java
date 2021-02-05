package collections;

import collections.Menu;
import collections.Visitor;
import OOP.inheritance.abstraction.Cashier;

public class BurgerKing {

    public static void main(String[] args) {
        Visitor visitor = new Visitor("Solomiya", 20);
        Cashier cashier = new Cashier("Vasyl", 29);
        Menu menu = new Menu();

        //isBiggerThan   isSmallerThan
        Menu.sortDishesByPrice(">", 100);
        Menu.sortDishesByPrice("<", 150);


//        int price = Menu.dishesList.get(0).getPrice();
//        System.out.println(price);



        //visitor.seeMenu();


        //Salads Burgers Drinks
        //visitor.seeMenuCategory("Burgers");

    }
}
