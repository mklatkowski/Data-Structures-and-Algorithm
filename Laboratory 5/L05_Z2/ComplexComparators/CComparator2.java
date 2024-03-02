package ComplexComparators;
import Comparators.*;
import Student.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class CComparator2 implements Comparator<Student>{

    private final ArrayList<Comparator> list = new ArrayList<>();
    public CComparator2(){
        list.add(new Comparator4()); // nazwisko
        list.add(new Comparator2()); //imie
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
