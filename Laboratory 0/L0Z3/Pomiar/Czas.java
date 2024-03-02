package Pomiar;

import java.io.Serializable;

public class Czas implements Serializable {

    private int rok;
    private int miesiac;
    private int dzien;
    private int godzina;
    private int minuta;

    public Czas(int rok, int miesiac, int dzien, int godzina, int minuta) {
        this.rok = rok;
        this.miesiac = miesiac;
        this.dzien = dzien;
        this.godzina = godzina;
        this.minuta = minuta;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getMiesiac() {
        return miesiac;
    }

    public void setMiesiac(int miesiac) {
        this.miesiac = miesiac;
    }

    public int getDzien() {
        return dzien;
    }

    public void setDzien(int dzien) {
        this.dzien = dzien;
    }

    public int getGodzina() {
        return godzina;
    }

    public void setGodzina(int godzina) {
        this.godzina = godzina;
    }

    public int getMinuta() {
        return minuta;
    }

    public void setMinuta(int minuta) {
        this.minuta = minuta;
    }

    public String toString(){
        return  "Rok: " +rok + " Miesiąc: " +miesiac + " Dzień: " +dzien + " Godzina: " +godzina + " Minuta: " + minuta;
    }
}
