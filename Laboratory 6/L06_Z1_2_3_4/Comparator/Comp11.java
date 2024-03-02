package Comparator;

import Student.Student;

import java.util.Comparator;

public class Comp11 implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        if (o1.grade() == o2.grade()) {
            return 0;
        } else if (o1.grade() < o2.grade()) {
            return -1;
        } else {
            return 1;
        }
    }
}
