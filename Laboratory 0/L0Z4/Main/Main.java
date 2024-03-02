package Main;

import Pomiar.*;

import java.io.*;
import java.util.ArrayList;

public class Main {

    static ArrayList<CiagPomiarow> lista = new ArrayList<>();

    public static void main(String[] args){

        Pomiar [] table = new Pomiar[2];

        table[0] = new Pomiar(new Czas(2020, 5, 20, 12, 57), 37);
        table[1] = new Pomiar(new Czas(2021, 2, 7, 8, 59), 39);

        CiagPomiarow ciag = new CiagPomiarow(table);
        lista.add(ciag);

        // Można wykomentować linijkę poniżej aby zobaczyć, że w razie braku ponownej serializacji deserializacja jest możliwa
        //(oczywiście jeśli istnieje już plik obiektów (był on już kiedyś serializowany))

        KlasaUslugodawcza.Serialize(lista);
        lista = KlasaUslugodawcza.Deserialize();
        KlasaUslugodawcza.View(lista);


    }
}
