package Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BST {

    class Node {
        int value; // element
        Node left;
        Node right;
        int heightLeft;
        int heightRight;
        int przeciazenie;
        int maxPrzeciazenieLewe;
        int maxPrzeciazeniePrawe;
        int liczbaLisciLewo;
        int liczbaLisciPrawo;



        Node(int obj) {
            value = obj;
        }

        Node(int obj, Node leftNode, Node rightNode) {
            value = obj;
            left = leftNode;
            right = rightNode;
        }
    }

    private final Comparator<Integer> _comparator;
    private Node _root;

    public BST(Comparator<Integer> comp) {
        _comparator = comp;
        _root = null;
    }

    //wstawianie rekurencyjnie
    public void insert(int elem) {
        _root = insert(_root, elem);
        update();
        System.out.println("Drzewo po dodaniu elementu: " +elem);
        print();
    }

    private Node insert(Node node, int elem) {
        if (node == null)
            node = new Node(elem);
        else {
            int cmp = _comparator.compare(elem, node.value);
            if (cmp < 0)
                node.left = insert(node.left, elem);
            else if (cmp > 0)
                node.right = insert(node.right, elem);
            else
                throw new IllegalArgumentException("Nie można dodawać elementu o takim samym kluczu. Błędny klucz: " +elem);
        }
        return node;
    }

    public void delete(int elem){
        _root=delete(elem,_root);
        update();
        System.out.println("Drzewo po usunięciu elementu: " +elem);
        print();
    }

    protected Node delete(int elem, Node node) {
        if(node==null) throw new NoSuchElementException("Nie ma elementu o kluczu: "+elem);
        else {
            int cmp=_comparator.compare(elem,node.value);
            if(cmp<0)
                node.left=delete(elem,node.left);
            else if(cmp>0)
                node.right=delete(elem,node.right);
            else if(node.left!=null &&node.right!=null)
                node.right=detachMin(node,node.right);
            else node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }
    private Node detachMin(Node del, Node node) {
        if(node.left!=null) node.left=detachMin(del, node.left);
        else {
            del.value=node.value;
            node=node.right;
        }
        return node;
    }

//    public int cos(){
//        return countRec(_root);
//    }


//    public int countRec(Node n){
//        if(n.left!=null){
//            cl = countRec(n.left);
//        }
//        else{
//            return 1;
//        }
//        if(n.right!=null){
//            cr = countRec(n.right);
//        }
//        else{
//            return 1;
//        }
//        return cl+cr;
//    }
//
//    public int getCl() {
//        return cl;
//    }
//
//    public int getCr() {
//        return cr;
//    }
//
//    public boolean insertRec(Node node, int value){
//        if(node.value==value){
//            throw new IllegalArgumentException();
//        }
//        if(node.value < value){
//            if(node.right==null){
//                Node n = new Node(value);
//                node.right = n;
//                return true;
//            }
//            else{
//                insertRec(node.right, value);
//            }
//        }
//        if(node.value > value){
//            if(node.left==null){
//                Node n = new Node(value);
//                node.left = n;
//                return true;
//            }
//            else{
//                insertRec(node.left, value);
//            }
//        }
//        return true;
//    }
//    public int treeHeight(){
//        return height(_root);
//    }
//    public int height(Node node){
//        if(node == null){
//            return 0;
//        }
//        else {
//            return 1+Math.max(height(node.left), height(node.right));
//        }
//    }

    // ZADANIE 1

    //minimum iteracyjnie

    public int minTreeIter() {
        int value;
        Node node = _root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    //minimum rekurencyjnie
    public int minTree() {
        return min(_root).value;
    }

    private Node min(Node node) {
        if (node == null) {
            throw new NullPointerException();
        } else if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    // max iteracyjnie
    public int maxTreeIter() {
        int value;
        Node node = _root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    //max rekurencyjnie
    public int maxTree() {
        return max(_root).value;
    }

    private Node max(Node node) {
        if (node == null) {
            throw new NullPointerException();
        } else if (node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }


//    public int rec(Node node){
//        if(node!=null){
//            if(node.left!=null){
//                countRec++;
//                rec(node.left);
//            }
//            if(node.right!=null){
//                countRec++;
//                rec(node.right);
//            }
//        }
//        return countRec;
//        else{
//            int l = rec(node.left);
//            int r = rec(node.right);
//            node.countRec = l+r+1;
//            return node.countRec;
//        }
//    }

//    public int recT(){
//        return rec(_root);
//    }

//    public Node next(Node node,int value){
//        if(node.value==value){
//            if(node.right!=null){
//                min(node.right);
//            }
//            else{
//                return null;
//            }
//        }
//        else if(node.value<value){
//            Node retNode == null?node:retNode;
//        }
//    }

    //inOrder rekurencyjnie
    public void inOrderRec() {
        inOrder(_root);
    }

    private void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.value +" ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    //preorder rekurencyjnie
    public void preOrderRec() {
        preOrder(_root);
    }

    private void preOrder(Node node) {
        System.out.print(node.value +" ");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }


    //postOrder rekurencyjnie
    public void postOrderRec() {
        postOrder(_root);
    }

    private void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.value +" ");
    }

    //poprzenik rekurencyjnie
    public int predecessor(int value) {
        return previous(_root, value) == null ? null : previous(_root, value).value;
    }

    private Node previous(Node node, int value) {
        if (node == null) {
            throw new IllegalArgumentException();
        }
        if (node.value == value) {
            if (node.left != null) {
                return max(node.left);
            } else {
                return null;
            }
        } else if (value > node.value) {
            Node ret = previous(node.right, value);
            return ret == null ? node : ret;
        } else {
            return previous(node.left, value);
        }
    }


    //następnik rekurencyjnie
    public int succesor(int value) {
        return next(_root, value) == null ? null : next(_root, value).value;
    }

    private Node next(Node node, int value) {
        if (node == null) {
            throw new IllegalArgumentException();
        }
        if (node.value == value) {
            if (node.right != null) {
                return min(node.right);
            } else {
                return null;
            }
        } else if (value < node.value) {
            Node ret = next(node.left, value);
            return ret == null ? node : ret;
        } else {
            return next(node.right, value);
        }
    }

    public int nodes(Node node){
        if(node == null){
            return 0;
        }
        return 1+nodes(node.right)+nodes(node.left);
    }


//    public int sumTree() {
//        return sum(_root);
//    }
//
//    public int sum(Node node) {
//        if (node == null) {
//            return 0;
//        } else {
//            int leftSum = sum(node.left);
//            int rightSum = sum(node.right);
//            return node.value + leftSum + rightSum;
//        }
//    }

//    public int nodesTree() {
//        return numNodes(_root);
//    }
//
//    public int nodes(Node node) {
//        if (node == null) {
//            return 0;
//        }
//        nodes(node.left);
//        nodes(node.right);
//        if (node.value < _root.value) {
//            cl++;
//        }
//        if (node.value > _root.value) {
//            cr++;
//        }
//        return cl + cr;
//    }

    public void update(){
        updateData(_root);
    }

    public void updateData(Node node){
        if (node.left != null) {
            updateData(node.left);
        }
        if (node.right != null) {
            updateData(node.right);
        }
        data(node);
    }

    public void show(){
        showInformation(_root);
    }

    public void showInformation(Node node){
        information(node.value);
        if (node.left != null) {
            showInformation(node.left);
        }
        if (node.right != null) {
            showInformation(node.right);
        }
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

    public void information(int value){
        Node node = searchNode(value);
//        data(node);
        System.out.println("Informacje dla węzeła: " +value);
        System.out.println(" ");
        System.out.println("height left: " +node.heightLeft);
        System.out.println("height right: " +node.heightRight);
        System.out.println("przeciazenie: " +node.przeciazenie);
        System.out.println("liczba liści lewo: " +node.liczbaLisciLewo);
        System.out.println("liczba liści prawo: " +node.liczbaLisciPrawo);
        System.out.println("max przeciazenie lewo: " +node.maxPrzeciazenieLewe);
        System.out.println("max przeciazenie prawe: " +node.maxPrzeciazeniePrawe);
        System.out.println(" ");
    }

    private void data(Node node){
        node.heightLeft = height(node.left);
        node.heightRight = height(node.right);
        node.przeciazenie = node.heightRight-node.heightLeft;
        node.liczbaLisciLewo = nodes(node.left);
        node.liczbaLisciPrawo = nodes(node.right);
        node.maxPrzeciazenieLewe = maxPrzeciazenie(node.left);
        node.maxPrzeciazeniePrawe = maxPrzeciazenie(node.right);
    }


    public void print(){
        if(_root==null){
            System.out.println(" ");
        }
        else {
            ArrayList<Integer[]> arr = new ArrayList<>();
            for (int i = 0; i < heightTree(); i++) {
                arr.add(new Integer[(int) Math.pow(2, heightTree()) - 1]);
            }
            adding(arr, _root, (int) Math.pow(2, heightTree() - 1), heightTree());
            for (Integer[] x : arr) {
                for (int i = 0; i < x.length; i++) {
                    if (x[i] == null) {
                        System.out.print("   ");
                    } else {
                        System.out.print(" "+x[i]+" ");
                    }
                }
                System.out.println(" ");
                System.out.println(" ");
            }
        }
//        showDetails();
//        System.out.println(" ");
//        show();
    }
    public void showData(){
        show();
        showDetails();
    }
    private void adding(ArrayList<Integer[]> arr, Node node, int value, int heightLevel){
        int height = height(node)-2;
        if(node.left!=null){
            adding(arr, node.left, value-(int) Math.pow(2,height), heightLevel-1);
        }
        if(node.right!=null){
            adding(arr, node.right, value+(int)Math.pow(2, height), heightLevel-1);
        }
        int level = heightTree()-heightLevel;
        arr.get(level)[value-1] = node.value;
    }
    public int maxPrzeciazenie(Node node){
        if(node==null){
            return 0;
        }
        int left = maxPrzeciazenie(node.left);
        int right = maxPrzeciazenie(node.right);
        return max3(left, right, przeciazenie(node));
    }

    public int przeciazenie(Node node){
        return height(node.right)-height(node.left);
    }
    public int max3(int a, int b, int c){
        int max = Math.abs(a);
        if(Math.abs(b)>max){
            max = b;
        }
        if(Math.abs(c)>max){
            max = c;
        }
        return max;
    }

    public void showDetails(){
        System.out.println(" ");
        System.out.println("Minimum iteracyjnie: " +this.minTreeIter());
        System.out.println();
        System.out.println("Minimum rekurencyjnie: " +this.minTree());
        System.out.println();
        System.out.println("Minimum iteracyjnie: " +this.maxTree());
        System.out.println();
        System.out.println("Minimum iteracyjnie: " +this.maxTreeIter());
        System.out.println();
        System.out.println("Kolejność inOrder:");
        inOrderRec();
        System.out.println();
        System.out.println("Kolejność preOrder:");
        preOrderRec();
        System.out.println();
        System.out.println("Kolejność postOrder:");
        postOrderRec();
        System.out.println();
    }

    private Node searchNode(int value){
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
}


