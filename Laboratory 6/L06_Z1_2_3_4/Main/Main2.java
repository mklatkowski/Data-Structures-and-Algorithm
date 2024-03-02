package Main;

import Algorytmy.CountingSort;
import Algorytmy.ShellSort;

import java.util.ArrayList;
import java.util.Random;

public class Main2 {

    public static void shellSort(int [] arr){
        ShellSort sort = new ShellSort();
        System.out.println("Przed posortowaniem");


        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }


        System.out.println(" ");
        sort.sort(arr);
        System.out.println("Po posortowaniu: ");
        System.out.println(" ");


        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        ShellSort sort2 = new ShellSort();
        int[] arr2 = copy(arr);

        sort2.sort2(arr2);

        System.out.println("1) 3*H+1");
        System.out.println("2) 7*H+2");
        System.out.println(" ");

        System.out.println(sort.getClass() +": ");
        System.out.println("zamiany: " + sort.getZamiany());
        System.out.println("porownania: " + sort.getPorownania());
        System.out.println(" ");

        System.out.println(sort2.getClass() +": ");
        System.out.println("zamiany: " + sort2.getZamiany());
        System.out.println("porownania: " + sort2.getPorownania());
        System.out.println(" ");
    }

    public static void sort(int[] arr, int k){
        CountingSort sort = new CountingSort();

        System.out.println("Przed posortowaniem");


        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        sort.countingSort(arr, k);

        System.out.println("");
        System.out.println(" po posortowaniu: ");

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        System.out.println(sort.getClass() +": ");
        System.out.println("zamiany: " + sort.getZamiany());
        System.out.println("porownania: " + sort.getPorownania());
        System.out.println(" ");
    }

    public static int[] generateArray(int k, int size){
        int [] arr = new int[size];
        for(int i=0; i<size; i++){
            Random r= new Random();
            arr[i] = r.nextInt(1, k);
        }
        return arr;
    }

    public static void main(String[] args) {
        int k = 5000;
        int size = 50;

        int [] arr = generateArray(k, size);
        int [] arr2 = copy(arr);
//        sort(arr, k);
        shellSort(arr);
    }

    public static int[] copy(int[] arr){
        int[] copy = new int[arr.length];
        for(int i=0; i<arr.length; i++)
        {
            int temp = arr[i];
            copy[i] = temp;
        }
        return copy;
    }
}
