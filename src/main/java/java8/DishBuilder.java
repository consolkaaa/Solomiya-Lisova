package java8;

public class DishBuilder {
    private String name;
    private int price;
    private int calories;
    private String category;
    private Boolean isVegeterian;

    public DishBuilder name(String name){
        this.name = name;
        return this;
    }

    public DishBuilder price(int price){
        this.price = price;
        return this;
    }

    public DishBuilder calories(int calories){
        this.calories = calories;
        return this;
    }

    public DishBuilder category(String category){
        this.category = category;
        return this;
    }

    public DishBuilder isVegeterian(Boolean isVegeterian){
        this.isVegeterian = isVegeterian;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getVegeterian() {
        return isVegeterian;
    }

    public Dishes build(){
        return new Dishes(this);
    }
}
