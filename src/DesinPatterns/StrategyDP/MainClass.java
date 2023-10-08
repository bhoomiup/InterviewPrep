package DesinPatterns.StrategyDP;

import DesinPatterns.StrategyDP.Strategy.NormalDriveStrategy;
import DesinPatterns.StrategyDP.Strategy.SpecialDriveStrategy;

public class MainClass {

    public static void main(String[] args) {
        Vehicle sv = new SportVehicle();
        Vehicle pv = new PassengerVehicle();
        sv.drive();
        pv.drive();
    }
}
