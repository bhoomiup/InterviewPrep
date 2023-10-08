package DesinPatterns.DecoratorDP.Decorators;

import DesinPatterns.DecoratorDP.Base.BasePizza;

public class ExtraCheese extends ToppingsDecorator{
    BasePizza bp;

    public ExtraCheese(BasePizza bp){
        this.bp = bp;
    }
    @Override
    public int cost() {
        return bp.cost()+20;
    }
}
