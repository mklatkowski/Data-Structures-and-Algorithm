package Main;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TableIterator<T> implements Iterator<T>, Cloneable{

    private T array[];
    private int pos = 0;

    public TableIterator(T anArray[]) {
        array = anArray;
    }
    public boolean hasNext() {
        return pos < array.length;
    }
    public T next() throws NoSuchElementException {
        if (hasNext())
            return array[pos++];
        else
            throw new NoSuchElementException();
    }
    public TableIterator<T> clone(){
        try{
            return (TableIterator<T>) super.clone();
        }
        catch(CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
