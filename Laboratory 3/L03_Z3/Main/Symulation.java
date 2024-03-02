package Main;

import Observers.Klient;
import Observers.Queue;
import Urzad.Urzad;
import Urzad.Urzednik;

import java.util.Random;

public class Symulation {

    public static boolean losujPrawdopodobienstwo() {
        Random rand = new Random();
        int r = rand.nextInt(50, 100);
        return czyGenerowac(r);
    }

    public static boolean czyGenerowac(int k) {
        Random rand = new Random();
        int r = rand.nextInt(1, 100);
        if (k >= r) {
            return true;
        }
        return false;
    }

    public static void symulate() throws InterruptedException {
        int obecnyCzas = 0;

        Urzednik urzednikA = new Urzednik();
        Urzednik urzednikB = new Urzednik();
        Urzednik urzednikC = new Urzednik();

        Urzad urzad = new Urzad(urzednikA, urzednikB, urzednikC);

        Queue queue = new Queue();

        urzad.registerObserver(queue);

        while (true) {
            System.out.println(" ");
            System.out.println("Obecny czas: " + obecnyCzas);

            urzad.setObecnyCzas(obecnyCzas);

            if (losujPrawdopodobienstwo()) {
                Random r1 = new Random();
                int r11 = r1.nextInt(3, 7);

                Klient klient = new Klient(r11);
                queue.enqueue(klient);
                System.out.println("Do kolejki doszedł nowy klient:");
                System.out.println(klient);
                System.out.println(" ");
            }

            urzad.notifyObservers();

            System.out.println("Kolejka");
            for (int i = 0; i < queue.size(); i++) {
                System.out.println(queue.get(i));
            }

            obecnyCzas++;

            Thread.sleep(1000);
        }
    }
}
