package rabbitescape.engine.util;

import rabbitescape.engine.World;

public class ScoreCalculator
{
    private static ScoreCalculator instance = null;

    public static ScoreCalculator getInstance() {
        if (instance == null) {
            instance = new ScoreCalculator();
        }
        return instance;
    }

    private ScoreStrategy scoreStrategy;

    private ScoreCalculator() {
        scoreStrategy = new DefaultScoreStrategy();
    }

    public ScoreCalculator(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }

    public int calculate(World world) {
        return scoreStrategy.calculateScore(world);
    }

    public void setScoreStrategy(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }
}

