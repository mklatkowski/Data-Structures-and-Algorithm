package Main;

import java.util.*;
import Comparator.*;

public class Huffman {

    private Map<Character, Integer> chars;
    private Node root;
    private List<Node> nodes;

    private Map<Character, String> codes;

    public Huffman() {
        chars = new HashMap<>();
        codes = new HashMap<>();
        nodes = new ArrayList<>();
    }

    private void loadMap(String text) {
        System.out.println("Tekst początkowy:");
        System.out.println(text);
        System.out.println();
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!chars.containsKey(arr[i])) {
                chars.put(arr[i], 1);
            } else {
                chars.replace(arr[i], chars.get(arr[i]) + 1);
            }
        }
        System.out.println("Częstość występowania znaków:");
        System.out.println(chars);
        System.out.println();
    }

    public void codes(String text) {
        loadMap(text);
        initializeNodes();
        sort();
        createHuffmanTree();
        initializeCodes(root, "");

        System.out.println("Kody Huffmana:");
        System.out.println(codes);
        System.out.println();

        String encrypted = encrypt(text);
        decrypt(encrypted);

//        System.out.println(nodes);
    }

    private void sort() {
        HuffmanComparator comp = new HuffmanComparator();
        Collections.sort(nodes, comp);
    }
    private void createHuffmanTree(){
        while(nodes.size()>1){
            Node node = new Node(null, nodes.get(0).getValue()+nodes.get(1).getValue());
            node.left = nodes.get(0);
            node.right = nodes.get(1);
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(node);
            sort();
        }
        root = nodes.get(0);
    }

    private void initializeNodes(){
        for(Character key: chars.keySet()){
            nodes.add(new Node(key, chars.get(key)));
        }
    }

    private void initializeCodes(Node node, String code){
//        System.out.println(code);
        if(node.getCharNode()!=null){
            codes.put(node.getCharNode(), code);
        }
        char ch = '0';
        String tempCode = code + ch;
        if (node.left != null) {
            initializeCodes(node.left, tempCode);
        }
//        System.out.print(node.value +" ");
        if (node.right != null) {
            ch = '1';
            tempCode = code + ch;
            initializeCodes(node.right, tempCode);
        }
    }


    private String encrypt(String text){
        StringBuilder sb = new StringBuilder(text);
        String result = "";
        for(int i=0; i<text.length(); i++){
            result = result+codes.get(sb.charAt(i));
        }
        System.out.println("Zakodowany tekst:");
        System.out.println(result);
        System.out.println();
        System.out.println();
        return result;
    }

    private String decrypt(String encrypted){
        String result = "";
        while(encrypted.length()>0){
            int i=1;
            while(true){
                String substring = encrypted.substring(0,i);
                boolean b = false;
                for(Character key: chars.keySet()){
                    if(codes.get(key).equals(substring)){
                        result = result + key;
                        b = true;
                        break;
                    }
                }
                if(b){
                    encrypted = encrypted.substring(i);
//                    System.out.println(result);
//                    System.out.println(encrypted);
//                    System.out.println();
                    break;
                }
                else{
                    i++;
                }
            }
        }
        System.out.println("Wynik:");
        System.out.println(result);
        System.out.println();
        System.out.println();
        System.out.println();
        return result;
    }
}
