package Algorytmy;

import Comparator.ComparatorC;

import java.util.ArrayList;

public class InsertSort<T> implements ListSorter<T> {

    private int porownania;
    private int zamiany;

    private final ComparatorC<T> _comparator;
    public InsertSort(ComparatorC<T> comparator)
    {
        zamiany = 0;
        porownania =0;
        _comparator = comparator;
    }
    public ArrayList<T> sort(ArrayList<T> list) {
        for (int i = 1; i < list.size(); ++i) {
            T value = list.get(i),temp;
            int j;
            for (j = i; j > 0 && _comparator.compare(value, temp=list.get(j - 1))< 0; --j)
            {
                porownania++;
                zamiany++;
                list.set(j,temp);
            }
            zamiany++;
            list.set(j, value);
        }
        return list;
    }

    public int getPorownania(){
        return porownania;
    }

    public int getZamiany(){
        return zamiany;
    }
}