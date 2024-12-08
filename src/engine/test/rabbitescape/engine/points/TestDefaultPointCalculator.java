package rabbitescape.engine.points;

import org.junit.Assert;
import org.junit.Test;
import rabbitescape.engine.*;
import rabbitescape.engine.textworld.Comment;
import rabbitescape.engine.util.Dimension;
import rabbitescape.engine.util.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestDefaultPointCalculator
{

    @Test
    public void Points_are_based_on_num_saved()
    {
        DefaultPointCalculator calculator = new DefaultPointCalculator();

        World world = mockWorld( 3, 1, 4 );

        int points = calculator.calculate( world );

        Assert.assertEquals( 30, points );
    }

    @Test
    public void Bonus_point_when_num_waiting_is_zero()
    {
        DefaultPointCalculator calculator = new DefaultPointCalculator();

        World world = mockWorld( 3, 1, 0 );

        int points = calculator.calculate( world );

        Assert.assertEquals( 80, points );
    }



    private World mockWorld( int num_saved, int num_to_save, int num_waiting )
    {

        return new World(
            new Dimension( 5, 5 ),
            new ArrayList<Block>(),
            new ArrayList<Rabbit>(),
            new ArrayList<Thing>(),
            new HashMap<Position, Integer>(),
            new HashMap<Token.Type, Integer>(),
            "Empty World",   //name
            "",              //description
            "",              //author_name
            "",              //author_url
            new String[] {}, //hints
            new String[] {}, //solutions
            0,               //num_rabs
            num_to_save,               //num_to_save
            new int[]{4},    //rabbit_delay
            "",              //music
            num_saved,               //num_saved
            0,               //num_killed
            num_waiting,               //num_waiting
            0,               //rabbit_index_count
            false,
            new Comment[] {},
            new IgnoreWorldStatsListener(),
            VoidMarkerStyle.Style.HIGHLIGHTER
        );
    }
}
