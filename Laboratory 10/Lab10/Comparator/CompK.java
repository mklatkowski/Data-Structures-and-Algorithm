package Comparator;

import Lab9.Krawedz;
import Lab9.Wierzcholek;

public class CompK<T extends Comparable<? super T>> implements ComparatorK<T> {
    public int compare(Krawedz<T> o1, Krawedz<T> o2) {
        if(o1.getValue()>o2.getValue()){
            return 1;
        }
        else if(o1.getValue()<o2.getValue()){
            return -1;
        }
        return 0;
    }
}