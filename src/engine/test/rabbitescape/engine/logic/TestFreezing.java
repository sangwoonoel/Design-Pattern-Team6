package rabbitescape.engine.logic;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.behaviours.Freezing;

import static org.junit.Assert.assertThat;
import static rabbitescape.engine.Tools.equalTo;
import static rabbitescape.engine.textworld.TextWorldManip.createWorld;
import static rabbitescape.engine.textworld.TextWorldManip.renderWorld;

public class TestFreezing
{
    @Test
    public void test_freezing()
    {
        String[] initWorld = new String[] {
            "####",
            "    ",
            " rz ",
            "####"
        };

        String[] freezed = new String[] {
            "####",
            "    ",
            "  Z ",
            "####"
        };

        String[] melted = new String[] {
            "####",
            "    ",
            "  r>",
            "####"
        };

        World world = createWorld(initWorld);
        world.step();

        for (int i = 0; i < Freezing.FREEZING_STEPS; i++)
        {
            assertThat(
                renderWorld( world, true, false ),
                equalTo( freezed )
            );
            world.step();
        }

        world.step();

        assertThat(
            renderWorld( world, true, false ),
            equalTo( melted )
        );

    }
}
