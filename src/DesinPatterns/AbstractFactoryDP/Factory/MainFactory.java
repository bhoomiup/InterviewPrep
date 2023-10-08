package DesinPatterns.AbstractFactoryDP.Factory;


public class MainFactory {
    public VehicleFactory getVehicleFactory(String factoryName){
        return switch (factoryName){
            case "L" -> new LuxuryFactory();
            case "O" -> new OrdinaryFactory();
            default -> null;
        };
    }
}
