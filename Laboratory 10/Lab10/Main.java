package Lab9;

import java.util.Comparator;
import Comparator.*;

public class Main {

    public static void main(String[] args){

        ComparatorC<String> comp= new Comp<>();

        Graf<String> graf = new Graf<String>(Typ.NIESKIEROWANY, comp);


//        graf.addWierzcholek("A");
//        graf.addWierzcholek("B");
//        graf.addWierzcholek("C");
//        graf.addWierzcholek("D");
//        graf.addWierzcholek("E");
//        graf.addWierzcholek("F");
//        graf.addWierzcholek("G");
//        graf.addWierzcholek("H");




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
//
//        graf.addKrawedz("A","B", 2);
//        graf.addKrawedz("A","C", 5);
//        graf.addKrawedz("B","E", 4);
//        graf.addKrawedz("B","D", 3);
//        graf.addKrawedz("C","D", 5);
//        graf.addKrawedz("C","F", 6);
//        graf.addKrawedz("D","F", 1);
//        graf.addKrawedz("D","E", 3);
//        graf.addKrawedz("E","F", 4);
//        graf.addKrawedz("E","G", 8);
//        graf.addKrawedz("E","H", 2);
//        graf.addKrawedz("F","G", 7);
//        graf.addKrawedz("G","H", 1);


//
//        graf.addWierzcholek("Wrocław");
//        graf.addWierzcholek("Poznań");
//        graf.addWierzcholek("Warszawa");
//        graf.addWierzcholek("Oleśnica Rataje");
//        graf.addWierzcholek("Kalisz");
//        graf.addWierzcholek("Szczecin");
//        graf.addWierzcholek("Zakopane");
//        graf.addWierzcholek("Gdańsk");;
//        graf.addWierzcholek("Ostrów Wielkopolski");
//        graf.addWierzcholek("Głogów");
//        graf.addWierzcholek("Koszalin");
//
//        graf.addKrawedz("Wrocław", "Oleśnica Rataje", 30);
//        graf.addKrawedz("Wrocław", "Głogów", 100);
//        graf.addKrawedz("Oleśnica Rataje", "Ostrów Wielkopolski", 70);
//        graf.addKrawedz("Ostrów Wielkopolski", "Kalisz", 25);
//        graf.addKrawedz("Szczecin", "Gdańsk", 130);
//        graf.addKrawedz("Koszalin", "Gdańsk", 180);
//        graf.addKrawedz("Głogów", "Oleśnica Rataje", 120);
//        graf.addKrawedz("Głogów", "Kalisz", 170);
//        graf.addKrawedz("Szczecin", "Poznań", 220);
//        graf.addKrawedz("Poznań", "Koszalin", 240);
//        graf.addKrawedz("Gdańsk", "Warszawa", 320);
//        graf.addKrawedz("Warszawa", "Kalisz", 220);
//        graf.addKrawedz("Poznań", "Kalisz", 120);
//        graf.addKrawedz("Głogów", "Poznań", 110);
//        graf.addKrawedz("Zakopane", "Kalisz", 350);
//        graf.addKrawedz("Wrocław", "Zakopane", 370);
//        graf.addKrawedz("Warszawa", "Zakopane", 400);

        graf.addWierzcholek("A");
        graf.addWierzcholek("B");
        graf.addWierzcholek("C");

        graf.addWierzcholek("D");
        graf.addWierzcholek("E");
        graf.addWierzcholek("F");

        graf.addKrawedz("E", "D", 1);
        graf.addKrawedz("A", "E", 2);
        graf.addKrawedz("B", "D", 3);
        graf.addKrawedz("B", "F", 4);
        graf.addKrawedz("C", "E", 5);
        graf.addKrawedz("C", "F", 6);

//
//        graf.macierzSasiedztwa();
//        graf.listaSasiedztwa();
//        graf.macierzIncydencji();
//        graf.minimalneDrzewoRozpinajace();

//
//        graf.BFS("B");
//        graf.DFS("B");
//        graf.minimalneDrzewoRozpinajace();

//        graf.Dijkstra("Gdańsk", "Zakopane");
//        graf.wszystkieSciezki("Gdańsk", "Zakopane");

        graf.macierzSasiedztwa();
        System.out.println();
        System.out.println("Czy graf jest dwudzielny: " +graf.dwudzielnosc());

    }
}
