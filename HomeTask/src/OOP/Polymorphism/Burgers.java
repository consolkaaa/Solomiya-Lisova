package OOP.Polymorphism;

public enum Burgers implements IMenu {
    BURGER1(99),
    BURGER2(129),
    BURGER3(150);

    private int price;

    Burgers(int price) {
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    //That's polymorphism
    @Override
    public void showCategory() {
        System.out.println("\n:Burgers");
    }

    public static void showMenu(){
        int number = 1;
        for (Burgers burgers : Burgers.values()) {
            System.out.println(number++ + "." + burgers + " - " + burgers.getPrice() + "uah");
        }
        System.out.println();
    }
}
