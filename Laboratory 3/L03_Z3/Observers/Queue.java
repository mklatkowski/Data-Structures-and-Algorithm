package Observers;

import java.io.Serializable;



    public class Queue implements Observer {
        private class Element implements Serializable {
            private Klient value;
            private Element next;

            public Klient getValue() {
                return value;
            }

            public void setValue(Klient value) {
                this.value = value;
            }

            public Element getNext() {
                return next;
            }

            public void setNext(Element next) {
                this.next = next;
            }

            Element(Klient data) {
                this.value = data;
            }
        }

        Element head = null;

        public Queue() {
        }

        public int size() {
            int pos = 0;
            Element actElem = head;
            while (actElem != null) {
                pos++;
                actElem = actElem.getNext();
            }
            return pos;
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

        public boolean enqueue(Klient e) {
            Element newElem = new Element(e);
            if (head == null) {
                head = newElem;
                return true;
            }
            Element tail = head;
            while (tail.getNext() != null)
                tail = tail.getNext();
            tail.setNext(newElem);
            return true;
        }

        public Klient get(int index) {
            Element actElem = getElement(index);
            return actElem.getValue();
        }


        public Klient dequeue() {
            if (head == null) throw new IndexOutOfBoundsException();
            Klient retValue = head.getValue();
            head = head.getNext();
            return retValue;
        }
        public Klient update(){
            if(head !=null){
               return this.dequeue();
            }
            return null;
        }
    }

