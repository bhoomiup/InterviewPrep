package DesinPatterns.DecoratorDP;

import DesinPatterns.DecoratorDP.Base.BasePizza;
import DesinPatterns.DecoratorDP.Base.VegDelight;
import DesinPatterns.DecoratorDP.Decorators.ExtraCheese;
import DesinPatterns.DecoratorDP.Decorators.Mushroom;

public class OrderPizza {
    public static void main(String[] args) {
        BasePizza b = new Mushroom(new ExtraCheese(new VegDelight()));
        System.out.println("Cost of pizza -"+b.cost());
    }
}
