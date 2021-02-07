package hometask1;

import java.util.Locale;
import java.util.Scanner;

//this is a version WITHOUT abstract class
//it's shorter

    enum WeekDays {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;

        WeekDays next() {
            if (this == SUNDAY) {
                return WeekDays.values()[0];
            } else {
                return WeekDays.values()[this.ordinal() + 1];
            }
        }

        public static void main(String[] args) {

            while (true) {
                System.out.println("Input the day of the week ");
                Scanner scan = new Scanner(System.in);
                String day = scan.nextLine().toUpperCase(Locale.ROOT);

                try {
                    WeekDays weekDay = WeekDays.valueOf(day);
                    System.out.println("The next day is " + weekDay.next());
                } catch (Exception e) {
                    System.out.println("Invalid data");
                }

            }
        }

    }


