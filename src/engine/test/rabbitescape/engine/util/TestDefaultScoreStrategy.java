package rabbitescape.engine.util;

import org.junit.Assert;
import org.junit.Test;
import rabbitescape.engine.*;
import rabbitescape.engine.star.DefaultStarStrategy;
import rabbitescape.engine.textworld.Comment;

import java.util.ArrayList;
import java.util.HashMap;

public class TestDefaultScoreStrategy
{
    @Test
    public void Three_stars_when_num_saved_is_larger_than_num_to_save()
    {
        DefaultStarStrategy strategy = new DefaultStarStrategy();

        World world = mockWorld( 10, 3 );

        int score = strategy.calculateStar( world );

        Assert.assertEquals( 3, score );
    }

    @Test
    public void Two_stars_when_num_saved_is_equal_to_num_to_save()
    {
        DefaultStarStrategy strategy = new DefaultStarStrategy();

        World world = mockWorld( 3, 3 );

        int score = strategy.calculateStar( world );

        Assert.assertEquals( 2, score );
    }

    @Test
    public void One_star_when_num_saved_is_less_than_num_to_save()
    {
        DefaultStarStrategy strategy = new DefaultStarStrategy();

        World world = mockWorld( 0, 3 );

        int score = strategy.calculateStar( world );

        Assert.assertEquals( 1, score );
    }

    private World mockWorld(int num_saved, int num_to_save)
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
            0,               //num_waiting
            0,               //rabbit_index_count
            false,
            new Comment[] {},
            new IgnoreWorldStatsListener(),
            VoidMarkerStyle.Style.HIGHLIGHTER
        );
    }
}
