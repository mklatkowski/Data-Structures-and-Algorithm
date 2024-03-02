public class Stack <E>{

    private class Element{
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
    private int size;
    private int temp = 0;

    public Stack(int size) {
        if(size<0){
            throw new IllegalArgumentException("Zły rozmiar");
        }
        this.size = size;
    }
    private Element getElement(int index) {
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

    public boolean push(E e) {
        Element newElem = new Element(e);
        temp++;
        if(temp>size){
            temp = size;
            this.getElement(size-2).setNext(null);
        }
        if (head == null) {
            head = newElem;
            return true;
        }
        newElem.next = head;
        head = newElem;
        return true;
    }

    public E pop() {
        if(head == null){
            throw new IllegalStateException("Stos jest pusty");
        }
        Element actElem = head;

        E retValue = actElem.getValue();
        head = actElem.getNext();
        return retValue;
    }

}