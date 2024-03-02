package Lab9;

import java.util.Objects;

public class Wierzcholek<T> {
    private T wierzcholek;
    private COLOR color;

    public Wierzcholek(T wierzcholek){
        this.wierzcholek = wierzcholek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wierzcholek<?> that = (Wierzcholek<?>) o;
        return Objects.equals(wierzcholek, that.wierzcholek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wierzcholek);
    }

    @Override
    public String toString() {
        return " " + wierzcholek +
                ' ';
    }

    public T getWierzcholek() {
        return wierzcholek;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }
}
