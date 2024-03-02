package Algorytmy;

import Comparator.Comp1;
import Student.Student;

import java.util.ArrayList;

public class BucketSort{

    private int porownania;
    private int zamiany;

    private ArrayList<Student> l1;
    private ArrayList<Student> l2;
    private ArrayList<Student> l3;

    public BucketSort(){
        l1 = new ArrayList<>();
        l2 = new ArrayList<>();
        l3 = new ArrayList<>();

        porownania =0;
        zamiany = 0;
    }


    public void sort(ArrayList<Student> students){
        divide(students);
        insert();
        merge(students);

    }

    private void divide(ArrayList<Student> students){
        for(Student x: students){
            porownania++;
            if(x.grade()==2.0 || x.grade()==3){
                l1.add(x);
            }
            else if(x.grade()==3.5 || x.grade()==4.0){
                l2.add(x);
            }
            else{
                l3.add(x);
            }
        }
    }
    private void insert(){

        Comp1 comp = new Comp1();
        InsertSort<Student> insert1 = new InsertSort(comp);
        InsertSort<Student> insert2 = new InsertSort(comp);
        InsertSort<Student> insert3 = new InsertSort(comp);

        insert1.sort(l1);
        insert2.sort(l2);
        insert3.sort(l3);

        porownania = insert1.getPorownania()+insert2.getPorownania()+insert3.getPorownania();
        zamiany = insert1.getZamiany()+insert2.getZamiany()+insert3.getZamiany();
    }

    private void merge(ArrayList<Student> students){
        students.clear();
        students.addAll(l1);
        students.addAll(l2);
        students.addAll(l3);
    }

    public int getPorownania() {
        return porownania;
    }

    public int getZamiany() {
        return zamiany;
    }

}
