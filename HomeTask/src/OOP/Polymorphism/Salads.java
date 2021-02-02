package OOP.Polymorphism;

public enum Salads implements IMenu {
    SALAD1(99),
    SALAD2(129),
    SALAD3(150);

    private int price;

    private Salads(int price) {
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    @Override
    public void showCategory() {
        System.out.println("\nSalads:");
    }

    public static void showMenu(){
        int number = 1;
        for (Salads salads : Salads.values()) {
            System.out.println(number++ + "." + salads + " - " + salads.getPrice() + "uah");
        }
        System.out.println();
    }
}
