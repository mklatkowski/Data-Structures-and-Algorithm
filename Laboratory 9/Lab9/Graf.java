package Lab9;

import java.util.*;

import Comparator.*;

public class Graf<T> {

    private final ArrayList<Wierzcholek<T>> wierzcholki;
    private final ArrayList<Krawedz<T>> krawedzie;
    private final Typ typ;
    private final ComparatorC<T> comp;

    public Graf(Typ typ, ComparatorC<T> comp) {

        wierzcholki = new ArrayList<>();
        krawedzie = new ArrayList<>();
        this.typ = typ;
        this.comp = comp;
        System.out.println();
        System.out.println("Typ grafu: ");
        if (typ == Typ.SKIEROWANY) {
            System.out.print("SKIEROWANY");
        } else {
            System.out.println("NIESKIEROWANY");
        }
        System.out.println();
        System.out.println();
    }

    public void addWierzcholek(T element) {
        wierzcholki.add(new Wierzcholek<T>(element));
        sort();
    }

    public void addKrawedz(T poczatek, T koniec, int value) {
        if (wierzcholki.contains(new Wierzcholek<>(poczatek)) && wierzcholki.contains(new Wierzcholek<>(koniec))) {
            krawedzie.add(new Krawedz<>(poczatek, koniec, value));
        } else {
            System.out.println("Nie ma jednego z wierzchołków, do którego trzeba doprowadzić krawędzie" + poczatek + " " + koniec);
        }
    }

