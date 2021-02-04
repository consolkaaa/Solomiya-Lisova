package collections;

public class Dishes {

    private String name;
    private int price;
    private int calories;
    private String category;
    private Boolean isVegeterian;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Dishes(String name, int price, int calories, String category, Boolean isVegeterian){
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.category = category;
        this.isVegeterian = isVegeterian;
    }



}
