package rabbitescape.engine.points;

import rabbitescape.engine.config.Config;
import rabbitescape.engine.config.ConfigTools;

public class PointManager {

    private static final String TOTAL_POINTS = "total.points";

    private int point;
    private final Config config;

    public PointManager( Config config )
    {
        this.config = config;
        try {
            this.point = ConfigTools.getInt( config, TOTAL_POINTS );
        } catch ( Exception e ) {
            this.point = 0;
        }
    }

    public void add(int amount) {
        if (amount < 0)
        {
            throw new IllegalArgumentException("Cannot add negative points.");
        }

        this.point += amount;

        save( point );

        System.out.println("[DEBUG] Added " + amount + " points. Total: " + point);
    }

    // 포인트 사용
    public boolean consume(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot consume negative points.");
        }

        if (point >= amount) {
            this.point -= amount;
            System.out.println("[DEBUG] Consumed " + amount + " points. Remaining: " + point);
            save( point );
            return true; // 성공
        } else {
            System.out.println("[DEBUG] Failed to consume " + amount + " points. Remaining: " + point);
            return false; // 소비
        }
    }

    // 현재 포인트를 반환하는 메서드
    public int getPoints() {
        return point;
    }

    private void save(int p)
    {
        ConfigTools.setInt( config, TOTAL_POINTS, p );
        config.save();
    }
}
