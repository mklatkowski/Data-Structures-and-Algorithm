public class Bufor<T> {

    private static final int DEFAULT_CAPACITY = 16;
    T array[];
    int beginIndex;
    int endIndex;

    public Bufor(int size) {
        array=(T[])new Object[size+1];
    }
    public Bufor() {
        this(DEFAULT_CAPACITY);
    }

    public boolean isEmpty() {
        return beginIndex==endIndex;
    }

    public boolean isFull() {
        return beginIndex==(endIndex+1)%array.length;
    }

    public T dequeue() throws IndexOutOfBoundsException {
        if(isEmpty())
            System.out.println("Bufor jest pusty");
        else {
            T retValue = array[beginIndex++];
            beginIndex %= array.length;
            return retValue;
        }
        return null;
    }

    public void enqueue(T elem) throws IndexOutOfBoundsException {
        if(isFull())
            System.out.println("Bufor jest pełny, należy zaczekać aż zwolni się miejsce");
        else {
            array[endIndex++] = elem;
            endIndex %= array.length;
        }
    }

}

