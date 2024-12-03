package rabbitescape.engine.util;

import rabbitescape.engine.World;

public class ScoreCalculator
{
    private ScoreStrategy scoreStrategy;
    public ScoreCalculator() {
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

