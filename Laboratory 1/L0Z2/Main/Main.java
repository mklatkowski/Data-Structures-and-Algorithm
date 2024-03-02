package Main;

import Student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

public class Main {

    public static void Generate(Student[] table){
        table[0] = new Student(1, "A", "F", new ArrayList<>(Arrays.asList(2.0, 2.0, 2.0)));
        table[1] = new Student(2, "B", "G", new ArrayList<>(Arrays.asList(3.0, 2.5, 5.5)));
        table[2] = new Student(3, "C", "H", new ArrayList<>(Arrays.asList(4.0, 4.5, 4.5)));
        table[3] = new Student(4, "D", "I", new ArrayList<>(Arrays.asList(5.0, 4.5, 3.0)));
        table[4] = new Student(5, "E", "J", new ArrayList<>(Arrays.asList(4.0, 3.5, 4.0)));

//        table[0] = new Student(1, "A", "F", new ArrayList<>(Arrays.asList(2.0, 5.0, 2.0)));
//        table[1] = new Student(2, "B", "G", new ArrayList<>(Arrays.asList(null, 2.5, 5.5)));
//        table[2] = new Student(3, "C", "H", new ArrayList<>(Arrays.asList(2.0, 4.5, 5.5)));
//        table[3] = new Student(4, "D", "I", new ArrayList<>(Arrays.asList(2.0, 2.0, 3.0)));
//        table[4] = new Student(5, "E", "J", new ArrayList<>(Arrays.asList(4.0, 3.5, 4.0)));

//        table[0] = new Student(1, "A", "F", new ArrayList<>(Arrays.asList(null, null, null)));
//        table[1] = new Student(2, "B", "G", new ArrayList<>(Arrays.asList(null, null, 5.5)));
//        table[2] = new Student(3, "C", "H", new ArrayList<>(Arrays.asList(2.0, 4.5, 5.5)));
//        table[3] = new Student(4, "D", "I", new ArrayList<>(Arrays.asList(5.5, 2.0, 3.0)));
//        table[4] = new Student(5, "E", "J", new ArrayList<>(Arrays.asList(4.0, 3.5, 4.0)));
    }
    public static void ViewIndex(TableIterator<Student> iterator, int indeks, double ocena) {
        class PredicateStudent<T> implements Predicate<T> {
            public boolean test(T student) {
                return ((Student)student).getNrIndeksu() == indeks;
            }
        }

        Predicate<Student> predicate = new PredicateStudent<>();
        Iterator<Student> iterator1 = new FiltredIterator<>(iterator, predicate);

        int n=0;

        while(iterator1.hasNext()){
            (iterator1.next().getOcena()).add(ocena);
            n++;
        }
        if(n==0){
            System.out.println("Student o indeksie: "+indeks +" nie istnieje");
        }
        else{
            System.out.println("Student z indeksem: " +indeks + " Otrzymał ocenę: " +ocena);
        }
        System.out.println(" ");
    }
    public static void View(Iterator<Student> iterator){

        System.out.println("Początkowe elementy tablicy: ");
        System.out.println(" ");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(" ");
    }

    public static void ViewAverage(TableIterator<Student> iterator){
        class PredicateStudent<T> implements Predicate<T> {
            public boolean test(T student) {
                return ((Student)student).Srednia() >=3.0;
            }
        }
        double sum = 0;
        int n=0;

        Predicate<Student> predicate = new PredicateStudent<>();
        Iterator<Student> iterator1 = new FiltredIterator<>(iterator, predicate);

        while(iterator1.hasNext()){
            Student st = iterator1.next();
            sum+=st.Suma();
            n+=st.getOcena().size();
        }
        System.out.println("Srednia ocen studentów ze średnią minimum 3.0: ");
        System.out.println(sum/n);
    }
    public static void ViewFailed(TableIterator<Student> iterator){
        class PredicateStudent<T> implements Predicate<T> {
            public boolean test(T student) {
                return ((Student)student).Srednia() < 3.0;
            }
        }

        Predicate<Student> predicate = new PredicateStudent<>();
        Iterator<Student> iterator1 = new FiltredIterator<>(iterator, predicate);

        System.out.println("Studenci, których średnia jest poniżej 3.0 lub nie mają oceny: ");
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

    public static void main(String[] args){
        Student[] table = new Student[5];

        Generate(table);

        TableIterator<Student> iterator_test1 = new TableIterator<>(table);
        TableIterator<Student> iterator_test2 = new TableIterator<>(table);
        TableIterator<Student> iterator_test3 = new TableIterator<>(table);
        TableIterator<Student> iterator_test4 = new TableIterator<>(table);

        View(iterator_test4);
        ViewAverage(iterator_test1);
        ViewIndex(iterator_test2, 3, 4.0);
        ViewFailed(iterator_test3);
    }
}
