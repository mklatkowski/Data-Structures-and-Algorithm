package OWL;

public class Main {

    public static void main(String[] args){
        OWL<Integer> owl = new OWL<Integer>(51, 4);

        System.out.println("Dane wejściowe:");
        System.out.println("Ilość osób: 29");
        System.out.println("co ile osób następuje zabicie: 3");
        System.out.println(" ");
        System.out.println("Pozostałe osoby: ");

        for(int i=0; i<owl.size(); i++){
            System.out.println(owl.get(i));
        }
    }
}
