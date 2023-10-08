package DesinPatterns.ObserverDP.Observable;

import DesinPatterns.ObserverDP.Observer.NotificationObserver;

public interface StocksObservable {
    void add(NotificationObserver ds);
    void remove(NotificationObserver ds);
    void notifyObserver();
    void setStockCount(int temp);
    int getStockCount();
}
