package Main;

import Algorytmy.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void shakerSort(ListSorter<Double> sort, ArrayList<Double> list){
        System.out.println("Ciag wylosowany");
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println(" ");
        System.out.println("Ciag posortowany:");
        System.out.println(" ");
        sort.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static ArrayList<Double> generateList3(int size){
        ArrayList<Double> list = new ArrayList<>();
        double k= size+1;
        for(int i=0; i<size; i++){
            list.add(k);
            k--;
        }
        for(int i=0; i<size/20; i++){
            Random r = new Random();
            int r1 = r.nextInt(1, size);
            Random rr = new Random();
            int r2 = rr.nextInt(1, size);

            double temp = list.get(r1);
            list.set(r1, list.get(r2));
            list.set(r2, temp);
        }
        return list;
    }

    public static ArrayList<Double> generateList2(int size){
        ArrayList<Double> list = new ArrayList<>();
        double k= 1.0;
        for(int i=0; i<size; i++){
            list.add(k);
            k++;
        }
        for(int i=0; i<size/20; i++){
            Random r = new Random();
            int r1 = r.nextInt(1, size);
            Random rr = new Random();
            int r2 = rr.nextInt(1, size);

            double temp = list.get(r1);
            list.set(r1, list.get(r2));
            list.set(r2, temp);
        }
        return list;
    }

    public static ArrayList<Double> generateList(int size, int bound){
        if(size<1 || bound<1){
            throw new IllegalArgumentException();
        }
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Random r = new Random();
            double r1 = r.nextInt(1, bound);
            list.add(r1);
        }
        return list;
    }

    public static void sortList(ListSorter<Double> sort, ArrayList<Double> list){
        ArrayList<Double> list11 = copy(list);

        sort.sort(list11);

        System.out.println(sort.getClass() +": ");
        System.out.println("zamiany: " + sort.getZamiany());
        System.out.println("porownania: " + sort.getPorownania());
        System.out.println(" ");
    }


    public static void main(String[] args) {

        ComparatorC<Double> comp1 = new Comp<>();

        ListSorter<Double> insert = new InsertSort<>(comp1);
        SelectSort<Double> select = new SelectSort<>(comp1);
        BubbleSort<Double> bubble = new BubbleSort<>(comp1);
        ShakerSort<Double> shaker = new ShakerSort<>(comp1);

        ArrayList<Double> list = generateList(50, 80);
        ArrayList<Double> list1 = generateList2(50);
        ArrayList<Double> list2 = generateList3(50);

//        System.out.println("Rozmiar listy: 1000");
//        System.out.println("Typ ciągu: posortowany");
//        System.out.println(" ");
//
//        sortList(select, list2);
//        sortList(bubble, list2);
//        sortList(insert, list2);

        shakerSort(shaker, list);



    }

    public static ArrayList<Double> copy(ArrayList<Double> list){
        ArrayList<Double> copy = new ArrayList<>();
        for(Double x: list){
            copy.add(x);
        }
        return copy;
    }
}
