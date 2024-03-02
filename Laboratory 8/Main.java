package Tree;

import Tree.BST;
import Tree.Comparator1;
import Tree.RBTree;

public class Main {

    public static void main(String[] args){

        Comparator1 comp = new Comparator1();
        BST bst = new BST(comp);

//        bst.insert(8);
//        bst.insert(4);
//        bst.insert(12);
//        bst.insert(2);
//        bst.insert(6);
//        bst.insert(13);
//        bst.insert(15);
//        bst.insert(14);
//        bst.insert(10);
//        bst.insert(1);
//        bst.insert(3);
//        bst.insert(5);
//        bst.insert(7);
//        bst.insert(9);
//        bst.insert(11);
//
//        bst.showData();
//
//        bst.delete(10);
//        bst.delete(6);
//        bst.delete(8);
//
//        bst.showData();


        RBTree rb = new RBTree();
        rb.insertRB(1);
        rb.insertRB(4);
        rb.insertRB(2);
        rb.insertRB(6);

        rb.insertRB(15);
        rb.insertRB(3);
        rb.insertRB(8);
        rb.insertRB(7);
        rb.insertRB(11);
        rb.insertRB(17);
        rb.insertRB(10);
        rb.insertRB(5);
        rb.insertRB(13);
        rb.insertRB(16);
        rb.insertRB(14);



//        rb.print();



//
//        System.out.println();
//
//
//        bst.print();

//        System.out.println("Informacje dla wierzchołka 8");
//        bst.information(8);
//
//        bst.insert(12);
//        bst.print();
//        System.out.println("Informacje dla wierzchołka 9");
//        bst.information(9);
//        bst.delete(8);
//
//        bst.print();

////        System.out.println(bst.succesor(9));
//        Tree.OneWayLinkedListWithHead<Double> list = new Tree.OneWayLinkedListWithHead<>();
//        list.add(4.0);
//        list.add(2.0);
//        list.add(5.0);
//        list.add(1.0);
//        list.add(3.0);
//        list.add(7.0);
//        System.out.println(list.listMin());
    }
}
