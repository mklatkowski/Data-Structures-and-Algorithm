package Algorytmy;

import Comparator.ComparatorC;

import java.util.ArrayList;

public class SelectSort<T> implements ListSorter<T> {
    private int porownania;
    private int zamiany;

    private final ComparatorC<T> _comparator;
    public SelectSort(ComparatorC<T> comparator) {
        porownania = 0;
        zamiany = 0;
        _comparator = comparator;
    }
    public ArrayList<T> sort(ArrayList<T> list) {
        int size = list.size();
        for (int slot = 0; slot < size - 1; slot++) {
            int smallest = slot; // pozycja wartości minimalnej
            for (int check = slot + 1; check < size; ++check) {
                porownania++;
                if (_comparator.compare(list.get(check), list.get(smallest)) < 0)
                    smallest = check;
            }
            if(smallest!=slot){
                swap(list, smallest, slot);
            }

        }
        return list;
    }
    private void swap(ArrayList<T> list, int left, int right) {
        if (left != right) {
            zamiany++;
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }
    public int getPorownania(){
        return porownania;
    }

    public int getZamiany(){
        return zamiany;
    }
}
