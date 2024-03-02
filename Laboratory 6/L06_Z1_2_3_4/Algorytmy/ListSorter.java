package Algorytmy;

import java.util.ArrayList;

public interface ListSorter<T> {
    ArrayList<T> sort(ArrayList<T> list);
    int getPorownania();
    int getZamiany();
}
