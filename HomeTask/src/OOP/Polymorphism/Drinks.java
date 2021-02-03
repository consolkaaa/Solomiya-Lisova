package OOP.Polymorphism;

public enum Drinks implements IMenu {
    DRINK1(35),
    DRINK2(45),
    DRINK3(55);

    private int price;

    Drinks(int price) {
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    @Override
    public void showCategory() {
        System.out.println("\nDrinks:");
    }

    public static void showMenu(){

        int number = 1;
        for (Drinks drinks : Drinks.values()) {
            System.out.println(number++ + "." + drinks + " - " + drinks.getPrice() + "uah");
        }
        System.out.println();
    }
}
