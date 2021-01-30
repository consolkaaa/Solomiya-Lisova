package hometask1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    static String regex = "[A-Z][a-z]+\\s[A-Z][a-z]+";

    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher("Ivan Ivanov");
//        boolean valid = matcher.find();

        boolean valid = Pattern.matches(regex, "Petro Petrov");
        if(valid) {
            System.out.println("Name is valid");
        } else {
            System.out.println("Name is not valid");
        }
    }
}
