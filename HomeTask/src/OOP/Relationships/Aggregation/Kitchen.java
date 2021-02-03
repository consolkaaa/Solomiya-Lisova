package OOP.Relationships.Aggregation;

import OOP.Relationships.Assosiation.Cook;
import OOP.Relationships.Assosiation.Cooker;

import java.util.ArrayList;
import java.util.Arrays;

public class Kitchen {

    //Kitchen has cook and cookers
    //Aggregation
    private Cook cook1;
    private Cooker cooker1;
    private Cooker cooker2;
    private Cooker[] cookersArray;

    public Kitchen(){
        cooker1 = new Cooker(1, true);
        cooker2 = new Cooker(2, false);
        cookersArray = new Cooker[]{cooker1, cooker2};

        cook1 = new Cook("Andrew", 20);
    }

    public int checkNumberOfCookersOn(){
        int number = 0;

        for (Cooker cooker: cookersArray) {
            if (cooker.isOn){
                number++;
            }
        }
        return number;
    }
}
