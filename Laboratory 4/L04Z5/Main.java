public class Main {

    public static double onp(String[] s){

        Stack stack = new Stack();

        for(int i=0; i<s.length; i++){

            switch(s[i]){

                case "*":{
                    Double a = Double.parseDouble(stack.pop());
                    Double b = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(a*b));
                    break;
                }
                case "+":{
                    Double a = Double.parseDouble(stack.pop());
                    Double b = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(a+b));
                    break;
                }
                case "-":{
                    Double a = Double.parseDouble(stack.pop());
                    Double b = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(b-a));
                    break;
                }
                case "/":{
                    Double a = Double.parseDouble(stack.pop());
                    Double b = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(b/a));
                    break;
                }
                default:{
                    stack.push(s[i]);
                }
            }
        }
        return Double.parseDouble(stack.pop());
    }

    public static void main(String[] args){

        String s = "1 2 + 4 * 5 + 3 -";
        System.out.println("Ciąg wyjściowy: " +s);
        System.out.println("Wynik: "+onp(s.split(" ")));

    }

}
