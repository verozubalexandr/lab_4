package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
    public static boolean isCorrectName(String name) {
        String regex = "^[a-zA-Z_]{2,25}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches())
            return true;
        return false;
    }

    public static String nameFormat(String name) {
        return (("" + name.charAt(0)).toUpperCase() + name.substring(1).toLowerCase());
    }

    public static boolean isCorrectMark(int mark) {
        if (mark >= 0 && mark < 6)
            return true;
        return false;
    }

    public static boolean isCorrectYearOfBirth(int year) {
        if (year > 1900 && year <= 2022)
            return true;
        return false;
    }

    public static boolean isCorrectGroup(String group) {
        String regex = "^[A-Z]{2,3}-[0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(group);
        if (matcher.matches())
            return true;
        return false;
    }

    public static boolean isCorrectAge(int age) {
        final int MIN_AGE = 18;
        final int MAX_AGE = 100;

        if (age < MAX_AGE && age >= MIN_AGE)
            return true;
        return false;
    }
}
