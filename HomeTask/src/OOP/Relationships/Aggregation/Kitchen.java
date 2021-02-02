package OOP.Relationships.Aggregation;

import OOP.Relationships.Assosiation.Cook;
import OOP.Relationships.Assosiation.Cooker;

import java.util.ArrayList;
import java.util.Arrays;

public class Kitchen {

    //Kitchen has cook and cookers
    //Aggregation
    Cook cook1;

    Cooker cooker1;
    Cooker cooker2;
    Cooker[] cookersArray;

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
