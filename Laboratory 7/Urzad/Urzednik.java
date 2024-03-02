package Urzad;

import Observers.Klient;

public class Urzednik {

    private Klient klient;
    private int kiedyWolny;

    public Urzednik(){
        klient = null;
        kiedyWolny = 0;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public int getKiedyWolny() {
        return kiedyWolny;
    }

    public void setKiedyWolny(int kiedyWolny) {
        this.kiedyWolny = kiedyWolny;
    }
}
