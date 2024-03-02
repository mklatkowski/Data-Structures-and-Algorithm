package Observers;

public class Klient {

    private int czasSprawy;
    private int numer;
    private static int number = 0;

    public Klient(int czasSprawy){
        this.czasSprawy = czasSprawy;
        number++;
        this.numer = number;
    }

    public int getCzasSprawy() {
        return czasSprawy;
    }

    public void setCzasSprawy(int czasSprawy) {
        this.czasSprawy = czasSprawy;
    }

    @Override
    public String toString() {
        return "Klient nr: " + numer +
                " czasSprawy: " +czasSprawy;
    }
}
