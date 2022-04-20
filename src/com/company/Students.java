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

    public Student getStudent(byte index) {
        return students[index];
    }

    public static float averagePhysicsMark(Students students, final byte STUDENTS_NUM) {
      float average = 0;
      for (byte i = 0; i < STUDENTS_NUM; i++)
          average += students.getStudent(i).getPhysicsMark();
      return (average / STUDENTS_NUM);
    }
}
