package Comparator;

import Main.Node;

import java.util.Comparator;

public class HuffmanComparator implements Comparator<Node> {
    public int compare(Node o1, Node o2){
        return Integer.compare(o1.getValue(), o2.getValue());
    }
}