package hometask1;

import java.util.Locale;
import java.util.Scanner;

    enum WeekDay {
        MONDAY {
            @Override
            WeekDay next() {
                return WeekDay.values()[this.ordinal() + 1];
            }
        },
        TUESDAY {
            @Override
            WeekDay next() {
                return WeekDay.values()[this.ordinal() + 1];
            }
        },
        WEDNESDAY {
            @Override
            WeekDay next() {
                return WeekDay.values()[this.ordinal() + 1];
            }
        },
        THURSDAY {
            @Override
            WeekDay next() {
                return WeekDay.values()[this.ordinal() + 1];
            }
        },
        FRIDAY {
            @Override
            WeekDay next() {
                return WeekDay.values()[this.ordinal() + 1];
            }
        },
        SATURDAY {
            @Override
            WeekDay next() {
                return WeekDay.values()[this.ordinal() + 1];
            }
        },
        SUNDAY {
            @Override
            WeekDay next() {
                return WeekDay.values()[0]; //as there is no next day at current week
            }
        };

        abstract WeekDay next();

        public static void main(String[] args) {

            while(true) {
                System.out.println("Input the day of the week ");
                Scanner scan = new Scanner(System.in);
                String day = scan.nextLine().toUpperCase(Locale.ROOT); //in case the input is LowerCase

                try {
                    WeekDay weekDay = WeekDay.valueOf(day);
                    System.out.println("The next day is " + weekDay.next() + "\n");
                } catch (Exception e) {
                    System.out.println("Invalid data");

                }
            }
        }
    }





