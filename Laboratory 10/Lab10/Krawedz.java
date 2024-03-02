package Lab9;

import java.util.Objects;

public class Krawedz<T>{
    private T poczatek;
    private T koniec;

    private int value;

    public Krawedz(T poczatek, T koniec, int value){
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Krawedz<?> krawedz = (Krawedz<?>) o;
        return Objects.equals(poczatek, krawedz.poczatek) && Objects.equals(koniec, krawedz.koniec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poczatek, koniec);
    }

    @Override
    public String toString() {
        return "(" +
                 poczatek +
                "," + koniec +
                ')';
    }

    public int getValue() {
        return value;
    }

    public T getPoczatek() {
        return poczatek;
    }

    public T getKoniec() {
        return koniec;
    }
}
