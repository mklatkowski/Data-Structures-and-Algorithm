package Algorytmy;

import java.util.ArrayList;
import java.util.Collections;

public class ShellSort{

    private ArrayList<Integer> list;
    private int zamiany;
    private int porownania;

    public ShellSort(){
        list = new ArrayList<>();
    }

    public void skoki(int size){
        int a=1;
        while(a<size/3){
            list.add(a);
            a=3*a+1;
        }
        Collections.reverse(list);
    }

    public void skoki2(int size){
        int a=1;
        while(a<size/3){
            list.add(a);
            a=7*a+2;
        }
        Collections.reverse(list);
    }

    public void show(){
        for(Integer x: list){
            System.out.println(x);
        }
    }

    public void sort(int[] arr){
        skoki(arr.length);
        for(Integer x: list){
            porownania++;
            for(int i=x; i<arr.length; i++){
                porownania++;
                zamiany++;
                int value = arr[i];
                int in = i;
                while(in>x-1 && arr[in-x]>=value){
                    porownania++;
                    zamiany++;
                    arr[in] = arr[in-x];
                    in = in-x;
                }
                porownania++;
                arr[in] = value;
            }
        }
    }

    public void sort2(int[] arr){
        skoki2(arr.length);
        for(Integer x: list){
            porownania++;
            for(int i=x; i<arr.length; i++){
                porownania++;
                zamiany++;
                int value = arr[i];
                int in = i;
                while(in>x-1 && arr[in-x]>=value){
                    porownania++;
                    arr[in] = arr[in-x];
                    in = in-x;
                }
                porownania++;
                arr[in] = value;
            }
        }
    }

    public int getZamiany() {
        return zamiany;
    }

    public int getPorownania() {
        return porownania;
    }

}
