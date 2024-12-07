package rabbitescape.engine.star;

import rabbitescape.engine.World;

public class StarCalculator
{
    private static StarCalculator instance = null;

    public static StarCalculator getInstance() {
        if (instance == null) {
            instance = new StarCalculator();
        }
        return instance;
    }

    private StarStrategy starStrategy;

    private StarCalculator() {
        starStrategy = new DefaultStarStrategy();
    }

    public StarCalculator( StarStrategy scoreStrategy) {
        this.starStrategy = scoreStrategy;
    }

    public int calculate(World world) {
        return starStrategy.calculateStar(world);
    }

    public void setStarStrategy( StarStrategy starStrategy ) {
        this.starStrategy = starStrategy;
    }
}

