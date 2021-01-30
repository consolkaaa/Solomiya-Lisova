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

        WeekDay next() {
            if (this == SUNDAY) {
                return WeekDay.MONDAY;
            } else {
                int next = this.ordinal() + 1;
                return WeekDay.values()[this.ordinal() + 1];
            }
        }

        public static void main(String[] args) {

            while (true) {
                System.out.println("Input the day of the week ");
                Scanner scan = new Scanner(System.in);
                String day = scan.nextLine().toUpperCase(Locale.ROOT);

                try {
                    WeekDay weekDay = WeekDay.valueOf(day);
                    System.out.println("The next day is " + weekDay.next());
                } catch (Exception e) {
                    System.out.println("Invalid data");
                }

            }
        }

    }


