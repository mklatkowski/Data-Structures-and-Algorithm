package Student;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {

    private int nrIndeksu;
    private String imie;
    private String nazwisko;
    private ArrayList<Double> ocena;
    private Iterator iterator;

    public Student(int nrIndeksu, String imie, String nazwisko, ArrayList<Double> ocena){
        this.nrIndeksu = nrIndeksu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
    }

    public int getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(int nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public ArrayList<Double> getOcena() {
        return ocena;
    }

    public void setOcena(ArrayList<Double> ocena) {
        this.ocena = ocena;
    }

    public double Srednia(){
        this.iterator = ocena.iterator();
        double suma=0;
        while(iterator.hasNext()){
            Double ocena = (Double) iterator.next();
            if(ocena!= null)
                suma+= ocena ;
        }
        return suma/ocena.size();
    }
    public double Suma(){
        this.iterator = ocena.iterator();
        double suma=0;
        while(iterator.hasNext()){
            Double ocena = (Double) iterator.next();
            if(ocena!= null)
                suma+= ocena ;
        }
        return suma;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nrIndeksu=" + nrIndeksu +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", ocena=" + ocena +
                '}';
    }
}
