public class Main {

    public static void main(String[] args){
        Stack<Double> stack = new Stack<>(8);
        for(int i=1; i<=20; i++){
            System.out.println("Dodanie " +i +". elementu:");
            stack.push(1.0);
            System.out.println("Rozmiar: " +stack.size());
        }
        System.out.println("");
        System.out.println(" ");

        for(int i=20; i>0; i--){
            System.out.println("Pop: "+i+". elementu");
            stack.pop();
            System.out.println("Rozmiar: " +stack.size());
        }

    }
}
