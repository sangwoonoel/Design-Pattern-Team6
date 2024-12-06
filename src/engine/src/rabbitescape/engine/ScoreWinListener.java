package rabbitescape.engine;

import rabbitescape.engine.config.Config;
import rabbitescape.engine.menu.LevelsCompleted;
import rabbitescape.engine.menu.LevelsScore;

public class ScoreWinListener implements LevelWinListener {
    private final String levelsDir;
    private final int levelNumber;
    private final LevelsScore levelsScore;

    public ScoreWinListener(
            String levelsDir,
            int levelNumber,
            LevelsScore levelScore
    ) {
        this.levelsDir = levelsDir;
        this.levelNumber = levelNumber;
        this.levelsScore = levelScore;
    }

    @Override
    public void won() {
        // calculator를 호출 해야함
        int score = 3;
        //

        levelsScore.setScoreOfLevel(levelsDir, levelNumber, score);

    }

    @Override
    public void lost() {
    }
}