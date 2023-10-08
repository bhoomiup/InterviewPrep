package DesinPatterns.AbstractFactoryDP.Factory;

import DesinPatterns.AbstractFactoryDP.Vehicle.LuxuryVehicle1;
import DesinPatterns.AbstractFactoryDP.Vehicle.LuxuryVehicle2;
import DesinPatterns.AbstractFactoryDP.Vehicle.Vehicle;

public class LuxuryFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle(String vehicleName) {
        return switch (vehicleName){
            case "L1" -> new LuxuryVehicle1();
            case "L2" -> new LuxuryVehicle2();
            default -> null;
        };
    }
}
