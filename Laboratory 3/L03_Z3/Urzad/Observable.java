package Urzad;

import Observers.Observer;

public interface Observable {

    void registerObserver(Observer observer);

    void removeObserver();

    void notifyObservers();
}
