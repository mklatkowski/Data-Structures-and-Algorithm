package Main;

import Pomiar.Pomiar;

import java.io.*;
import java.util.ArrayList;
import Pomiar.*;

public class KlasaUslugodawcza {

    private static int counter = 0;

    public static void ExactDate(Pomiar[] table, int rok, int miesiac){
        int exactDateCounter=0;
        System.out.println("Rekordy które posiadają rok: " +rok + ", i miesiąc: " +miesiac);
        for(int i=0; i< table.length; i++){
            if(table[i].getCzas().getRok()==rok && table[i].getCzas().getMiesiac() == miesiac){
                System.out.println(table[i]);
                exactDateCounter++;
            }
        }
        if(exactDateCounter==0){
            System.out.println("Brak danych spełniających wymagania");
        }
        System.out.println(" ");
    }

    public static void TemperatureIncrease(Pomiar [] table, int rok, int miesiac){
        int temperatureIncrement = 0; // zmienna pomocnicza, która w razie braku spełnienia warunku przez jakikolwiek rekord pozwilo na wypisanie komunikatu
        System.out.println("Rekordy, dla których temperatura wzrosła i posiadają rok:" + rok + " miesiąc: " + miesiac);
        for(int i=1; i<table.length; i++){
            if((table[i].getTemperatura()-table[i-1].getTemperatura())>0){
                if(table[i].getCzas().getRok()==rok && table[i].getCzas().getMiesiac()==miesiac)
                System.out.println(table[i]);
                temperatureIncrement++;
            }
        }
        if(temperatureIncrement ==0){
            System.out.println("Brak rekordów spełniających warunek");
        }

    }

    // jak w poprzednich programach, odczyt z pliku binarnego do tablicy, a następnie wypisanie jego elementów

    public static void View() {
        Pomiar [] table1 = new Pomiar[counter];
        int indeks = 0;
        try (DataInputStream dis = new DataInputStream(new FileInputStream("Lab0_3"))) {
            try {
                while (dis.available() > 0) {
                    table1[indeks] = new Pomiar(new Czas(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt()), dis.readDouble());
                    indeks++;

                }
            } catch (EOFException e) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0; i<table1.length; i++) {
            System.out.println(table1[i]);
        }
        System.out.println(" ");
    }

    public static void Sort(Pomiar[] table) {
        boolean mniejszy = true;
        int indeks = 0;
        while (mniejszy) {
            //wyszukanie odpowiedniego miejsca w tablicy. Liczenie wartości czasu (Przykładowo, dla daty - 7.03.2022 13:15 wartość czasu będzie
            // wyglądała następująco: 202203071315. Dzięki temu nie trzeba wywoływać paru pętli sprawdzając najpierw rok, potem miesiąc itd.
            if (table[indeks].getCzas().getRok() * 100000000 + table[indeks].getCzas().getMiesiac() * 100000 + table[indeks].getCzas().getDzien() * 1000 + table[indeks].getCzas().getGodzina() * 100 + table[indeks].getCzas().getMinuta() < table[counter - 1].getCzas().getRok() * 100000000 + table[counter - 1].getCzas().getMiesiac() * 100000 + table[counter - 1].getCzas().getDzien() * 1000 + table[counter - 1].getCzas().getGodzina() * 100 + table[counter - 1].getCzas().getMinuta()) {
                indeks++;
            } else {
                // jeśli znajdzie się element który znalazł odpowiednie miejsce, wartość zmiennej "mniejszy" zmienia się na false, przez co while(mniejszy) już się nie wykona
                mniejszy = false;
                Pomiar temp = table[counter-1];
               // wszystkie rekordy które były później od podanego czasu, zmieniają swoje miejsce o 1 w tablicy
                for (int i = table.length - 1; i > indeks; i--) {
                    table[i] = table[i-1];
                }
                // a pomiar jest ostatecznie dodawany w odpowiednie miejsce
                table[indeks] = temp;
            }
        }
        // cała tablica następnie jest zapisywana ponownie do pliku binarnego
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Lab0_3"))) {
            try {
                for (int i = 0; i < table.length; i++) {
                    dos.writeInt(table[i].getCzas().getRok());
                    dos.writeInt(table[i].getCzas().getMiesiac());
                    dos.writeInt(table[i].getCzas().getDzien());
                    dos.writeInt(table[i].getCzas().getGodzina());
                    dos.writeInt(table[i].getCzas().getMinuta());
                    dos.writeDouble(table[i].getTemperatura());
                }
            } catch (EOFException e) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static Pomiar[] toTable() {
        Pomiar [] table1 = new Pomiar[counter];
        int indeks = 0;
        try (DataInputStream dis = new DataInputStream(new FileInputStream("Lab0_3"))) {
            try {
                while (dis.available() > 0) {
                    table1[indeks] = new Pomiar(new Czas(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt()), dis.readDouble());
                    if(counter-1>indeks){
                        indeks++;
                    }
                }
            } catch (EOFException e) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table1;

    }

    // wywołanie metody dodającej rekord w odpowiednie miejsce w pliku binarnym

    public static void Add(Pomiar pomiar) {
        ArrayList<Pomiar> list = new ArrayList<>();
        // jeśli w pliku znajduje się już przynajmniej jeden rekord, zapisywany jest on do pomocniczej listy ociektów typu Pomiar
        if(counter>=1){
            try (DataInputStream dis = new DataInputStream(new FileInputStream("Lab0_3"))) {
                try {
                    while (dis.available() > 0) {
                        list.add(new Pomiar(new Czas(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt()), dis.readDouble()));
                    }
                } catch (EOFException e) {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // ten kawałek wywoła się bez względu na ilość rekordów, dlatego należy ponownie otworzyć strumień

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Lab0_3"))) {
            try {
                for (int i = 0; i < list.size(); i++) {
                    dos.writeInt(list.get(i).getCzas().getRok());
                    dos.writeInt(list.get(i).getCzas().getMiesiac());
                    dos.writeInt(list.get(i).getCzas().getDzien());
                    dos.writeInt(list.get(i).getCzas().getGodzina());
                    dos.writeInt(list.get(i).getCzas().getMinuta());
                    dos.writeDouble(list.get(i).getTemperatura());
                }
                dos.writeInt(pomiar.getCzas().getRok());
                dos.writeInt(pomiar.getCzas().getMiesiac());
                dos.writeInt(pomiar.getCzas().getDzien());
                dos.writeInt(pomiar.getCzas().getGodzina());
                dos.writeInt(pomiar.getCzas().getMinuta());
                dos.writeDouble(pomiar.getTemperatura());
                counter++;
            } catch (EOFException e) {
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (counter > 1) {
            // Wywołanie metody szeregującej odpowiednio rekordy. Plik musi byc jednak najpierw przedstawiony w postaci tablicy
            Sort(toTable());
        }

    }

    public static void Generate() {
        Pomiar pomiar1 = new Pomiar(new Czas(2020, 5, 20, 12, 57), 37);
        Pomiar pomiar2 = new Pomiar(new Czas(2021, 2, 7, 8, 59), 39);
        Pomiar pomiar = new Pomiar(new Czas(2021, 2, 3, 8, 59), 30);

        Add(pomiar2);
        Add(pomiar1);
        Add(pomiar);
    }
}
