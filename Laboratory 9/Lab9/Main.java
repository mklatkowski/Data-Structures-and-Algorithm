package Lab9;

import java.util.Comparator;
import Comparator.*;

public class Main {

    public static void main(String[] args){

        ComparatorC<String> comp= new Comp<>();

        Graf<String> graf = new Graf<String>(Typ.NIESKIEROWANY, comp);


        graf.addWierzcholek("A");
        graf.addWierzcholek("B");
        graf.addWierzcholek("C");
        graf.addWierzcholek("D");
        graf.addWierzcholek("E");
        graf.addWierzcholek("F");
        graf.addWierzcholek("G");
        graf.addWierzcholek("H");




//        graf.addKrawedz("A","D", 2);
//        graf.addKrawedz("A","B", 4);
//        graf.addKrawedz("A","E", 3);
//        graf.addKrawedz("B","E", 3);
//        graf.addKrawedz("B","F", 8);
//        graf.addKrawedz("B","C", 2);
//        graf.addKrawedz("C","F", 9);
//        graf.addKrawedz("D","G", 5);
//        graf.addKrawedz("E","G", 5);
//        graf.addKrawedz("H","E", 1);
//        graf.addKrawedz("F","H", 7);
//        graf.addKrawedz("G","H", 6);
//        graf.addKrawedz("B","H", 4);

        graf.addKrawedz("A","B", 2);
        graf.addKrawedz("A","C", 5);
        graf.addKrawedz("B","E", 4);
        graf.addKrawedz("B","D", 3);
        graf.addKrawedz("C","D", 5);
        graf.addKrawedz("C","F", 6);
        graf.addKrawedz("D","F", 1);
        graf.addKrawedz("D","E", 3);
        graf.addKrawedz("E","F", 4);
        graf.addKrawedz("E","G", 8);
        graf.addKrawedz("E","H", 2);
        graf.addKrawedz("F","G", 7);
        graf.addKrawedz("G","H", 1);



//        graf.addWierzcholek("Wrocław");
//        graf.addWierzcholek("Poznań");
//        graf.addWierzcholek("Warszawa");
//        graf.addWierzcholek("Oleśnica Rataje");
//        graf.addWierzcholek("Kalisz");
//        graf.addWierzcholek("Szczecin");
//        graf.addWierzcholek("Zakopane");
//        graf.addWierzcholek("Gdańsk");
//        graf.addWierzcholek("Radom");
//        graf.addWierzcholek("Ostrów Wielkopolski");
//        graf.addWierzcholek("Głogów");
//        graf.addWierzcholek("Toruń");
//        graf.addWierzcholek("Bydgoszcz");
//        graf.addWierzcholek("Opole");
//        graf.addWierzcholek("Kraków");
//        graf.addWierzcholek("Koszalin");
//
//        graf.addKrawedz("Wrocław", "Oleśnica Rataje", 30);
//        graf.addKrawedz("Oleśnica Rataje", "Ostrów Wielkopolski", 70);
//        graf.addKrawedz("Ostrów Wielkopolski", "Kalisz", 25);
//        graf.addKrawedz("Szczecin", "Gdańsk", 130);
//        graf.addKrawedz("Koszalin", "Gdańsk", 180);
//        graf.addKrawedz("Koszalin", "Gdańsk", 150);
//        graf.addKrawedz("Wrocław", "Oleśnica Rataje", 30);
//        graf.addKrawedz("Głogów", "Oleśnica Rataje", 120);
//        graf.addKrawedz("Głogów", "Kalisz", 170);

        

        graf.macierzSasiedztwa();
        graf.listaSasiedztwa();
        graf.macierzIncydencji();
        graf.minimalneDrzewoRozpinajace();


        graf.BFS("B");
        graf.DFS("B");
        graf.Dijkstra("H");
    }
}
