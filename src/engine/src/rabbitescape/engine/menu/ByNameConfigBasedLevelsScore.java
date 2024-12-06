package rabbitescape.engine.menu;

import rabbitescape.engine.BasicStarRecoder;
import rabbitescape.engine.StarRecoder;
import rabbitescape.engine.config.Config;
import rabbitescape.engine.config.ConfigTools;

import java.util.Map;

import static rabbitescape.engine.config.ConfigKeys.CFG_LEVELS_SCORES;
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

        StarRecoder starRecoder = new BasicStarRecoder(config);
        starRecoder.record(completedName, score);
    }
}
