package rabbitescape.engine.points;

import org.junit.Assert;
import org.junit.Test;
import rabbitescape.engine.config.*;
import rabbitescape.engine.util.FakeFileSystem;
import rabbitescape.engine.util.FileSystem;

public class TestPointManager
{

    @Test
    public void Consume_fail_when_not_enough_point_to_consume()
    {
        PointManager.init( createTestConfig() );

        PointManager pointManager = PointManager.getInstance();

        boolean isConsumed = pointManager.consume( 1000 );

        Assert.assertEquals( false, isConsumed );
    }

    private Config createTestConfig()
    {
        ConfigSchema schema = new ConfigSchema();
        FileSystem fs = new FakeFileSystem();
        ConfigFile storage = new ConfigFile(fs, "/test/config.properties");
        return new Config(schema, storage, RealConfigUpgrades.realConfigUpgrades());
    }
}
