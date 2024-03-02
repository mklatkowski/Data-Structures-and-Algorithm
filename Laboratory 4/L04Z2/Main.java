public class Main {

    public static void main(String[] args) {
        Stack<Double> stack= new Stack<>();
        System.out.println("Push elementów: ");
        stack.push(5.0);
        stack.push(6.0);
        stack.push(7.0);
        stack.push(8.0);


        System.out.println("Pop elementów: ");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("Pop elementu z pustego stosu: ");
        System.out.println(stack.pop());


    }
}
