package DesinPatterns.AbstractFactoryDP.Factory;

import DesinPatterns.AbstractFactoryDP.Vehicle.*;

public class OrdinaryFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle(String vehicleName) {
        return switch (vehicleName){
            case "O1" -> new OrdinaryVehicle1();
            case "O2" -> new OrdinaryVehicle2();
            default -> null;
        };
    }
}
