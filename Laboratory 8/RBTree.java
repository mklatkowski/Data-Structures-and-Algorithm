package Tree;

import java.util.ArrayList;

public class RBTree {

    class Node{
        int value; // element
        Node left;
        Node right;
        Node parent;
        RBColor color;

        Node(int obj) {
            value = obj;
        }

        Node(int obj, Node leftNode, Node rightNode) {
            value = obj;
            left = leftNode;
            right = rightNode;
        }
    }

    private Node _root;
    private Node nill;
    private final Comparator1 _comparator;

    public RBTree(){
        _root = null;
        _comparator = new Comparator1();
        nill = new Node(-1000, _root, _root);
        nill.color = RBColor.RED;
    }

    private void insert(int elem) {
        _root = insertX(_root, elem, _root);
    }

    private Node insertX(Node node, int elem, Node parent) {
        if (node == null) {
            node = new Node(elem);
            node.parent = parent;
        }
        else {
            int cmp = _comparator.compare(elem, node.value);

            if (cmp < 0)
                node.left = insertX(node.left, elem, node);
            else if (cmp > 0)
                node.right = insertX(node.right, elem, node);
            else
                throw new IllegalArgumentException();
        }
        return node;
    }

    public void insertRB(int elem){
        insert(elem);
        Node x = searchRB(elem);
        x.color = RBColor.RED;
        while(x!=_root && x.parent.color == RBColor.RED){
            if(x.parent == x.parent.parent.left){
                Node y = x.parent.parent.right;
                if(y!=null && y.color == RBColor.RED){
                    x.parent.color = RBColor.BLACK;
                    y.color = RBColor.BLACK;
                    x.parent.parent.color = RBColor.RED;
                    x = x.parent.parent;
                }
                else{
                    if(x == x.parent.right){
                        x = x.parent;
                        leftRotate(x);
                    }
                    x.parent.color = RBColor.BLACK;
                    x.parent.parent.color = RBColor.RED;
                    rightRotate(x.parent.parent);
                }
            }
            else{
                Node y = x.parent.parent.left;
                if(y!=null && y.color == RBColor.RED){
                    x.parent.color = RBColor.BLACK;
                    y.color = RBColor.BLACK;
                    x.parent.parent.color = RBColor.RED;
                    x = x.parent.parent;
                }
                else{
                    if(x == x.parent.left){
                        x = x.parent;
                        rightRotate(x);
                    }
                    x.parent.color = RBColor.BLACK;
                    x.parent.parent.color = RBColor.RED;
                    leftRotate(x.parent.parent);
                }
            }
        }
        _root.color = RBColor.BLACK;
        System.out.println("Drzewo po dodaniu elementu z kluczem " +elem);
        System.out.println();
        print();
        System.out.println();
        System.out.println();
    }

    private void leftRotate(Node x){
        Node y = x.right;
        x.right = y.left;
        if(y.left!=null){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null|| x.parent==nill){
            _root = y;
        }
        else if(x==x.parent.left){
            x.parent.left = y;
        }
        else{
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x){
        Node y = x.left;
        x.left = y.right;
        if(y.right!=null){
            y.right.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null || x.parent==nill){
            _root = y;
        }
        else if(x==x.parent.right){
            x.parent.right = y;
        }
        else{
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    private Node searchRB(int value){
        return search(value, _root);
    }
    private Node search(int value, Node node){
        if(value>node.value){
            return search(value, node.right);
        }
        if(value<node.value){
           return  search(value, node.left);
        }
        return node;
    }


    public void print(){
        final String reset = " \u001B[0m ";
        final String white = " \u001B[47m ";
        final String red = " \u001B[41m ";

        if(_root==null){
            System.out.println("   ");
        }
        else {
            ArrayList<Node[]> arr = new ArrayList<>();
            for (int i = 0; i < heightTree(); i++) {
                arr.add(new Node[(int) Math.pow(2, heightTree()) - 1]);
            }
            adding(arr, _root, (int) Math.pow(2, heightTree() - 1), heightTree());
            for (Node[] x : arr) {
                for (int i = 0; i < x.length; i++) {
                    if (x[i] == null) {
                        System.out.print("     ");
                    } else {
                        if(x[i].color == RBColor.RED)
                            System.out.print(red+x[i].value+reset);
                        else
                            System.out.print(white+x[i].value+reset);
                    }
                }
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
            }
        }

    }
    private void adding(ArrayList<Node[]> arr, Node node, int value, int heightLevel){
        int height = height(node)-2;
        if(node.left!=null){
            adding(arr, node.left, value-(int) Math.pow(2,height), heightLevel-1);
        }
        if(node.right!=null){
            adding(arr, node.right, value+(int)Math.pow(2, height), heightLevel-1);
        }
        int level = heightTree()-heightLevel;
        arr.get(level)[value-1] = node;
    }

    public int heightTree(){
        return height(_root);
    }

    public int height(Node node){
        if(node==null){
            return 0;
        }
        return Math.max(height(node.left), height(node.right))+1;
    }
}
