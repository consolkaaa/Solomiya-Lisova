package java8;

public class DishDecorator {
     Dishes dish;
     String newName;

    public DishDecorator(Dishes dish){
        this.dish = dish;

    }

    public Dishes addExtraCheese(){
        if (dish.getCategory() == "Burgers") {
            dish.setName(dish.getName() + " (double cheese) ");
            dish.setPrice(dish.getPrice() + 14);
        }else{
            System.out.println("\nYou can only add double cheese for burgers category");
        }
        return dish;
    }

    public Dishes addExtraAvocado(){
        if (dish.getCategory() == "Salads") {
            dish.setName(dish.getName() + " (with avocado) ");
            dish.setPrice(dish.getPrice() + 19);
        }else{
            System.out.println("\nYou can only add avocado for salads category");
        }

        return dish;
    }

    public Dishes addExtraIce(){
        if (dish.getCategory() == "Drinks") {
            dish.setName(dish.getName() + " (extra icy) ");
        }else{
            System.out.println("\nYou can only add ice for drinks category");
        }

        return dish;
    }
}


