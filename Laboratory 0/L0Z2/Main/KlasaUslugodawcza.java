package Main;

import java.io.*;
import java.util.Random;

public class KlasaUslugodawcza {

    //Wyliczenie maksimum z tablicy

    public static void Maximum(double [][] table){
        double max = table[0][0];
        int x=0;
        int y=0;
        for(int i=0; i< table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] > max) {
                    max = table[i][j];
                    x=i;
                    y=j;
                }
            }
        }
        System.out.println("Maksimum: " + max);
        System.out.println("Indeksy: Wiersz: " +x + ", Kolumna:" +y);
    }

    // wygenerowanie początkowej tablicy poprzez wylosowanie liczby rzędów, kolumn oraz wartości

    public static double [][] Generate(double [][] table){
        Random x = new Random();
        Random y = new Random();
        int a = x.nextInt(1,11);
        int b = y.nextInt(1,11);

        table = new double [a][b];
        for(int i=0; i< table.length; i++){
            for(int j=0; j<table[i].length; j++){
                Random numer = new Random();
                table[i][j] = Math.round(numer.nextDouble(1,100)*100)/100.00;
            }
        }
        return table;
    }

    // podgląd tablicy
    public static void View(double [][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%7.2f", table[i][j]);
            }
            System.out.println(" ");

        }
    }
    //zapis tablicy do pliku binarnego
    public static void toBinary(double [][] table){
        try(DataOutputStream bw = new DataOutputStream(new FileOutputStream("Lab0_2"))){
            bw.writeInt(table.length);
            bw.writeInt(table[0].length);
            for(int i=0; i< table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    bw.writeDouble(table[i][j]);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    // odczyt z pliku binarnego
    public static double[][] fromBinary(double [][] table){
        int x;
        int y;
        try(DataInputStream br = new DataInputStream(new FileInputStream("Lab0_2"))) {
            //pierwsze 2 liczby odczytane są jako wymiary docelowej tablicy
            x=br.readInt();
            y=br.readInt();
            table = new double [x][y];
            // następnie reszta jest odczytana jako wartości tablicy
            for(int i=0; i<x; i++){
                for(int j=0; j<y; j++){
                    table[i][j]=br.readDouble();
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return table;
    }
}
