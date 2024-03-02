package Main;

import List.IteratorOW;
import List.OneWayLinkedListWithHead;
import Student.Student;

import java.io.*;

public class Main {

    static OneWayLinkedListWithHead<Double> list = new OneWayLinkedListWithHead<>();
    static OneWayLinkedListWithHead<Student> list1 = new OneWayLinkedListWithHead<>();
    static OneWayLinkedListWithHead<Student> list2 = new OneWayLinkedListWithHead<>();

    public static void generateStudents(){

//        list1.add(new Student(1, "student"));
//        list1.add(new Student(3, "student3"));
//        list1.add(new Student(4, "student4"));
//        list1.add(new Student(7, "student7"));
//
//        list2.add(new Student(2, "student2"));
//        list2.add(new Student(5, "student5"));
//        list2.add(new Student(6, "student6"));
//        list2.add(new Student(8, "student8"));

//        list1.add(new Student(1, "student"));
//        list1.add(new Student(2, "student2"));
//
//        list2.add(new Student(4, "student4"));
//        list2.add(new Student(5, "student5"));
//        list2.add(new Student(6, "student6"));
//        list2.add(new Student(8, "student8"));


//
        list2.add(new Student(4, "student4"));
        list2.add(new Student(5, "student5"));
        list2.add(new Student(6, "student6"));
        list2.add(new Student(8, "student8"));

        System.out.println("Studenci z listy nr 1");
        for(Student x: list1){
            System.out.println(x);
        }

        System.out.println(" ");

        System.out.println("Studenci z listy nr 2");
        for(Student x: list2){
            System.out.println(x);
        }




    }

    public static void generate(){
//
//        list.add(6.0);
//        list.add(3.6);
//        list.add(5.0);
//        list.add(4.7);
//        list.add(3.6);
//        list.add(5.9);
//        list.add(4.0);
//        list.add(3.2);
//
//
//        list.add(5.0);
//        list.add(4.0);
//        list.add(3.6);
//        list.add(5.0);
//        list.add(4.0);
//        list.add(3.6);
//        list.add(5.0);
//        list.add(4.0);
//        list.add(3.6);
//        list.add(5.0);
//        list.add(4.0);
//        list.add(3.6);

        list.add(6.0);
        list.add(5.0);
        list.add(4.7);
        list.add(5.9);

    }

    // ZADANIE 2

    public static OneWayLinkedListWithHead<Student> sort(){
        OneWayLinkedListWithHead<Student> sorted = new OneWayLinkedListWithHead<>();

        if(list1.isEmpty()){
            sorted = list2;
            return sorted;
        }
        else if(list2.isEmpty()){
            sorted = list1;
            return sorted;
        }

        IteratorOW<Student> iterator1 = new IteratorOW<>(list1);
        IteratorOW<Student> iterator2 = new IteratorOW<>(list2);



        Student temp1 = iterator1.next();
        Student temp2 = iterator2.next();


        while(iterator1.hasNext() || iterator2.hasNext()){

            if(sorted.contains(temp1)){
                temp1=iterator1.next();
            }
            else if(sorted.contains(temp2)){
                temp2=iterator2.next();
            }

            if(temp1.getIndeks()<temp2.getIndeks()){
                sorted.add(temp1);
                if(!iterator1.hasNext()){
                    sorted.add(temp2);
                    while(iterator2.hasNext()){
                        sorted.add(iterator2.next());
                    }
                }
            }
            else{
                sorted.add(temp2);
                if(!iterator2.hasNext()){
                    sorted.add(temp1);
                    while(iterator1.hasNext()){
                        sorted.add(iterator1.next());
                    }
                }
            }
        }
        return sorted;
    }

    // ZADANIE 1

    public static void serialize(){
        try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("lab2_dataSet3.ser"))){
            oos.writeObject(list);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Lista została zserializowana");
    }

    public static OneWayLinkedListWithHead<Double> deserialize(){
        OneWayLinkedListWithHead<Double> readList = new OneWayLinkedListWithHead<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lab2_dataSet3.ser"))){
            readList = (OneWayLinkedListWithHead<Double>) ois.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Lista po deserializacji: ");
        for(Double x: readList){
            System.out.println(x);
        }
        return readList;
    }


    public static <T> void showList(OneWayLinkedListWithHead<T> list){
        IteratorOW<T> iterator= new IteratorOW<>(list);
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(" ");
    }

    public static <E> void remove(E key){

        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(key)){
                list.remove(i);
            }
        }
        System.out.println("lista po usunięciu elementu z kluczem: " +key);
        for(Double x: list){
            System.out.println(x);
        }

    }

    public static void main(String[] args) {
        System.out.println("ZADANIE 1");
        System.out.println("*********");
        System.out.println(" ");

        generate();
        System.out.println("Wyświetlenie początkowej listy");
        showList(list);
        remove(3.6);
//        serialize();
        deserialize();

        System.out.println(" ");
        System.out.println("ZADANIE 2");
        System.out.println("*********");
        System.out.println(" ");

        generateStudents();
        System.out.println(" ");
        System.out.println("Połączone listy w kolejności wg indeksów:");
        showList(sort());
    }
}
