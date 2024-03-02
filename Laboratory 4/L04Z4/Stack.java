public class Stack <T> {

    private int size;
    private T[] array;
    private int temp = 0;

    public Stack(int size){
        if(size<0){
            throw new IllegalArgumentException("Zły rozmiar");
        }
        array = (T[]) new Object[size];
        this.size = size;
    }

    public void push(T elem){
        if(temp>=3*array.length/4)
        {
           T[] arrayTemp = (T[]) new Object[array.length*2];
           System.arraycopy(array, 0, arrayTemp, 0, array.length);
           array = arrayTemp;
        }
        array[temp] = elem;
        temp++;
    }

    public T pop(){
        if(temp<=array.length/4+1){
            T[] arrayTemp;
            if(array.length%2==0){
                arrayTemp = (T[]) new Object[array.length/2];
                System.arraycopy(array, 0, arrayTemp, 0, array.length/2);
            }
            else{
                arrayTemp = (T[]) new Object[array.length/2+1];
                System.arraycopy(array, 0, arrayTemp, 0, array.length/2+1);
            }
            array = arrayTemp;
        }
        if(temp==0){
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        T tempElement = array[temp-1];
        temp--;
        return tempElement;
    }
    public int size(){
        return array.length;
    }

}