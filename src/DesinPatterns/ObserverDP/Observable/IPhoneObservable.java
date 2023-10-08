package DesinPatterns.ObserverDP.Observable;

import DesinPatterns.ObserverDP.Observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneObservable implements StocksObservable {
    List<NotificationObserver> displayObservers = new ArrayList<>();
    int stockCount = 0;
    @Override
    public void add(NotificationObserver ds) {
        displayObservers.add(ds);
    }

    @Override
    public void remove(NotificationObserver ds) {
        displayObservers.remove(ds);
    }

    @Override
    public void notifyObserver() {
        for (NotificationObserver ds: displayObservers) {
            ds.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        if(this.stockCount==0) {
            notifyObserver();
        }
        this.stockCount+=stockCount;
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
