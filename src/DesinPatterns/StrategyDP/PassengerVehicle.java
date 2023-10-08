package DesinPatterns.StrategyDP;

import DesinPatterns.StrategyDP.Strategy.DriveStrategy;
import DesinPatterns.StrategyDP.Strategy.NormalDriveStrategy;
import DesinPatterns.StrategyDP.Strategy.SpecialDriveStrategy;

public class PassengerVehicle extends Vehicle {
    PassengerVehicle(){
        super(new NormalDriveStrategy());
    }
}
