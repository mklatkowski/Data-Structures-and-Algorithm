package Algorytmy;

import Comparator.ComparatorC;

import java.util.ArrayList;
import java.util.Iterator;

public class MergeSort<T extends Comparable<? super T>> implements ListSorter<T> {

    private int zamiany;
    private int porownania;

    private final ComparatorC<T> _comparator;

    public MergeSort(ComparatorC<T> comparator)
    {
        zamiany = 0;
        porownania =0;
        _comparator = comparator;
    }

    public ArrayList<T> sort(ArrayList<T> list) {
        return mergesort(list, 0, list.size() - 1);
    }

    private ArrayList<T> mergesort(ArrayList<T> list, int startIndex, int endIndex) {
        porownania++;
        if (startIndex == endIndex) {
            ArrayList<T> result = new ArrayList<>();
            result.add(list.get(startIndex));
            return result;
        }
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge(mergesort(list, startIndex, splitIndex),
                mergesort(list, splitIndex + 1, endIndex));
    }

    private ArrayList<T> merge(ArrayList<T> left, ArrayList<T> right) {
        zamiany++;
        ArrayList<T> result = new ArrayList<>();
        Iterator<T> l = left.iterator();
        Iterator<T> r = right.iterator();

        T elemL = null;
        T elemR = null;

        boolean contL;
        boolean contR;
        if (contL = l.hasNext())
            elemL = l.next();
        if (contR = r.hasNext())
            elemR = r.next();
        while (contL && contR) {
            porownania++;
            if (_comparator.compare(elemL, elemR) <= 0) {
                zamiany++;
                result.add(elemL);
                if (contL = l.hasNext()) elemL = l.next();
                else result.add(elemR);
            } else {
                result.add(elemR);
                if (contR = r.hasNext()) elemR = r.next();
                else result.add(elemL);
            }
        }
        while (l.hasNext())
            result.add(l.next());
        while (r.hasNext())
            result.add(r.next());
        return result;
    }
    public int getPorownania(){
        return porownania;
    }
    public int getZamiany(){
        return zamiany;
    }
}

