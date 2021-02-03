package collections;

public class Dishes {
    public String name;
    private int price;
    private int calories;
    private String category;
    private Boolean isVegeterian;

    public Dishes(String name, int price, int calories, String category, Boolean isVegeterian){
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.category = category;
        this.isVegeterian = isVegeterian;
    }



}
