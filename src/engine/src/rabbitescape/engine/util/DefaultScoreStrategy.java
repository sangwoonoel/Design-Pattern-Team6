package rabbitescape.engine.util;

import rabbitescape.engine.World;

public class DefaultScoreStrategy implements ScoreStrategy
{
    @Override
    public int calculateScore(World world) {
        if (world.num_saved > world.num_to_save) {
            return 3;
        }
        if (world.num_saved == world.num_to_save) {
            return 2;
        }
        return 1;
    }
}