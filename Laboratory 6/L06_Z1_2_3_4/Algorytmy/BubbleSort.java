package Algorytmy;

import Comparator.ComparatorC;

import java.util.ArrayList;

public class BubbleSort<T> implements ListSorter<T> {
    private int porownania;
    private int zamiany;

    private final ComparatorC<T> _comparator;
    public BubbleSort(ComparatorC<T> comparator)
    { _comparator = comparator;
        porownania = 0;
        zamiany = 0;
    }

    public ArrayList<T> sort(ArrayList<T> list) {
        int size = list.size();
        for (int pass = 1; pass < size; ++pass) {
            for (int left = 0; left < (size - pass); ++left) {
                int right = left + 1;
                porownania++;
                if (_comparator.compare(list.get(left), list.get(right)) > 0){
                    swap(list, left, right);
                    zamiany++;
                }
            }
        }
        return list;
    }
    private void swap(ArrayList<T> list, int left, int right) {
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
    public int getPorownania(){
        return porownania;
    }

    public int getZamiany(){
        return zamiany;
    }
}
