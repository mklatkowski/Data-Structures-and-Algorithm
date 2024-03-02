package Algorytmy;

public class Comp<T extends Comparable<? super T>> implements ComparatorC<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}
