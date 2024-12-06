package rabbitescape.engine;

import rabbitescape.engine.config.Config;
import rabbitescape.engine.config.ConfigTools;

import java.util.Map;

import static rabbitescape.engine.config.ConfigKeys.CFG_LEVELS_SCORES;

public class BasicStarRecoder implements StarRecoder {
    private Map<String, Integer> starsMap;
    private Config config;
    
    public BasicStarRecoder(Config config) {
        this.config = config;
        this.starsMap = ConfigTools.getMap(
                this.config, CFG_LEVELS_SCORES, Integer.class );
    }
    
    public Map<String, Integer> getStarsMap() {
        return starsMap;
    }
    
    public int getStar(String levelName){
        return starsMap.get(levelName);
    }

    public void record(String levelName, int star) {
        // 현재 별과 비교하여 더 높은 기록을 저장
        int currentStar = starsMap.getOrDefault(levelName, 0);
        if (star > currentStar) {
            starsMap.put(levelName, star);
            saveAndUpdateConfig();
        }
    }

    private void saveAndUpdateConfig() {
        ConfigTools.setMap(config, CFG_LEVELS_SCORES, starsMap);
        config.save();
    }
}
