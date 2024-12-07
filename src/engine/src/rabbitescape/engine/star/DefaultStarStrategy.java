package rabbitescape.engine.star;

import rabbitescape.engine.World;

public class DefaultStarStrategy implements StarStrategy
{
    @Override
    public int calculateStar(World world) {
        if (world.num_saved > world.num_to_save) {
            return 3;
        }
        if (world.num_saved == world.num_to_save) {
            return 2;
        }
        return 0;
    }
}