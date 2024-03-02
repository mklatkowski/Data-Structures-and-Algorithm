public class Main {

    public static void main(String [] args){
        Bufor <Double> bufor = new Bufor<>(5);
        bufor.enqueue(5.0);
        bufor.enqueue(5.0);
        bufor.enqueue(5.0);
        bufor.enqueue(5.0);
        bufor.enqueue(5.0);
        bufor.enqueue(5.0);
        bufor.enqueue(5.0);
        bufor.enqueue(5.0);
        bufor.enqueue(5.0);
        bufor.dequeue();
        bufor.dequeue();
        bufor.dequeue();
        bufor.dequeue();
        bufor.dequeue();
        bufor.dequeue();
        bufor.dequeue();
        bufor.dequeue();



    }
}