    public void macierzIncydencji() {

        int sizeX = krawedzie.size() + 1;
        int sizeY = wierzcholki.size() + 1;


        Object macierz[][] = new Object[sizeY][sizeX];
        macierz[0][0] = "";
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (i > 0 && j == 0) {
                    macierz[i][j] = wierzcholki.get(i - 1).getWierzcholek();
                } else if (j > 0 && i == 0) {
                    macierz[i][j] = krawedzie.get(j - 1);
                } else {
                    if (i > 0) {
                        if (typ == Typ.NIESKIEROWANY) {
                            if (krawedzie.get(j - 1).getPoczatek().equals((T) macierz[i][0]) || krawedzie.get(j - 1).getKoniec().equals((T) macierz[i][0])) {
                                macierz[i][j] = 1;
                            } else {
                                macierz[i][j] = 0;
                            }
                        } else {
                            if (krawedzie.get(j - 1).getPoczatek().equals((T) macierz[i][0])) {
                                macierz[i][j] = -1;
                            } else if (krawedzie.get(j - 1).getKoniec().equals((T) macierz[i][0])) {
                                macierz[i][j] = 1;
                            } else {
                                macierz[i][j] = 0;
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                System.out.printf("%-10s", macierz[i][j]);
            }
            System.out.println();
        }
    }

    public void macierzSasiedztwa() {
        int size = wierzcholki.size() + 1;
        Object macierz[][] = new Object[size][size];
        for (int i = 1; i < size; i++) {
            macierz[0][i] = wierzcholki.get(i - 1).getWierzcholek();
            macierz[i][0] = wierzcholki.get(i - 1).getWierzcholek();
        }
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                Krawedz<T> temp1 = new Krawedz<>((T) macierz[0][i], (T) macierz[j][0], 0);
                Krawedz<T> temp2 = new Krawedz<>((T) macierz[j][0], (T) macierz[0][i], 0);
                if (typ == Typ.SKIEROWANY) {
                    if (krawedzie.contains(temp1)) {
                        for (Krawedz<T> x : krawedzie) {
                            if (x.equals(temp1)) {
                                macierz[i][j] = x.getValue();
                                break;
                            }
                        }
                    } else {
                        macierz[i][j] = "∞";
                    }
                } else {
                    if (krawedzie.contains(temp1) || krawedzie.contains(temp2)) {
                        for (Krawedz<T> x : krawedzie) {
                            if (x.equals(temp1) || x.equals(temp2)) {
                                macierz[i][j] = x.getValue();
                                break;
                            }
                        }
                    } else {
                        macierz[i][j] = "∞";
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (macierz[i][j] == null) {
                    System.out.printf("%-10s", "");
                } else
                    System.out.printf("%-10s", macierz[i][j]);
            }
            System.out.println(" ");
        }
    }


    //TODO dodać prawdziwe linkedListy
    public void listaSasiedztwa() {
        for (Wierzcholek<T> x : wierzcholki) {
            System.out.print(x.getWierzcholek() + " ");
            for (Krawedz<T> y : krawedzie) {
                if (y.getPoczatek().equals(x.getWierzcholek())) {
                    System.out.print(" - " + y.getKoniec() + " waga: " + y.getValue());
                } else if (y.getKoniec().equals(x.getWierzcholek()) && typ == Typ.NIESKIEROWANY) {
                    System.out.print(" - " + y.getPoczatek() + " waga: " + y.getValue());
                }
            }
            System.out.println(" ");
        }
    }

    public void sort() {
        Comp comp = new Comp();
        for (int i = 0; i < wierzcholki.size(); i++) {
            for (int j = 0; j < wierzcholki.size(); j++) {
                if (comp.compare(wierzcholki.get(i), wierzcholki.get(j)) < 0) {
                    Wierzcholek<T> temp = wierzcholki.get(i);
                    wierzcholki.set(i, wierzcholki.get(j));
                    wierzcholki.set(j, temp);
                }
            }
        }
    }

    public void minimalneDrzewoRozpinajace() {
        ArrayList<Krawedz<T>> result = drzewoRozpinajace();
        if (result != null) {
            System.out.println("Krawędzie budujące minimalne drzewo rozpinające: ");
            for (Krawedz<T> x : result) {
                System.out.println(x);
            }
        }
    }

    private ArrayList<Krawedz<T>> drzewoRozpinajace() {
        sortKrawedzie(krawedzie);
        int counter = 0;
        ArrayList<Krawedz<T>> result = new ArrayList<>();
        ArrayList<ArrayList<Wierzcholek<T>>> zbiorRoboczy = copyWierzcholki();
        while (zbiorRoboczy.size() > 1) {
            T poczatekTemp = krawedzie.get(counter).getPoczatek();
            T koniecTemp = krawedzie.get(counter).getKoniec();
            for (ArrayList<Wierzcholek<T>> y : zbiorRoboczy) {
                if (y.contains(new Wierzcholek<>(poczatekTemp))) {
                    if (!y.contains(new Wierzcholek<>(koniecTemp))) {
                        result.add(krawedzie.get(counter));
                        Wierzcholek<T> temp = new Wierzcholek<>(koniecTemp);
                        for (ArrayList<Wierzcholek<T>> z : zbiorRoboczy) {
                            if (z.contains(temp)) {
                                y.addAll(z);
                                zbiorRoboczy.remove(z);
                                break;
                            }
                        }
                    }
                    break;
                } else if (y.contains(new Wierzcholek<>(koniecTemp)) && typ == Typ.NIESKIEROWANY) {
                    if (!y.contains(new Wierzcholek<>(poczatekTemp))) {
                        result.add(krawedzie.get(counter));
                        Wierzcholek<T> temp = new Wierzcholek<>(poczatekTemp);
                        for (ArrayList<Wierzcholek<T>> z : zbiorRoboczy) {
                            if (z.contains(temp)) {
                                y.addAll(z);
                                zbiorRoboczy.remove(z);
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            counter++;
            if (counter == krawedzie.size() && zbiorRoboczy.size() != 1) {
                System.out.println("Nie da sie stworzyć na tym grafie minimalnego drzewa rozpinającego");
                return null;
            }
        }

        return result;
    }

    public void sortKrawedzie(ArrayList<Krawedz<T>> krawedzie) {
        CompK comp = new CompK();
        for (int i = 0; i < krawedzie.size(); i++) {
            for (int j = 0; j < krawedzie.size(); j++) {
                if (comp.compare(krawedzie.get(i), krawedzie.get(j)) < 0) {
                    Krawedz<T> temp = krawedzie.get(i);
                    krawedzie.set(i, krawedzie.get(j));
                    krawedzie.set(j, temp);
                }
            }
        }
    }

    public ArrayList<ArrayList<Wierzcholek<T>>> copyWierzcholki() {
        ArrayList<ArrayList<Wierzcholek<T>>> list = new ArrayList<>();
        for (int i = 0; i < wierzcholki.size(); i++) {
            list.add(new ArrayList<>());
            list.get(i).add(wierzcholki.get(i));
        }
        return list;
    }

    public ArrayList<Wierzcholek<T>> copyWierzcholki2() {
        ArrayList<Wierzcholek<T>> list = new ArrayList<>();
        for (int i = 0; i < wierzcholki.size(); i++) {
            list.add(new Wierzcholek<T>(wierzcholki.get(i).getWierzcholek()));
        }
        return list;
    }

    public ArrayList<Krawedz<T>> copyKrawedz() {
        ArrayList<Krawedz<T>> list = new ArrayList<>();
        for (int i = 0; i < krawedzie.size(); i++) {
            list.add(new Krawedz<T>(krawedzie.get(i).getPoczatek(), krawedzie.get(i).getKoniec(), krawedzie.get(i).getValue()));
        }
        return list;
    }

    public void DFS(T wierzcholek) {
        sortKrawedzie(krawedzie);
        ArrayList<Wierzcholek<T>> wierz = copyWierzcholki2();
        ArrayList<Wierzcholek<T>> result = new ArrayList<>();
        for (Wierzcholek<T> w : wierz) {
            w.setColor(COLOR.WHITE);
        }
        Wierzcholek<T> temp = getWierzcholek(wierzcholek, wierz);
        if (temp == null) {
            System.out.println("Nie ma takiego wierzchołka aby móc przejść po nim sposobem DFS");
        } else {
            DFSVisit(temp, result, wierz);
            for (Wierzcholek<T> w : wierz) {
                if (w != null && w.getColor() == COLOR.WHITE) {
                    DFSVisit(w, result, wierz);
                }
            }
            System.out.println("Kolejne wierzchołki w przechodzeniu DFS od wierzchołka: " + wierzcholek);
            for (Wierzcholek<T> x : result) {
                System.out.print(x + " ");
            }
        }
    }

    private void DFSVisit(Wierzcholek<T> w, ArrayList<Wierzcholek<T>> result, ArrayList<Wierzcholek<T>> wierz) {
        w.setColor(COLOR.GREY);
        result.add(w);
        for (Krawedz<T> kraw : krawedzie) {
            if (kraw.getPoczatek().equals(w.getWierzcholek())) {
                if (getWierzcholek(kraw.getKoniec(), wierz).getColor() == COLOR.WHITE)
                    DFSVisit(Objects.requireNonNull(getWierzcholek(kraw.getKoniec(), wierz)), result, wierz);
            } else if (kraw.getKoniec().equals(w.getWierzcholek()) && typ == Typ.NIESKIEROWANY) {
                if (getWierzcholek(kraw.getPoczatek(), wierz).getColor() == COLOR.WHITE)
                    DFSVisit(Objects.requireNonNull(getWierzcholek(kraw.getPoczatek(), wierz)), result, wierz);
            }
        }
    }

    //TODO w razie takich samych długości ścieżek sortowanie alfabetycznie;
    public void BFS(T wierzcholek) {
        if (typ == Typ.NIESKIEROWANY) {
            Queue<Wierzcholek<T>> queue = new LinkedList<>();
            ArrayList<Wierzcholek<T>> result = new ArrayList<>();
            Wierzcholek<T> temp = new Wierzcholek<>(wierzcholek);
            boolean b = false;
            for (Wierzcholek<T> w : wierzcholki) {
                if (w.equals(temp)) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                System.out.println("Nie ma takiego wierzchołka");
            } else {
                ArrayList<Wierzcholek<T>> wierz = copyWierzcholki2();
                ArrayList<Krawedz<T>> list = copyKrawedz();
                sortKrawedzie(list);
                queue.add(temp);
                wierz.remove(temp);
                while (!wierz.isEmpty()) {
                    if (wierz.size() != wierzcholki.size() - 1)
                        queue.add(wierz.get(0));
                    while (!queue.isEmpty()) {
                        for (Krawedz<T> krawedz : list) {
                            if (krawedz.getPoczatek().equals(queue.peek().getWierzcholek()) && wierz.contains(new Wierzcholek<>(krawedz.getKoniec()))) {
                                queue.add(new Wierzcholek<>(krawedz.getKoniec()));
                                wierz.remove(new Wierzcholek<>(krawedz.getKoniec()));
                            } else if (krawedz.getKoniec().equals(queue.peek().getWierzcholek()) && wierz.contains(new Wierzcholek<>(krawedz.getPoczatek()))) {
                                queue.add(new Wierzcholek<>(krawedz.getPoczatek()));
                                wierz.remove(new Wierzcholek<>(krawedz.getPoczatek()));
                            }
                        }
                        result.add(queue.poll());
                    }
                }
                System.out.println("Przechodzenie BFS od wierzchołka: " +wierzcholek);
                for (Wierzcholek<T> x : result) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Dla nieskierowanego nie można robić przeszukiwania wszerz");
        }
    }

    private Wierzcholek<T> getWierzcholek(T wierzcholek, ArrayList<Wierzcholek<T>> list) {
        Wierzcholek<T> temp = new Wierzcholek<>(wierzcholek);
        for (Wierzcholek<T> w : list) {
            if (w.equals(temp)) {
                return w;
            }
        }
        return null;
    }

    public void Dijkstra(T start) {
        class DijkstraValues<T> {
            private Wierzcholek<T> wierz;
            private int value;
            private COLOR color;
            private DijkstraValues<T> poprzednik;
            private Krawedz<T> krawedzZPoprzednikiem;

            public DijkstraValues(Wierzcholek<T> wierz, int value) {
                this.wierz = wierz;
                this.value = value;
            }

            public Wierzcholek<T> getWierz() {
                return wierz;
            }

            public void setWierz(Wierzcholek<T> wierz) {
                this.wierz = wierz;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public COLOR getColor() {
                return color;
            }

            public void setColor(COLOR color) {
                this.color = color;
            }

            public DijkstraValues<T> getPoprzednik() {
                return poprzednik;
            }

            public void setPoprzednik(DijkstraValues<T> poprzednik) {
                this.poprzednik = poprzednik;
            }

            public Krawedz<T> getKrawedzZPoprzednikiem() {
                return krawedzZPoprzednikiem;
            }

            public void setKrawedzZPoprzednikiem(Krawedz<T> krawedzZPoprzednikiem) {
                this.krawedzZPoprzednikiem = krawedzZPoprzednikiem;
            }
        }
        Wierzcholek<T> temp = new Wierzcholek<>(start);
        boolean b = false;
        for (Wierzcholek<T> w : wierzcholki) {
            if (w.equals(temp)) {
                b = true;
                break;
            }
        }
        if (!b) {
            System.out.println("Nie ma takiego wierzchołka");
        } else {
            ArrayList<Krawedz<T>> result = new ArrayList<>();
            ArrayList<DijkstraValues<T>> wierzcholkiDijkstra = new ArrayList<>();
            ArrayList<DijkstraValues<T>> wierzcholkiDijkstraTemp = new ArrayList<>();

            for (Wierzcholek<T> w : wierzcholki) {
                Wierzcholek<T> toAdd = new Wierzcholek<>(w.getWierzcholek());
                if (toAdd.equals(temp)) {
                    wierzcholkiDijkstra.add(new DijkstraValues<>(toAdd, 0));
                } else {
                    wierzcholkiDijkstra.add(new DijkstraValues<>(toAdd, 2147483647));
                }
            }
            for (DijkstraValues<T> w : wierzcholkiDijkstra) {
                w.setColor(COLOR.WHITE);
            }

            while (wierzcholkiDijkstra.size() > 0) {
                for (int i = 1; i < wierzcholkiDijkstra.size(); i++) {
                    for (int j = 0; j < wierzcholkiDijkstra.size() - 1; j++) {
                        if (wierzcholkiDijkstra.get(i).getValue() < wierzcholkiDijkstra.get(j).getValue()) {
                            DijkstraValues<T> tempW = wierzcholkiDijkstra.get(i);
                            wierzcholkiDijkstra.set(i, wierzcholkiDijkstra.get(j));
                            wierzcholkiDijkstra.set(j, tempW);
                        }
                    }
                }
                DijkstraValues<T> nowUsed = wierzcholkiDijkstra.get(0);
                if (nowUsed.getValue() == 2147483647) {
                    break;
                }
                if (nowUsed.getKrawedzZPoprzednikiem() != null) {
                    result.add(nowUsed.getKrawedzZPoprzednikiem());
                }
                for (Krawedz<T> krawedz : krawedzie) {
                    if (krawedz.getPoczatek().equals(nowUsed.getWierz().getWierzcholek())) {
                        for (DijkstraValues<T> w : wierzcholkiDijkstra) {
                            if (w.getWierz().getWierzcholek().equals(krawedz.getKoniec())) {
                                w.setColor(COLOR.GREY);
                                if (nowUsed.getValue() + krawedz.getValue() < w.getValue()) {
                                    w.setValue(krawedz.getValue() + nowUsed.getValue());
                                    w.setPoprzednik(nowUsed);
                                    w.setKrawedzZPoprzednikiem(krawedz);
                                }
                            }
                        }
                    } else if (krawedz.getKoniec().equals(nowUsed.getWierz().getWierzcholek()) && typ == Typ.NIESKIEROWANY) {
                        for (DijkstraValues<T> w : wierzcholkiDijkstra) {
                            if (w.getWierz().getWierzcholek().equals(krawedz.getPoczatek())) {
                                w.setColor(COLOR.GREY);
                                if ((nowUsed.getValue() + krawedz.getValue() < w.getValue())) {
                                    w.setValue(krawedz.getValue() + nowUsed.getValue());
                                    w.setPoprzednik(nowUsed);
                                    w.setKrawedzZPoprzednikiem(krawedz);
                                }
                            }
                        }
                    }
                }
                wierzcholkiDijkstraTemp.add(nowUsed);
                wierzcholkiDijkstra.remove(nowUsed);
            }

            System.out.println();
            System.out.println();
            System.out.println("Krawedzie Dijkstra od wierzchołka: " + start);

            for (Krawedz<T> kr : result) {
                System.out.println(kr);
            }
//            int droga = 0;
//
//            System.out.println();
//            System.out.println();
//            System.out.println("Początek: " + start);
//            System.out.println("Koniec: " + end);
//            System.out.println();
//            System.out.println("Droga prezentuje się następująco:");
//            System.out.println();
//            System.out.println();
//
//            while (!end.equals(start)) {
//                boolean exists = false;
//                for (DijkstraValues<T> dv : wierzcholkiDijkstraTemp) {
//                    if (dv.getWierz().getWierzcholek().equals(end) && dv.getKrawedzZPoprzednikiem() != null) {
//                        System.out.println(end);
//                        System.out.println(".");
//                        System.out.println(".");
//                        System.out.println(dv.getKrawedzZPoprzednikiem().getValue() + " km");
//                        System.out.println(".");
//                        System.out.println(".");
//                        if (!dv.getKrawedzZPoprzednikiem().getKoniec().equals(end)) {
//                            end = dv.getKrawedzZPoprzednikiem().getKoniec();
//                        } else {
//                            end = dv.getKrawedzZPoprzednikiem().getPoczatek();
//                        }
//                        droga += dv.getKrawedzZPoprzednikiem().getValue();
//                        exists = true;
//                        break;
//                    }
//                }
//                if (!exists) {
//                    System.out.println("Dalej nie ma takiej drogi");
//                    break;
//                }
//            }
//            if (end.equals(start)) {
//                System.out.println(start);
//                System.out.println();
//                System.out.println("Całkowita długość drogi:");
//                System.out.println(droga);
//            }
        }
    }
}


