package com.company;

import java.time.LocalDate;

public class Employee {
    private static int pensionerCount;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Position position;
    private Gender gender;
    private LocalDate employmentDate;
    private int age;

    public Employee() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        final int MIN_AGE = 18;
        final int MAX_AGE = 100;

        if (age < MAX_AGE && age >= MIN_AGE)
            this.age = age;
        else
            System.out.println("STOP AND RERUN!");
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
        //for 1 company (1 fill)
        if (((this.age > 65) && (this.gender == Gender.MALE)) ||
                ((this.age > 60) && (this.gender == Gender.FEMALE)))
            pensionerCount++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = Utilities.nameFormat(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Utilities.nameFormat(lastName);
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = Utilities.nameFormat(patronymic);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    @Override
    public String toString() {
        String string = "Position -> ";

        switch (this.getPosition()) {
            case MANAGER:
                string += "Manager";
                break;
            case GENERAL_MANAGER:
                string += "General Manager";
                break;
            case SALESMAN:
                string += "Salesman";
                break;
        }

        return "\nFirst name -> " + this.getFirstName() +
                "\nLast name -> " + this.getLastName() +
                "\nPatronymic -> " + this.getPatronymic() + "\n" + string +
                "\nGender -> " + ("" + this.getGender()).toLowerCase() +
                "\nEmployment date -> " + this.getEmploymentDate();
    }
}
