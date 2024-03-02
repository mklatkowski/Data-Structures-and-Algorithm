package Algorytmy;

import Comparator.ComparatorC;

import java.util.ArrayList;

public class HeapSort <T extends Comparable<? super T>> implements ListSorter<T>{

    private int zamiany;
    private int porownania;

    private final ComparatorC<T> _comparator;

    public HeapSort(ComparatorC<T> comparator) {
        zamiany = 0;
        porownania = 0;
        _comparator = comparator;
    }

    private void swap(ArrayList<T> list, int left, int right) {
        zamiany++;
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
    public void sink(ArrayList<T> heap,int idx, int n){
        int idxOfBigger=2*idx+1;
        porownania++;
        if(idxOfBigger<n){
            porownania++;
            if(idxOfBigger+1<n &&
                    _comparator.compare(heap.get(idxOfBigger), heap.get(idxOfBigger+1))<0)
                idxOfBigger++;
            porownania++;
            if(_comparator.compare(heap.get(idx), heap.get(idxOfBigger))<0){
                swap(heap,idx,idxOfBigger);
                sink(heap,idxOfBigger,n);
            }
        }
    }
    void heapAdjustment(ArrayList<T> heap,int n)
    {
        for(int i=(n-1)/2;i>=0;i--)
            sink(heap, i, n);
    }

    public ArrayList<T> sort(ArrayList<T> list){
        heapsort(list, list.size());
        return list;}

    private void heapsort(ArrayList<T> heap, int n) {
        heapAdjustment(heap, n);
        for(int i=n-1;i>0;i--){
            swap(heap,i,0);
            sink(heap,0,i);
        }
    }
    public int getPorownania(){
        return porownania;
    }
    public int getZamiany(){
        return zamiany;
    }

}
