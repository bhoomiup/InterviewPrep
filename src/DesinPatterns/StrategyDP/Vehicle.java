package DesinPatterns.StrategyDP;

import DesinPatterns.StrategyDP.Strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy ds;
    Vehicle(DriveStrategy ds){
        this.ds = ds;
    }

    public void drive() {
        this.ds.drive();
    }
}
