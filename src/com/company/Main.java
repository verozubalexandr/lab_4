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
     * <p>
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
        fillStudentInfo(student1);
        fillStudentInfo(student2);
        fillStudentInfo(student3);

        //result
        System.out.println("Average physics mark pf all students -> " + Student.getAveragePhysicsMark());
        student1.displayFullInfo();
        student2.displayFullInfo();
        student3.displayFullInfo();
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
        fillEmployeeInfo(employee1);
        Employee employee2 = new Employee();
        fillEmployeeInfo(employee2);

        //result
        employee1.displayFullInfo();
        employee2.displayFullInfo();
        System.out.println(Employee.getPensionerCount());
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
        if (((int) (Math.random()) * 10) % 2 == 0) {
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
