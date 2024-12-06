package rabbitescape.engine.config;

import static rabbitescape.engine.config.ConfigKeys.*;

public class StandardConfigSchema
{
    /**
     * Set config schema values that are standard across all platforms.
     */
    public static void setSchema( ConfigSchema definition )
    {
        definition.set(
            CFG_LEVELS_COMPLETED,
            "[]",
            "Which level you have got to in each level set."
        );

        definition.set(
            CFG_DEBUG_PRINT_STATES,
            String.valueOf( false ),
            "Rabbit states are printed to System.out."
        );

        definition.set(
            CFG_WATER_DYN_CONTENTS_PER_PARTICLE,
            String.valueOf( true ),
            "Particle count is auto-reduced for struggling hardware."
        );

        definition.set(
            CFG_WATER_CONTENTS_PER_PARTICLE,
            String.valueOf( 4 ),
            "Smaller values lead to more particles"
        );

        definition.set(
                CFG_LEVELS_SCORES,
                "{}",
                "Scores for each level in the game."
         );
      
        definition.set(
                CFG_TOTAL_POINTS,
                "0", // Default total points
                "The total points earned by the player."
        );

        // 설정 파일에 point 관련 키가 없을 경우 지정될 기본값
        definition.set(
                CFG_LEVEL_POINTS,
                "{}", // Default as an empty JSON
                "Points earned for each level as a JSON map."
        );
    }

}
