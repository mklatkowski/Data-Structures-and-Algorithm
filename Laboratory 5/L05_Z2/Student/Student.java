package Student;

public class Student implements Comparable{

    private int rocznik;
    private String imie;
    private String nazwisko;
    private double srednia;
    private boolean czyStypendium;

    public Student(int rocznik, String imie, String nazwisko, double srednia, boolean czyStypendium) {
        this.rocznik = rocznik;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.srednia = srednia;
        this.czyStypendium = czyStypendium;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
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

    public double getSrednia() {
        return srednia;
    }

    public void setSrednia(double srednia) {
        this.srednia = srednia;
    }

    public boolean isCzyStypendium() {
        return czyStypendium;
    }

    public void setCzyStypendium(boolean czyStypendium) {
        this.czyStypendium = czyStypendium;
    }

    @Override
    public int compareTo(Object o) {
        Student o1 = (Student) o;
        if(this.getRocznik()== o1.getRocznik()){
            return 0;
        }
        else if(this.getRocznik()<o1.getRocznik()){
            return -1;
        }
        else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "rocznik=" + rocznik +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", srednia=" + srednia +
                ", czyStypendium=" + czyStypendium +
                '}';
    }
}
