package Main;

import Comparators.*;
import ComplexComparators.CComparator1;
import ComplexComparators.CComparator2;
import Student.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void sort(ArrayList<Student> list, Comparator<Student> comp){
        Collections.sort(list, comp);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println(" ");
    }

    public static void main(String[] args){

        ArrayList<Student> list = new ArrayList<>(){{
            add(new Student(2002, "Adam", "Nowak", 4.75, true));
            add(new Student(2003, "Jan", "Nowak", 4.25, false));
            add(new Student(2001, "Bartosz", "Kowal", 5.00, false));
            add(new Student(2002, "Adam", "Małysz", 5.50,false));
            add(new Student(2002, "Janusz", "Kowal", 2.80, true));
            add(new Student(2001, "Olek", "Mały", 6.00, true));
        }};
        System.out.println("Początkowa lista: ");
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println(" ");
        System.out.println("Sortowanie komparatorem naturalnym: ");
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println(" ");
        Comparator1 comp1 = new Comparator1();
        Comparator2 comp2 = new Comparator2();
        Comparator3 comp3 = new Comparator3();
        Comparator4 comp4 = new Comparator4();
        Comparator5 comp5 = new Comparator5();

        CComparator1 ccomp1 = new CComparator1();
        CComparator2 ccomp2 = new CComparator2();

        System.out.println("Komparator: wg rocznika");
        sort(list, comp1);
        System.out.println("Komparator: wg imienia");
        sort(list, comp2);
        System.out.println("Komparator: wg sredniej");
        sort(list, comp3);
        System.out.println("Komparator: wg nazwiska");
        sort(list, comp4);
        System.out.println("Komparator: wg tego, czy zostało przyznane stypendium");
        sort(list, comp5);

        System.out.println("Komparator: wg imienia i nazwiska");
        sort(list,ccomp1);
        System.out.println("Komparator wg nazwiska i imienia: ");
        sort(list, ccomp2);
    }

    public static ArrayList<Student> copy(ArrayList<Student> list){
        ArrayList<Student> copy = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            copy.add(new Student(list.get(i).getRocznik(), list.get(i).getImie(), list.get(i).getNazwisko(), list.get(i).getSrednia(), list.get(i).isCzyStypendium()) );
        }
        return copy;
    }
}
