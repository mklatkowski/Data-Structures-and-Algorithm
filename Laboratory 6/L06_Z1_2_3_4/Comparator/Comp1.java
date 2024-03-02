package Comparator;

import Student.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class Comp1 implements ComparatorC<Student> {

    private final ArrayList<Comparator> list = new ArrayList<>();
    public Comp1(){
        list.add(new Comp11()); // ocena
        list.add(new Comp22()); //indeks
    }

    @SuppressWarnings("unchecked")
    public int compare(Student left, Student right) throws ClassCastException {
        int result = 0;
        for (Object obj:list ){
            Comparator<Student> comp=(Comparator<Student>)obj;
            result=comp.compare(left, right);
            if(result!=0) break;
        }
        return result;
    }
}
