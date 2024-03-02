package Comparator;

import Lab9.Wierzcholek;

public class Comp<T extends Comparable<? super T>> implements ComparatorC<T> {
    public int compare(Wierzcholek<T> o1, Wierzcholek<T> o2) {
        return o1.getWierzcholek().compareTo(o2.getWierzcholek());
    }
}
