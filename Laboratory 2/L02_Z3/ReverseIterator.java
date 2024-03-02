
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReverseIterator<T> implements Iterator<T> {

    private TwoWayCycledListWithSentinel<T> list;
    private TwoWayCycledListWithSentinel.Element element;

    public ReverseIterator(TwoWayCycledListWithSentinel<T> list){
        this.list = list;
        element = list.getSentinel();
    }

    public boolean hasNext() {
        return !element.getPrev().equals(list.getSentinel());
    }

    public T next() throws NoSuchElementException{
        if(hasNext()){
            element = element.getPrev();
            return (T) element.getValue();
        }
        else{
            throw new NoSuchElementException();
        }
    }
}
