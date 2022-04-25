package com.company;

public class Students {
    private final Student[] students;
    private int currentStudentNumber;

    public Students(final int studentsNumber) {
        this.students = new Student[studentsNumber];
        currentStudentNumber = -1;
    }

    public void addStudent(final Student student) {
        if (++currentStudentNumber < students.length)
            students[currentStudentNumber] = student;
    }

    public final Student getStudent(byte index) {
        return students[index];
    }

    public float averagePhysicsMark() {
        float average = 0;
        for (byte i = 0; i < this.students.length; i++)
            average += getStudent(i).getPhysicsMark();
        return (average / this.students.length);
    }
}
