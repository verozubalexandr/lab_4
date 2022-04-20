package com.company;

public class Employees {
    private final Employee[] employees;
    private int currentEmployeeNumber;

    public Employees(final int employeeNumber) {
        this.employees = new Employee[employeeNumber];
        currentEmployeeNumber = -1;
    }

    public void addEmployee(final Employee employee) {
        if (++currentEmployeeNumber < employees.length)
            employees[currentEmployeeNumber] = employee;
    }

    public Employee getEmployee(byte index) {
        return employees[index];
    }

    public static int countPensioners(final Employees employees, final byte EMPLOYEE_NUM) {
        int pensionersCounter = 0;

        for (byte i = 0; i < 2; i++)
            if (((employees.getEmployee(i).getAge() > 65) && (employees.getEmployee(i).getGender() == Gender.MALE)) ||
                    ((employees.getEmployee(i).getAge() > 60) && (employees.getEmployee(i).getGender() == Gender.FEMALE)))
                pensionersCounter++;
        return pensionersCounter;
    }
}
