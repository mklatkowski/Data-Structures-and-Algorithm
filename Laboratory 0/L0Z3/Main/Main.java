package Main;

import Pomiar.*;


public class Main {

    public static void main(String[] args) {

        KlasaUslugodawcza.Generate();
        System.out.println("Rekordy początkowo: ");
        KlasaUslugodawcza.View();

        Pomiar pomiar = new Pomiar(new Czas(2021, 2, 4, 8, 59), 31);
        Pomiar pomiar4 = new Pomiar(new Czas(2019, 6, 7, 8, 9), 90);

        KlasaUslugodawcza.Add(pomiar4);
        KlasaUslugodawcza.Add(pomiar);
        System.out.println(" Rekordy po dodaniu: ");
        KlasaUslugodawcza.View();

        int rok = 2021;
        int miesiac = 2;

        KlasaUslugodawcza.ExactDate(KlasaUslugodawcza.toTable(), rok, miesiac);
        KlasaUslugodawcza.TemperatureIncrease(KlasaUslugodawcza.toTable(), rok, miesiac);
    }
}
