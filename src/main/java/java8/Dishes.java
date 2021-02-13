package java8;

public class Dishes {

    private String name;
    private int price;
    private int calories;
    private String category;
    private Boolean isVegeterian;

    public Boolean getVegeterian() {
        return isVegeterian;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Dishes(String name, int price, int calories, String category, Boolean isVegeterian){
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.category = category;
        this.isVegeterian = isVegeterian;
    }
}
