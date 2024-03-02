public class Main {

    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>(6);
  
        System.out.println("Push: ");
        stack.push(4.0);
        stack.push(5.0);
        stack.push(6.0);
        System.out.println("Pop: ");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Dodanie za dużej ilości elementów: ");
        stack.push(4.0);
        stack.push(5.0);
        stack.push(6.0);
        stack.push(4.0);
        stack.push(5.0);
        stack.push(6.0);
        stack.push(4.0);


    }
}
