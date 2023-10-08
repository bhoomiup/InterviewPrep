package DesinPatterns.StrategyDP;

import DesinPatterns.StrategyDP.Strategy.DriveStrategy;
import DesinPatterns.StrategyDP.Strategy.SpecialDriveStrategy;

public class SportVehicle  extends Vehicle {
    SportVehicle(){
        super(new SpecialDriveStrategy());
    }

}
