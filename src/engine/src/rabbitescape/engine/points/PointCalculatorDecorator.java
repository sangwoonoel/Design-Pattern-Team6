package rabbitescape.engine.points;

import rabbitescape.engine.World;

public abstract class PointCalculatorDecorator implements PointCalculator
{
    protected PointCalculator decoratedCalculator;

    public PointCalculatorDecorator( PointCalculator decoratedCalculator )
    {
        this.decoratedCalculator = decoratedCalculator;
    }

    public abstract int calculate( World world );
}
