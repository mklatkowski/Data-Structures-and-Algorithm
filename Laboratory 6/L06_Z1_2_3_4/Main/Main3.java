package Main;

import Algorytmy.BubbleSort;
import Algorytmy.BucketSort;
import Comparator.Comp1;
import Student.Student;

import java.util.ArrayList;
import java.util.Random;

public class Main3 {

    public static void sortStudents(ArrayList<Student> students){

        ArrayList<Student> list2 = copy(students);


        BucketSort bucket = new BucketSort();
        bucket.sort(students);



        Comp1 comp = new Comp1();
        BubbleSort<Student> bubble = new BubbleSort<>(comp);
        bubble.sort(list2);

        for(Student x: students){
            System.out.println(x);
        }

        System.out.println(" ");
        System.out.println("Dane bubble:");
        System.out.println("zamiany: " +bubble.getZamiany());
        System.out.println("porownania: " +bubble.getPorownania());
        System.out.println("Dane bucket:");
        System.out.println("zamiany: " +bucket.getZamiany());
        System.out.println("porownania: " +bucket.getPorownania());
    }

    public static ArrayList<Student> generate(int count){
        ArrayList<Student> students = new ArrayList<>();
        final ArrayList<Double> grades = new ArrayList<>(){{
            add(2.0);
            add(3.0);
            add(3.5);
            add(4.0);
            add(4.5);
            add(5.0);
            add(5.5);
        }};
        for(int i=0; i<count; i++){
            Random rand = new Random();
            students.add(new Student(grades.get(rand.nextInt(7)), rand.nextInt(100000, 800000) ));
            System.out.println(students.get(i));
        }
        System.out.println(" ");
        return students;
    }

    public static void main(String[] args){
        ArrayList<Student> students = generate(100);
        sortStudents(students);
    }

    public static ArrayList<Student> copy(ArrayList<Student> list){
        ArrayList<Student> ret = new ArrayList<>();
        for(Student x: list){
            ret.add(new Student(x.grade(), x.indeks()));
        }
        return ret;
    }
}
