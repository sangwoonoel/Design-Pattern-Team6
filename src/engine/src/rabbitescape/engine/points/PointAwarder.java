package rabbitescape.engine.points;

import java.util.Map;

import rabbitescape.engine.World;
import rabbitescape.engine.config.Config;
import rabbitescape.engine.config.ConfigTools;

public class PointAwarder {
    private final PointManager pointManager; // PointManager 객체 추가
    private final PointCalculator pointCalculator;

    public PointAwarder(Config config) {
        this.pointCalculator = new DefaultPointCalculator();
        this.pointManager = new PointManager( config );
    }

    // 점수 기록 (전략 패턴 적용 가능)
    public int recordPoint( World world ) {
        // PointManager를 사용하여 점수 추가
        int points = pointCalculator.calculate( world );
        pointManager.add(points);
        return points;
    }
}