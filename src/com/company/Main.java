package com.company;

import java.time.LocalDate;
import java.util.Scanner;
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
        final byte STUDENTS_NUM = 3;
        final Student student1 = new Student();
        final Student student2 = new Student();
        final Student student3 = new Student();

        final Students students = new Students(STUDENTS_NUM);

        students.addStudent(student1);
        students.addStudent(student2);
        students.addStudent(student3);

        for(byte i = 0; i < STUDENTS_NUM; i++)
            fillStudentInfo(students.getStudent(i));
        System.out.println();

        for(byte i = 0; i < STUDENTS_NUM; i++)
            System.out.println(students.getStudent(i));

        System.out.println("Average physics mark of all students -> " + Students.averagePhysicsMark(students, STUDENTS_NUM));
    }

    /**
     * Определить количество сотрудников пенсионного возраста
     * (мужчинам больше 65-ти лет, женщинам - 60).
     * <p>
     * Дано:
     * Фамилия
     * Имя
     * Отчество
     * Должность
     * Пол
     * Дата приёма на работу
     */
    private static void task2() {
        //create
        final byte EMPLOYEE_NUM = 2;
        final Employee employee1 = new Employee();
        final Employee employee2 = new Employee();

        final Employees employees = new Employees(EMPLOYEE_NUM);

        employees.addEmployee(employee1);
        employees.addEmployee(employee2);

        for(byte i = 0; i < EMPLOYEE_NUM; i++)
            fillEmployeeInfo(employees.getEmployee(i));
        System.out.println();

        for (byte i = 0; i < EMPLOYEE_NUM; i++)
            System.out.println(employees.getEmployee(i));

        System.out.println("Pensioners -> " + Employees.countPensioners(employees, EMPLOYEE_NUM));
    }

    //fill student info
    public static void fillStudentInfo(Student student) {
        int integer;
        String string;
        System.out.println("Enter information about student #" + (Student.getStudentsCount() + 1));

        do
            string = enterString("group").toUpperCase().replaceAll("\\s+", "");
        while (!Utilities.isCorrectGroup(string));
        student.setGroup(string);

        do
            string = enterString("last name").replaceAll("\\s+", "");
        while (!Utilities.isCorrectName(string));
        student.setLastName(string);

        do
            integer = enterInteger("year of birth");
        while (!Utilities.isCorrectYearOfBirth(integer));
        student.setYearOfBirth(integer);

        do
            integer = enterInteger("math mark");
        while (!Utilities.isCorrectMark(integer));
        student.setMathMark(integer);

        do
            integer = enterInteger("it mark");
        while (!Utilities.isCorrectMark(integer));
        student.setItMark(integer);

        do
            integer = enterInteger("phys mark");
        while (!Utilities.isCorrectMark(integer));
        student.setPhysicsMark(integer);
    }

    //fill employee info
    private static void fillEmployeeInfo(Employee employee) {
        String string;
        int integer;

        do
            integer = enterInteger("age");
        while (!Utilities.isCorrectAge(integer));
        employee.setAge(integer);

        employee.setGender(randomGender());

        do
            string = enterString("first name").replaceAll("\\s+", "");
        while (!Utilities.isCorrectName(string));
        employee.setFirstName(string);

        do
            string = enterString("last name").replaceAll("\\s+", "");
        while (!Utilities.isCorrectName(string));
        employee.setLastName(string);

        do
            string = enterString("patronymic").replaceAll("\\s+", "");
        while (!Utilities.isCorrectName(string));
        employee.setPatronymic(string);

        employee.setPosition(randomPosition());

        employee.setEmploymentDate(LocalDate.ofEpochDay(ThreadLocalRandom.current().nextInt(40 * 365, 50 * 365)));
    }

    //random position
    private static Position randomPosition() {
        byte randomValue = ((byte) ((Math.random()) * 4));
        switch (randomValue) {
            case 1:
                return Position.SALESMAN;
            case 3:
                return Position.GENERAL_MANAGER;
            default:
                return Position.MANAGER;
        }
    }

    //random gender
    private static Gender randomGender() {
        if (1 + ((byte) (Math.random() * 2)) == 1)
            return Gender.MALE;
        return Gender.FEMALE;
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
