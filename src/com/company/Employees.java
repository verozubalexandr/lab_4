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

    public final Employee getEmployee(byte index) {
        return employees[index];
    }

    public int countPensioners() {
        int pensionersCounter = 0;

        for (byte i = 0; i < this.employees.length; i++)
            if (((getEmployee(i).getAge() > 65) && (getEmployee(i).getGender() == Gender.MALE)) ||
                    ((getEmployee(i).getAge() > 60) && (getEmployee(i).getGender() == Gender.FEMALE)))
                pensionersCounter++;
        return pensionersCounter;
    }
}
