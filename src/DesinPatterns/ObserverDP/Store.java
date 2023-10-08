package DesinPatterns.ObserverDP;

import DesinPatterns.ObserverDP.Observable.IPhoneObservable;
import DesinPatterns.ObserverDP.Observable.StocksObservable;
import DesinPatterns.ObserverDP.Observer.EmailNotiObserver;
import DesinPatterns.ObserverDP.Observer.PushNotiObserver;

public class Store {

    public static void main(String[] args) {
        StocksObservable s = new IPhoneObservable();
        s.add(new EmailNotiObserver("abc@gmail.comm", s));
        s.add(new PushNotiObserver("123225435", s));
        s.setStockCount(3);
    }
}
