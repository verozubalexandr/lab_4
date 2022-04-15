package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String group;
    private static float averagePhysicsMark;
    private static int studentsCount;
    private String lastName;
    private int yearOfBirth;
    private int physicsMark;
    private int mathMark;
    private int itMark;

    public Student() {
    }

    //set last name
    public void setLastName(String lastName) {
        String regex = "^[\\da-zA-Z_]{2,25}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lastName);
        if (matcher.matches()) {
            this.lastName = lastName;
        } else {
            System.out.println("STOP AND RERUN!");
        }
    }

    //set year of birth
    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth > 1900 && yearOfBirth <= 2022) {
            this.yearOfBirth = yearOfBirth;
        } else {
            System.out.println("STOP AND RERUN!");
        }
    }

    //set group
    public void setGroup(String group) {
        String regex = "^[A-Z]{2,3}[-][0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(group);
        if (matcher.matches()) {
            this.group = group;
        } else {
            System.out.println("STOP AND RERUN!");
        }
    }

    //set mark
    public void setPhysicsMark(int physicsMark) {
        if (physicsMark >= 0 && physicsMark < 6) {
            this.physicsMark = physicsMark;
            averagePhysicsMark += ((float) physicsMark);
        } else {
            System.out.println("STOP AND RERUN!");
        }
    }

    //set mark
    public void setMathMark(int mathMark) {
        if (mathMark >= 0 && mathMark < 6) {
            this.mathMark = mathMark;
        } else {
            System.out.println("STOP AND RERUN!");
        }
    }

    //set mark
    public void setItMark(int itMark) {
        if (itMark >= 0 && itMark < 6) {
            this.itMark = itMark;
            this.studentsCount++;
        } else {
            System.out.println("STOP AND RERUN!");
        }
    }

    //objects count(now)
    public static int getStudentsCount() {
        return studentsCount;
    }

    //count average
    public static float getAveragePhysicsMark() {
        return (averagePhysicsMark / studentsCount);
    }

    //display all info about student
    public void displayFullInfo() {
        System.out.println(lastName + " info:");
        System.out.println("Year of birth -> " + yearOfBirth);
        System.out.println("Group -> " + group);
        System.out.println("Math mark -> " + mathMark);
        System.out.println("Physics mark -> " + physicsMark);
        System.out.println("IT mark -> " + itMark);
    }
}
