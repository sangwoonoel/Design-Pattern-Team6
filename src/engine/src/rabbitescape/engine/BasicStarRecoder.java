package rabbitescape.engine;

import rabbitescape.engine.config.Config;
import rabbitescape.engine.config.ConfigTools;

import java.util.Map;

import static rabbitescape.engine.config.ConfigKeys.CFG_LEVELS_SCORES;

public class BasicStarRecoder implements StarRecoder
{
    private static BasicStarRecoder instance = null;

    public static void init( Config config )
    {
        if ( instance != null )
        {
            throw new IllegalStateException( "BasicStarRecoder already initialized" );
        }
        instance = new BasicStarRecoder( config );
    }

    public static BasicStarRecoder getInstance( )
    {
        if ( instance == null )
        {
            throw new IllegalStateException( "BasicStarRecoder not initialized" );
        }
        return instance;
    }

    private final Map<String, Integer> starsMap;
    private final Config config;

    private BasicStarRecoder(Config config)
    {
        this.config = config;
        this.starsMap = ConfigTools.getMap(
                this.config, CFG_LEVELS_SCORES, Integer.class );
    }
    
    public Map<String, Integer> getStarsMap()
    {
        return starsMap;
    }

    @Override
    public int getStar( String levelName )
    {
        Integer star = starsMap.get( levelName );
        return star == null ? 0 : star;
    }

    @Override
    public void recordStar( String levelName, int star )
    {
        // 현재 별과 비교하여 더 높은 기록을 저장
        int currentStar = starsMap.get(levelName) == null ? 0 : starsMap.get(levelName);

        if ( star > currentStar )
        {
            starsMap.put(levelName, star);
            saveAndUpdateConfig();
        }
    }

    private void saveAndUpdateConfig()
    {
        ConfigTools.setMap( config, CFG_LEVELS_SCORES, starsMap );
        config.save();
    }
}
