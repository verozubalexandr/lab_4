package com.company;

public class Employee {
    private static int pensionerCount;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Position position;
    private Gender gender;
    private String employmentDate;
    private int age;

    public Employee() {
    }

    public void setAge(int age) {
        if (age < 110 && age >= 18) {
            this.age = age;
        } else {
            System.out.println("STOP AND RERUN!");
        }
    }

    public void setGender(Gender gender) {
        this.gender = gender;
        //for 1 company (1 fill)
        if (((this.age > 65) && (this.gender == Gender.MALE)) || ((this.age > 60) && (this.gender == Gender.FEMALE))) {
            pensionerCount++;
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    //for 1 company
    public static int getPensionerCount() {
        return pensionerCount;
    }

    public void displayFullInfo() {
        System.out.println("First name -> " + this.firstName);
        System.out.println("Last name -> " + this.lastName);
        System.out.println("Patronymic -> " + this.patronymic);
        switch (this.position) {
            case MANAGER:
                System.out.println("Position -> Manager");
                break;
            case GENERAL_MANAGER:
                System.out.println("Position -> General Manager");
                break;
            case SALESMAN:
                System.out.println("Position -> Salesman");
                break;
        }
        switch (this.gender) {
            case MALE:
                System.out.println("Gender -> Male");
                break;
            case FEMALE:
                System.out.println("Gender -> Female");
                break;
        }
        System.out.println("Employment date -> " + employmentDate);
    }
}
