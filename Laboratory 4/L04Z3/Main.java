public class Main {

    public static void main(String[] args){
        Stack<Double> stack = new Stack<>(4);
        System.out.println("Rozmiar stosu: n = 4");
        System.out.println("Kolejne push: ");

        System.out.println("1.0");
        System.out.println("2.0");
        System.out.println("3.0");
        System.out.println("4.0");
        System.out.println("5.0");
        System.out.println("6.0");

        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        stack.push(5.0);
        stack.push(6.0);

        System.out.println("Wypisanie n razy pop: ");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Wypisanie n+1 raz: ");
        System.out.println(stack.pop());


    }
}
