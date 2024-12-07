package rabbitescape.engine.star;

import rabbitescape.engine.Token;
import rabbitescape.engine.World;

public class DiggingPracticeStarStrategy implements StarStrategy
{
    @Override
    public int calculateStar( World world )
    {
        if ( world.num_saved == 3 && world.abilities.get( Token.Type.dig ) == 4 )
        {
            return 3;
        }
        else if ( world.num_saved > world.num_to_save && world.num_saved <= 3 )
        {
            return 2;
        }
        else if ( world.num_saved == world.num_to_save )
        {
            return 1;
        }

        return 0;
    }
}
