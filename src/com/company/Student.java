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

    public void setLastName(String lastName) {
        this.lastName = Utilities.nameFormat(lastName);
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPhysicsMark(int physicsMark) {
        studentsCount++;
        this.physicsMark = physicsMark;
    }

    public void setMathMark(int mathMark) {
        this.mathMark = mathMark;
    }

    public void setItMark(int itMark) {
        this.itMark = itMark;
    }

    public static int getStudentsCount() {
        return studentsCount;
    }

    public int getPhysicsMark() {
        return physicsMark;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getGroup() {
        return group;
    }

    public int getMathMark() {
        return mathMark;
    }

    public int getItMark() {
        return itMark;
    }

    @Override
    public String toString() {
        return this.getLastName() + " info:" +
                "\nYear of birth -> " + this.getYearOfBirth() +
                "\nGroup -> " + this.getGroup() +
                "\nMath mark -> " + this.getMathMark() +
                "\nPhysics mark -> " + this.getPhysicsMark() +
                "\nIT mark -> " + this.getItMark()+"\n";
    }
}
