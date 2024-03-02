package OWL;

import java.io.Serializable;


public class OWL<E> implements Serializable {
    class Element implements Serializable{
        private E value;
        private Element next;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        Element(E data) {
            this.value = data;
        }
    }


    Element head = null;
    Element tail = null;

    int size;
    int counter;

    public OWL(int size, int counter) {
        this.size = size;
        this.counter = counter;
        elimination();
    }


    public int size() {
        if(head==null){
            return 0;
        }
        int pos = 1;
        Element actElem = head;
        while (actElem != tail) {
            pos++;
            actElem = actElem.getNext();
        }
        return pos;
    }

    public Element getElement(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        Element actElem = head;
        while (index > 0 && actElem != null) {
            index--;
            actElem = actElem.getNext();
        }
        if (actElem == null)
            throw new IndexOutOfBoundsException();
        return actElem;
    }

    public boolean add(E e) {
        Element newElem = new Element(e);
        if (head == null) {
            head = newElem;
            tail = newElem;
            return true;
        }
        tail.setNext(newElem);
        tail = newElem;
        tail.setNext(head);
        return true;
    }

    public E get(int index) {
        Element actElem = getElement(index);
        return actElem.getValue();
    }

    public boolean remove(Object value) {
        if (head == null)
            return false;
        if (head.getValue().equals(value)) {
            head = head.getNext();
            tail.setNext(head);
            return true;
        }
        Element actElem = head;

        while (actElem.getNext() != head && !actElem.getNext().getValue().equals(value)){
            actElem = actElem.getNext();
            if(actElem.getNext() == tail && tail.getValue().equals(value)){
                actElem.setNext(actElem.getNext().getNext());
                tail = actElem;
                return true;
            }
        }
        if (actElem.getNext() == head) {
            return false;
        }
        actElem.setNext(actElem.getNext().getNext());
        return true;
    }

    public void elimination(){
        Integer temp = 1;
        for(int i=0; i<size; i++){
            this.add((E) temp);
            temp++;
        }

        Element current = tail;

        while(this.size()!=2){
            for(int i=0; i<counter-1; i++){
                current = current.getNext();
            }

            this.remove(current.getNext().getValue());
        }
    }
}