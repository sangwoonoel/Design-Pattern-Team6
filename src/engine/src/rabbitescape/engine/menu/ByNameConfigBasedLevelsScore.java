package rabbitescape.engine.menu;

import rabbitescape.engine.star.BasicStarRecoder;
import rabbitescape.engine.star.StarRecoder;
import rabbitescape.engine.config.Config;

import static rabbitescape.engine.menu.ByNameConfigBasedLevelsCompleted.canonicalName;

public class ByNameConfigBasedLevelsScore implements LevelsScore{

    private final Config config;
    private final LevelsList levelsList;

    public ByNameConfigBasedLevelsScore(
            Config config, LevelsList levelsList
    )
    {
        this.config = config;
        this.levelsList = levelsList;
    }

    public void setScoreOfLevel(String levelsDir, int levelNum, int score){
        LevelsList.LevelInfo newlyCompleted =
                levelsList.inDir( levelsDir ).get( levelNum - 1 );

        String completedName = canonicalName( newlyCompleted.name );

        StarRecoder starRecoder = BasicStarRecoder.getInstance();
        starRecoder.recordStar(completedName, score);
    }
}
