package com.company;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        //task1();
        //task2();
    }

    /**
     * Вычислить средний балл оценок студентов по физике
     * и напечатать фамилии, год рождения и оценки по
     * информатике всех студентов.
     * 
     * Дано:
     * Фамилия;
     * Группа;
     * Год рождения;
     * Оценка по физике;
     * Оценка по математике;
     * Оценка по информатике.
     */
    private static void task1() {
        //create
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student[] students = new Student[]{student1, student2, student3};

        //fill info
        for (int i = 0; i < students.length; i++) {
            fillStudentInfo(students[i]);
        }

        //result
        for (int i = 0; i < students.length; i++) {
            students[i].displayFullInfo();
        }
        System.out.println("Average physics mark of all students -> " + averagePhysicsMark(students));
    }

    /**
     * Определить количество сотрудников пенсионного возраста
     * (мужчинам больше 65-ти лет, женщинам - 60).
     *
     * Дано:
     * Фамилия
     * Имя
     * Отчество
     * Должность
     * Пол
     * Дата приёма на работу
     * */
    private static void task2() {
        //create
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee[] employees = new Employee[] { employee1, employee2 };
        for (int i = 0; i < employees.length; i++) {
            fillEmployeeInfo(employees[i]);
        }

        //result
        for (int i = 0; i < employees.length; i++) {
            employees[i].displayFullInfo();
        }
        System.out.println("Pensioners -> " + countPensioners(employees));
    }

    //fill student info
    private static void fillStudentInfo(Student student) {
        System.out.println("Enter information about student #" + (Student.getStudentsCount() + 1));
        student.setGroup(enterString("group").toUpperCase().replaceAll("\\s+", ""));
        student.setLastName(enterString("last name").toUpperCase().replaceAll("\\s+", ""));
        student.setYearOfBirth(enterInteger("year of birth"));
        student.setMathMark(enterInteger("math mark"));
        student.setPhysicsMark(enterInteger("physics mark"));
        student.setItMark(enterInteger("IT mark"));
    }

    //average physics mark
    private static float averagePhysicsMark (Student[] students) {
        float average = 0;
        for (int i = 0; i < students.length; i++) {
            average += students[i].getPhysicsMark();
        }
        return (average / (students.length));
    }

    //fill employee info
    private static void fillEmployeeInfo(Employee employee) {
        employee.setAge(enterInteger("age"));
        employee.setGender(randomGender());
        employee.setFirstName(enterString("first name").toUpperCase().replaceAll("\\s+", ""));
        employee.setLastName(enterString("last name").toUpperCase().replaceAll("\\s+", ""));
        employee.setPatronymic(enterString("patronymic").toUpperCase().replaceAll("\\s+", ""));
        employee.setPosition(randomPosition());
        employee.setEmploymentDate(String.valueOf(LocalDate.ofEpochDay(ThreadLocalRandom.current().nextInt(40 * 365, 50 * 365))));
    }

    //count pensioners
    private static int countPensioners(Employee[] employees) {
        int pensionersCounter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (((employees[i].getAge() > 65) && (employees[i].getGender() == Gender.MALE)) || ((employees[i].getAge() > 60) && (employees[i].getGender() == Gender.FEMALE))) {
                pensionersCounter++;
            }
        }
        return pensionersCounter;
    }

    //random position
    private static Position randomPosition() {
        byte randomValue = ((byte) ((Math.random()) * 4));
        switch (randomValue) {
            case 1:
                return Position.SALESMAN;
            case 2:
                return Position.MANAGER;
            case 3:
                return Position.GENERAL_MANAGER;
            default:
                return Position.MANAGER;
        }
    }

    //random gender
    private static Gender randomGender() {
        if (1 + ((int) (Math.random() * 2)) == 1) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }

    //enter string with hint
    private static String enterString(String purpose) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a(n) " + purpose + " -> ");
        return scan.nextLine();
    }

    //enter integer with hint
    private static int enterInteger(String purpose) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a(n) " + purpose + " -> ");
        return scan.nextInt();
    }
}
