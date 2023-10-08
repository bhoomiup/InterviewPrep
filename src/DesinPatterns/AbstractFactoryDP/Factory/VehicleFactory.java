package DesinPatterns.AbstractFactoryDP.Factory;

import DesinPatterns.AbstractFactoryDP.Vehicle.Vehicle;

public interface VehicleFactory {
    Vehicle getVehicle(String vehicleName);
}
