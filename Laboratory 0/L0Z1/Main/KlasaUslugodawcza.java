package Main;

import java.io.*;
import java.util.Random;

public class KlasaUslugodawcza {

    // wyliczenie maksimum całej tablicy

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
// Początkowe wygenerowanie tablicy (wylosowana ilość rzędów i kolumn, a następnie wylosowanie do każdej
// komórki liczby od 1 do 100
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
    // Podgląd elementów
    public static void View(double [][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%5.2f", table[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");

        }
    }
    // Metoda zapisująca tablicę do pliku TXT
    public static void toTXT(double [][] table){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Lab0_1.txt"))){
            bw.write("Macierz:");
            bw.newLine();
            bw.write(String.valueOf(table.length));
            bw.newLine();
            bw.write(String.valueOf(table[0].length));
            bw.newLine();
            for(int i=0; i< table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    bw.write(String.valueOf(table[i][j]));
                    bw.write(" ");
                }
                bw.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static double [][] fromTXT(){
        String line;
        String []temp_table;
        int counter = 0;
        int y = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("Lab0_1.txt"))) {
            while ((line = br.readLine()) != null) {
                if (counter >= 3) { // counter>=3 dlatego, że pierwsze 3 wiersze są odpowiedzialne za tytuł i ilośc wierszy i kolumn
                    temp_table = line.split(" ");
                    y = temp_table.length;
                }
                counter++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        double [][] table = new double[counter-3][y]; // counter-3 z tego samego powodu co wcześniej
        counter = 0;

        // odczyt z pliku tekstowego elementów i zapis do nowej tablicy

        try(BufferedReader br = new BufferedReader(new FileReader("Lab0_1.txt"))) {

            while((line=br.readLine())!=null){
                if(counter>=3){
                    temp_table = line.split(" ");
                    for(int i=0; i<temp_table.length; i++){
                        table[counter-3][i] = Double.parseDouble(temp_table[i]);
                    }
                }
                counter++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return table;
    }
}
