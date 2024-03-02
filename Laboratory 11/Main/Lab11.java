package Main;

import java.util.Stack;

public class Lab11 {

    public static void start(){
        Huffman huf = new Huffman();
        String text = "ALA MA KOTA TOMEK MA PSA";
        String text2 = "BBEEEEEEEEFFFFFAAAAAAAAAAAABBBBCCCCAAAAAAAAAAAAAAAAAAAAAACCCCCCCCDDDDDDDDDDDDDDDDEAAAAAAAAAAABBBBBBB";
        String text3 = "Ala Ma kOtA, MaCieJ ma PSA";
        huf.codes(text3);

        Graham gr = new Graham(8, 10);
        Stack<Point> st = gr.otoczkaResult();
        while(st.size() > 0){
            System.out.println(st.pop());
        }
    }
}
