package Main;

import Student.Student;

import java.util.Iterator;
import java.util.function.Predicate;

public class FiltredIterator<T> implements Iterator<T> {

    private Iterator<T> iterator;
    private Predicate<T> predicate;

    private T nextElement = null;
    private boolean hasNext = true;

    public FiltredIterator(Iterator<T> iterator, Predicate<T> predicate){
        super();
        this.iterator = iterator;
        this.predicate = predicate;
        findNext();

    }

    public boolean hasNext() {
        return hasNext;
    }

    private void findNext(){
        while(iterator.hasNext()){
            nextElement = iterator.next();
            if(predicate.test(nextElement)){
                return;
            }
        }
        hasNext = false;
        nextElement=null;
    }

    public T next(){
        T nextValue = nextElement;
        findNext();
        return nextValue;
    }
    public void View(){
        while(hasNext()){
            System.out.println(next());
        }
    }


}
