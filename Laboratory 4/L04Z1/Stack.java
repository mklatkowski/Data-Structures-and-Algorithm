public class Stack <T> {

    private int size;
    private T[] array;

    public Stack(int size){
        if(size<0){
            throw new IllegalArgumentException("Zły rozmiar");
        }
        array = (T[]) new Object[size];
        this.size = size;
    }

    public void push(T elem){
        if(size<=0){
            throw new IllegalArgumentException("Stos jest już zapełniony");
        }
        array[size-1] = elem;
        size--;
    }

    public T pop(){
        if(size>=array.length){
            throw new IllegalArgumentException();
        }
        T temp = array[size];
        size++;
        return temp;
    }

}
