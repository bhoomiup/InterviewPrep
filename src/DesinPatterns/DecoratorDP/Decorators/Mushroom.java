package DesinPatterns.DecoratorDP.Decorators;

import DesinPatterns.DecoratorDP.Base.BasePizza;

public class Mushroom extends ToppingsDecorator{
    BasePizza bp;

    public Mushroom(BasePizza bp){
        this.bp = bp;
    }
    @Override
    public int cost() {
        return bp.cost()+10;
    }
}
