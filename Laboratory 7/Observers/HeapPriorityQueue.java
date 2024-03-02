package Observers;

public class HeapPriorityQueue implements Observer{

    private Klient [] queue;
    private int indeks;

    public HeapPriorityQueue(){
        queue =new Klient[100];
        indeks =0;
    }

    public void enqueue(Klient value){
        queue[indeks] = value;
        indeks++;
        swim(indeks-1);
    }
    public Klient dequeue(){
        if(indeks==0){
            throw new NullPointerException("Pusta tablica");
        }
        Klient ret = queue[0];
        if(indeks>1) {
            queue[0] = queue[indeks-1];
            sink(0);
        }
        queue[indeks-1]=null;
        indeks--;
        return ret;
    }
    public int size(){
        return indeks;
    }


    private void swim(int x){
        int parent;
        while(x!=0 && queue[x].getCzasSprawy()<=queue[parent=(x-1)/2].getCzasSprawy()){
            swap(x, parent);
            x=parent;
        }
    }

    private void sink(int x){
        boolean isDone = false;
        int min;

        while(!isDone && (min=2*x+1)<indeks){
            if(min<indeks-1 && queue[min].getCzasSprawy()>queue[min+1].getCzasSprawy()) {
                min++;
            }
            if(queue[x].getCzasSprawy()>=queue[min].getCzasSprawy()){
                swap(x, min);
                x=min;
            }
            else{
                isDone=true;
            }
        }

    }

    private void swap(int n, int m){
        Klient temp = queue[n];
        queue[n] = queue[m];
        queue[m] = temp;
    }

    public Klient update(){
        if(indeks!=0){
            return dequeue();
        }
        return null;
    }

    public Klient[] getQueue() {
        return queue;
    }

    public void setQueue(Klient[] queue) {
        this.queue = queue;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }
}

