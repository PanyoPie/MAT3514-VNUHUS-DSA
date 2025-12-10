package vn.io.tunaa.dsa.week2.sorting.example;

import java.util.Arrays;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("Tunaa", 10);
        Student student2 = new Student("Minhbuns", 9.25);
        Student student3 = new Student("Thoa", 9.5);

        Student[] students = {student1, student2, student3};

        System.out.println("Trước khi sắp xếp:");
        printStudents(students);

        Arrays.sort(students);

        System.out.println();
        System.out.println("Sau khi sắp xếp:");
        printStudents(students);
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
