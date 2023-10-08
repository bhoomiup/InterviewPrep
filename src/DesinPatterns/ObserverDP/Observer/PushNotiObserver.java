package DesinPatterns.ObserverDP.Observer;

import DesinPatterns.ObserverDP.Observable.StocksObservable;

public class PushNotiObserver implements NotificationObserver {
    StocksObservable wsObservable;
    String phoneNumber;
    public PushNotiObserver(String phoneNumber, StocksObservable wsObservable){
        this.phoneNumber = phoneNumber;
        this.wsObservable = wsObservable;
    }
    @Override
    public void update() {
        this.sendMsg();
    }

    void sendMsg(){
        System.out.println("Msg sent "+phoneNumber);
    }
}
