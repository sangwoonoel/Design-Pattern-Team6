package rabbitescape.engine.star;

import rabbitescape.engine.World;

import java.util.HashMap;
import java.util.Map;

public class StarCalculator
{
    private static StarCalculator instance = null;

    private static Map<String, StarStrategy> strategies = new HashMap<>();

    public static StarCalculator getInstance() {
        if (instance == null) {
            instance = new StarCalculator();
        }
        return instance;
    }

    private StarStrategy defaultStarStrategy;

    private StarCalculator() {
        defaultStarStrategy = new DefaultStarStrategy();
        strategies.put("Digging practice", new DiggingPracticeStarStrategy());
    }

    public int calculate(World world) {
        StarStrategy strategy = strategies.get( world.name );

        if (strategy == null)
        {
            strategy = defaultStarStrategy;
        }

        return strategy.calculateStar(world);
    }
}

