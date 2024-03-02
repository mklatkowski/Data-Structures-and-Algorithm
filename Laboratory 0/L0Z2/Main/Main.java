package Main;

public class Main {

    public static double [][] table;

    public static void main(String[] args) {

        table = KlasaUslugodawcza.Generate(table);
        KlasaUslugodawcza.toBinary(table);
        table = KlasaUslugodawcza.fromBinary(table);
        KlasaUslugodawcza.View(table);
        KlasaUslugodawcza.Maximum(table);

    }
}
