package Comparators;

import Student.Student;

import java.util.Comparator;

public class Comparator5 implements Comparator<Student> {
    public int compare(Student o1, Student o2){
        if(o1.isCzyStypendium()==o2.isCzyStypendium()){
            return 0;
        }
        else if(!o1.isCzyStypendium() && o2.isCzyStypendium()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
