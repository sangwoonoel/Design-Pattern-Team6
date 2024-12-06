package rabbitescape.engine.points;

import java.util.Map;
import rabbitescape.engine.config.Config;
import rabbitescape.engine.config.ConfigTools;

public class PointAwarder {
    private final Config config;
    private final PointManager pointManager; // PointManager 객체 추가

    public PointAwarder(Config config) {
        this.config = config;

        // Config에서 초기 총 점수를 로드하거나 기본값으로 설정
        int initialPoints;
        try {
            initialPoints = ConfigTools.getInt(config, "total.points");
        } catch (Exception e) {
            initialPoints = 0; // 기본값 설정
        }

        this.pointManager = new PointManager(initialPoints);
    }

    // 점수 기록 (전략 패턴 적용 가능)
    public void record(String levelName, int points) {
        // PointManager를 사용하여 점수 추가
        pointManager.add(points);

        // 총 점수 업데이트
        ConfigTools.setInt(config, "total.points", pointManager.getPoints());

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
        return pointManager.getPoints(); // PointManager에서 직접 가져오기
    }

    // 특정 레벨 점수 가져오기
    public int getLevelPoints(String levelName) {
        String levelPointsJson = ConfigTools.getString(config, "level.points");
        Map<String, Integer> levelPoints = ConfigTools.stringToMap(levelPointsJson, Integer.class);
        return levelPoints.getOrDefault(levelName, 0);
    }

    // 포인트 소비
    public boolean consumePoints(int points) {
        boolean success = pointManager.consume(points);
        if (success) {
            ConfigTools.setInt(config, "total.points", pointManager.getPoints());
            config.save(); // 소비한 결과를 저장
        }
        return success;
    }
}