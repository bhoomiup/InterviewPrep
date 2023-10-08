package DesinPatterns.AbstractFactoryDP;

import DesinPatterns.AbstractFactoryDP.Factory.MainFactory;
import DesinPatterns.AbstractFactoryDP.Vehicle.Vehicle;

public class MainClass {

    public static void main(String[] args) {
        MainFactory mainFactory = new MainFactory();
        Vehicle v = mainFactory.getVehicleFactory("O").getVehicle("O1");
        System.out.println("The cost of the vehicle is -"+v.cost());
    }
}
