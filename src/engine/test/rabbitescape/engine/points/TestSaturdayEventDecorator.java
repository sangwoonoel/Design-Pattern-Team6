package rabbitescape.engine.points;

import org.junit.Assert;
import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.util.TimeProvider;

import java.util.Date;

public class TestSaturdayEventDecorator
{

    @Test
    public void Double_point_when_saturday()
    {
        SaturdayEventDecorator decorator
            = new SaturdayEventDecorator(
            new MockPointCalculator(),
            new SaturdayTimeProvider()
        );

        int points = decorator.calculate( null );

        Assert.assertEquals( 200, points );
    }

    @Test
    public void Default_point_when_not_saturday()
    {
        SaturdayEventDecorator decorator
            = new SaturdayEventDecorator(
            new MockPointCalculator(),
            new MondayTimeProvider()
        );

        int points = decorator.calculate( null );

        Assert.assertEquals( 100, points );
    }

    private static class MockPointCalculator implements PointCalculator
    {
        @Override
        public int calculate( World world )
        {
            return 100;
        }
    }

    private static class MondayTimeProvider implements TimeProvider
    {
        @Override
        public Date getDate()
        {
            return new Date(2024, 11, 8);
        }
    }

    private static class SaturdayTimeProvider implements TimeProvider
    {
        @Override
        public Date getDate()
        {
            return new Date(2024, 11, 6);
        }
    }
}
