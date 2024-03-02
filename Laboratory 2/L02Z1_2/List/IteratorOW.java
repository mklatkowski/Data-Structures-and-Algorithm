package List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorOW<T> implements Iterator<T> {

    private OneWayLinkedListWithHead<T> list;
    private int pos = 0;

    public IteratorOW(OneWayLinkedListWithHead<T> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return pos < list.size();
    }

    public T next() throws NoSuchElementException {
        if (hasNext()) {
            return list.get(pos++);
        } else
            throw new NoSuchElementException();
    }
}
