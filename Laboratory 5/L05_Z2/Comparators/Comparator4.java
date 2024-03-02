package Comparators;

import Student.Student;

import java.util.Comparator;

public class Comparator4 implements Comparator<Student> {
    public int compare(Student o1, Student o2){
        return o1.getNazwisko().compareTo(o2.getNazwisko());
    }
}
