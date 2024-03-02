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

        public Stack() {
        }

        public boolean push(E e) {
            Element newElem = new Element(e);
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