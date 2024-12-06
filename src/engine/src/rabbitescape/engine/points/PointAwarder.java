package rabbitescape.engine.points;

import java.util.Map;
import rabbitescape.engine.config.Config;
import rabbitescape.engine.config.ConfigTools;

public class PointAwarder {
    private final Config config;

    public PointAwarder(Config config) {
        this.config = config;
    }

    // 점수 기록 (전략 패턴 적용 가능)
    public void record(String levelName, int points) {
        // 총 점수 업데이트
        int totalPoints = ConfigTools.getInt(config, "total.points");
        totalPoints += points;
        ConfigTools.setInt(config, "total.points", totalPoints);

        // 레벨별 점수 업데이트
        String levelPointsJson = ConfigTools.getString(config, "level.points");
        Map<String, Integer> levelPoints = ConfigTools.stringToMap(levelPointsJson, Integer.class);
        levelPoints.put(levelName, levelPoints.getOrDefault(levelName, 0) + points);
        ConfigTools.setMap(config, "level.points", levelPoints);

        // 설정 저장
        config.save();
    }

    // 총 점수 가져오기
    public int getTotalPoints() {
        return ConfigTools.getInt(config, "total.points");
    }

    // 특정 레벨 점수 가져오기
    public int getLevelPoints(String levelName) {
        String levelPointsJson = ConfigTools.getString(config, "level.points");
        Map<String, Integer> levelPoints = ConfigTools.stringToMap(levelPointsJson, Integer.class);
        return levelPoints.getOrDefault(levelName, 0);
    }
}