package rabbitescape.engine.points;

public class PointManager {
    private int points;

    // 생성자
    public PointManager(int initialPoints) {
        this.points = initialPoints;
    }

    // 포인트를 추가
    public void add(int point) {
        if (point < 0) {
            throw new IllegalArgumentException("Cannot add negative points.");
        }
        this.points += point;
        System.out.println("Added " + point + " points. Total: " + points);
    }

    // 포인트 사용
    public boolean consume(int point) {
        if (point < 0) {
            throw new IllegalArgumentException("Cannot consume negative points.");
        }

        if (points >= point) {
            this.points -= point;
            System.out.println("Consumed " + point + " points. Remaining: " + points);
            return true; // 성공
        } else {
            System.out.println("Not enough points to consume. Required: " + point + ", Available: " + points);
            return false; // 소비
        }
    }

    // 현재 포인트를 반환하는 메서드
    public int getPoints() {
        return points;
    }
}
