package rabbitescape.engine.points;

import rabbitescape.engine.World;

public class PointAwarder {

    private final PointManager pointManager; // PointManager 객체 추가
    private final PointCalculator pointCalculator;

    public PointAwarder()
    {
        this.pointCalculator = new DefaultPointCalculator();
        this.pointManager = PointManager.getInstance();
    }

    // 점수 기록 (전략 패턴 적용 가능)
    public int recordPoint( World world )
    {
        int points = pointCalculator.calculate( world );
        pointManager.add(points);
        return points;
    }
}