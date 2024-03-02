package Comparators;

import Student.Student;

import java.util.Comparator;

public class Comparator1 implements Comparator<Student> {
    public int compare(Student o1, Student o2){
        return o1.compareTo(o2);
    }
}
