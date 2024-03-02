package Main;

public class Node {
        Node right;
        Node left;
        Character charNode;
        int value;

        public Node(Character charNode, int value){
            this.charNode = charNode;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "charNode=" + charNode +
                    ", value=" + value +
                    '}';
        }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Character getCharNode() {
        return charNode;
    }

    public void setCharNode(char charNode) {
        this.charNode = charNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
