package rabbitescape.engine.star;

import rabbitescape.engine.World;

public class HardStarStrategy implements StarStrategy
{
    @Override
    public int calculateStar(World world) {
        if (world.num_rabbits == world.num_to_save) {
            return 3;
        }
        if (world.num_saved > world.num_to_save) {
            return 2;
        }
        return 1;
    }
}