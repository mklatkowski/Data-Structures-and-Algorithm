
public class Stack {

    private class Element{
        private String value;
        private Element next;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        Element(String data) {
            this.value = data;
        }
    }

    Element head = null;

    public Stack() {
    }

    public boolean push(String e) {
        Element newElem = new Element(e);
        if (head == null) {
            head = newElem;
            return true;
        }
        newElem.next = head;
        head = newElem;

//        check(e);
        return true;
    }

    public String pop() {
        if(head == null){
            throw new IllegalStateException("Podana formuła jest źle sformułowana");
        }
        Element actElem = head;

        String retValue = actElem.getValue();
        head = actElem.getNext();
        return retValue;
    }
}