package DesinPatterns.ObserverDP.Observer;

import DesinPatterns.ObserverDP.Observable.StocksObservable;

public class EmailNotiObserver implements NotificationObserver {

    StocksObservable wsObservable;
    String email;
    public EmailNotiObserver(String email, StocksObservable wsObservable){
        this.email = email;
        this.wsObservable = wsObservable;
    }
    @Override
    public void update() {
        this.sendEMail();
    }

    void sendEMail(){
        System.out.println("Email sent to "+this.email);
    }
}
