
import java.util.ListIterator;

public class Main {

    static TwoWayCycledListWithSentinel<Double> list1;
    static TwoWayCycledListWithSentinel<Double> list2;

    public static <E> void show(TwoWayCycledListWithSentinel<E> list){

        ListIterator<E> iter = list.listIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("od tyłu: ");
        while(iter.hasPrevious()){
            System.out.println(iter.previous());
        }

    }

    public static void generate(){
        list1 = new TwoWayCycledListWithSentinel<>(){{
            add(6.0);
            add(7.0);
            add(9.0);
        }};
        list2 = new TwoWayCycledListWithSentinel<>(){{
            add(2.0);
            add(3.0);
            add(4.0);
        }};
    }

    public static void main(String[] args) {
        generate();
        System.out.println("Lista 1: ");
        for(int i=0; i<list1.size(); i++){
            System.out.println(list1.get(i));
        }
        System.out.println(" ");
        System.out.println("Lista 2: ");
        for(int i=0; i<list2.size(); i++){
            System.out.println(list2.get(i));
        }
        System.out.println(" ");
        System.out.println("Laczenie list za obiekt: 14.0");
        insertListObject(14.0);

        for(Double x: list1){
            System.out.println(x);
        }

        System.out.println("Iterator: ");
        show(list1);
    }
    public static <E>void insertListObject(E element){
        if(list1.contains(element)){
            insertListIndeks(list1.indexOf(element));
        }
        else{
            throw new IllegalArgumentException("Nie ma takiego elementu");
        }
    }

    public static void insertListIndeks(int indeks){

        if(indeks > list1.size()-1){
            throw new IllegalArgumentException("Nie ma takiego indeksu");
        }
        else{
            TwoWayCycledListWithSentinel.Element indeksNext = list1.getElement(indeks).getNext();

            list2.getSentinel().getPrev().setNext(indeksNext);

            list1.getElement(indeks).setNext(list2.getSentinel().getNext());

            list2.getSentinel().getNext().setPrev(list1.getElement(indeks));

            indeksNext.setPrev(list2.getSentinel().getPrev());
            System.out.println(" ");
        }
    }

    public static void insertList(){
        insertListIndeks(list1.size()-1);
    }
}
