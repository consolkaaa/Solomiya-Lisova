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

    public int getCalories() {
        return calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

     Dishes(DishBuilder dishBuilder){
        this.name = dishBuilder.getName();
        this.calories = dishBuilder.getCalories();
        this.price = dishBuilder.getPrice();
        this.category = dishBuilder.getCategory();
        this.isVegeterian = dishBuilder.getVegeterian();
    }
}
