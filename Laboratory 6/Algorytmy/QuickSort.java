package Algorytmy;

import Comparator.ComparatorC;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort <T extends Comparable<? super T>> implements ListSorter<T> {

    private int zamiany;
    private int porownania;

    private final ComparatorC<T> _comparator;

    public QuickSort(ComparatorC<T> comparator) {
        zamiany = 0;
        porownania = 0;
        _comparator = comparator;
    }

    public ArrayList<T> sort(ArrayList<T> list) {
        quicksort(list, 0, list.size());
        return list;
    }

    private void quicksort(ArrayList<T> list, int startIndex, int endIndex) {
        porownania++;
        if (endIndex - startIndex > 1) {
            int partition = partition(list, startIndex, endIndex);
            quicksort(list, startIndex, partition);
            quicksort(list, partition + 1, endIndex);
        }
    }

    private int partition(ArrayList<T> list, int nFrom, int nTo) {
        Random random = new Random();
        int rnd = nFrom + random.nextInt(nTo - nFrom);
        swap(list, nFrom, rnd);
        T value = list.get(nFrom);
        int idxBigger = nFrom + 1, idxLower = nTo - 1;
        do {
            while (idxBigger <= idxLower && _comparator.compare(list.get(idxBigger), value) <= 0)
                idxBigger++;
            while (_comparator.compare(list.get(idxLower), value) > 0)
                idxLower--;
            porownania++;
            if (idxBigger < idxLower)
                swap(list, idxBigger, idxLower);
        } while (idxBigger < idxLower);
        porownania++;
        swap(list, idxLower, nFrom);
        return idxLower;
    }

    private void swap(ArrayList<T> list, int left, int right) {
        if (left != right) {
            zamiany++;
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }

    public int getPorownania() {
        return porownania;
    }

    public int getZamiany() {
        return zamiany;
    }
}
