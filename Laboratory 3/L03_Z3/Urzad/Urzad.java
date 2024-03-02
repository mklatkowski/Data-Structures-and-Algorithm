package Urzad;

import Observers.Klient;
import Observers.Observer;
import Observers.Queue;

import java.util.ArrayList;

public class Urzad implements Observable{

    private Observer observer;



    private Urzednik urzednikA;
    private Urzednik urzednikB;
    private Urzednik urzednikC;
    private int obecnyCzas;

    public Urzad(Urzednik urzednikA, Urzednik urzednikB, Urzednik urzednikC){
        this.urzednikA = urzednikA;
        this.urzednikB = urzednikB;
        this.urzednikC = urzednikC;

        obecnyCzas = 0;
    }

    public void registerObserver(Observer observer){
        this.observer = observer;
    }

    public void removeObserver(){
        observer = null;
    }

    public void notifyObservers(){
        deleteCustomers();
        if(urzednikA.getKlient()==null || urzednikB.getKlient()==null ||urzednikC.getKlient()==null)
        {
            Klient next = observer.update();
            if(next!=null){
                if(urzednikA.getKlient()==null){
                    urzednikA.setKlient(next);
                    System.out.println("Do urzędnika A podszedł nowy klient");
                    System.out.println(next);
                    System.out.println(" ");
                    urzednikA.setKiedyWolny(obecnyCzas+next.getCzasSprawy());
                }
                else if(urzednikB.getKlient()==null){
                    urzednikB.setKlient(next);
                    System.out.println("Do urzędnika B podszedł nowy klient");
                    System.out.println(next);
                    System.out.println(" ");
                    urzednikB.setKiedyWolny(obecnyCzas+next.getCzasSprawy());
                }
                else{
                    urzednikC.setKlient(next);
                    System.out.println("Do urzędnika C podszedł nowy klient");
                    System.out.println(next);
                    System.out.println(" ");
                    urzednikC.setKiedyWolny(obecnyCzas+next.getCzasSprawy());
                }
                notifyObservers();
            }
        }
    }
    public void deleteCustomers(){
        if(obecnyCzas!=0) {
            if (obecnyCzas == urzednikA.getKiedyWolny() && urzednikA.getKlient()!=null) {
                urzednikA.setKlient(null);
                System.out.println("Urzędnik A obsłużył klienta");
            }
            if (obecnyCzas == urzednikB.getKiedyWolny() && urzednikB.getKlient()!=null) {
                urzednikB.setKlient(null);
                System.out.println("Urzędnik B obsłużył klienta");
            }
            if (obecnyCzas == urzednikC.getKiedyWolny() && urzednikC.getKlient()!=null) {
                urzednikC.setKlient(null);
                System.out.println("Urzędnik C obsłużył klienta");
            }
        }
    }

    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public Urzednik getUrzednikA() {
        return urzednikA;
    }

    public void setUrzednikA(Urzednik urzednikA) {
        this.urzednikA = urzednikA;
    }

    public Urzednik getUrzednikB() {
        return urzednikB;
    }

    public void setUrzednikB(Urzednik urzednikB) {
        this.urzednikB = urzednikB;
    }

    public Urzednik getUrzednikC() {
        return urzednikC;
    }

    public void setUrzednikC(Urzednik urzednikC) {
        this.urzednikC = urzednikC;
    }

    public int getObecnyCzas() {
        return obecnyCzas;
    }

    public void setObecnyCzas(int obecnyCzas) {
        this.obecnyCzas = obecnyCzas;
    }
}
