package Main;

public class Main {

    public static double [][] table;

    public static void main(String[] args) {

        table = KlasaUslugodawcza.Generate(table);
        KlasaUslugodawcza.toTXT(table);
        table = KlasaUslugodawcza.fromTXT();
        KlasaUslugodawcza.View(table);
        KlasaUslugodawcza.Maximum(table);

    }
}
