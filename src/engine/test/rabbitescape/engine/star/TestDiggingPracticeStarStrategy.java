package rabbitescape.engine.star;

import org.junit.Assert;
import org.junit.Test;
import rabbitescape.engine.*;
import rabbitescape.engine.textworld.Comment;
import rabbitescape.engine.util.Dimension;
import rabbitescape.engine.util.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestDiggingPracticeStarStrategy
{

    @Test
    public void Three_stars_when_only_use_one_digging_and_save_all_rabbits()
    {
        DiggingPracticeStarStrategy strategy = new DiggingPracticeStarStrategy();

        World world = mockWorld( 3, 1, 4 );

        int score = strategy.calculateStar( world );

        Assert.assertEquals( 3, score );
    }

    @Test
    public void Two_stars_when_more_digging_token_used_than_needed()
    {
        DiggingPracticeStarStrategy strategy = new DiggingPracticeStarStrategy();

        World world = mockWorld( 3, 1, 3 );

        int score = strategy.calculateStar( world );

        Assert.assertEquals( 2, score );
    }

    @Test
    public void One_star_when_not_enough_rabbit_saved()
    {
        DiggingPracticeStarStrategy strategy = new DiggingPracticeStarStrategy();

        World world = mockWorld( 1, 1, 3 );

        int score = strategy.calculateStar( world );

        Assert.assertEquals( 1, score );
    }

    private World mockWorld( int num_saved, int num_to_save, int num_digging_left )
    {

        Map<Token.Type, Integer> abilities = new HashMap<>();
        abilities.put( Token.Type.dig, num_digging_left );

        return new World(
            new Dimension( 5, 5 ),
            new ArrayList<Block>(),
            new ArrayList<Rabbit>(),
            new ArrayList<Thing>(),
            new HashMap<Position, Integer>(),
            abilities,
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
