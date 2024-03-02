package Student;

import java.util.Objects;

public class Student {

    private int indeks;
    private String imie;

    public Student(int indeks, String imie) {
        this.indeks = indeks;
        this.imie = imie;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Override
    public String toString() {
        return "Student{" +
                "indeks=" + indeks +
                ", imie='" + imie + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return indeks == student.indeks && Objects.equals(imie, student.imie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indeks, imie);
    }
}
