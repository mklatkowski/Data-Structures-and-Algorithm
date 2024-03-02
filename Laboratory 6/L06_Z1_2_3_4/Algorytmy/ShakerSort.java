package Algorytmy;

import Comparator.ComparatorC;

import java.util.ArrayList;

public class ShakerSort<T> implements ListSorter<T>{

    private int porownania;
    private int zamiany;

    private final ComparatorC<T> _comparator;
    public ShakerSort(ComparatorC<T> comparator)
    { _comparator = comparator;
        porownania = 0;
        zamiany = 0;
    }

    public ArrayList<T> sort(ArrayList<T> list) {
        int beginIndex = 1;
        int endIndex = list.size()-1;

        while(beginIndex<=endIndex){
            int newBeginIndex = endIndex;
            int newEndIndex = beginIndex;
            for(int i = beginIndex-1; i < endIndex; i++){
                porownania++;
                if(_comparator.compare(list.get(i), list.get(i+1))>0){
                    swap(list, i,i+1);
                    newEndIndex = i;
                }
            }
            endIndex = newEndIndex+1;
            for(int i=endIndex-1; i>beginIndex; i--){
                porownania++;
                if(_comparator.compare(list.get(i), list.get(i+1))>0){
                    swap(list, i, i+1);
                    newBeginIndex = i;
                }
            }
            beginIndex = newBeginIndex-1;
        }
        return list;
    }
    private void swap(ArrayList<T> list, int left, int right) {
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
        zamiany++;
    }
    public int getPorownania(){
        return porownania;
    }

    public int getZamiany(){
        return zamiany;
    }
}
