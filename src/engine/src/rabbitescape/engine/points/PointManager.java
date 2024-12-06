public class PointManager {
    // 포인트를 저장하는 필드
    private int points;

    // 생성자
    public PointManager(int initialPoints) {
        this.points = initialPoints;
    }

    // 포인트를 추가하는 메서드
    public void add(int point) {
        if (point < 0) {
            throw new IllegalArgumentException("Cannot add negative points.");
        }
        this.points += point;
        System.out.println("Added " + point + " points. Total: " + points);
    }

    // 포인트를 소비하는 메서드
    public boolean consume(int point) {
        if (point < 0) {
            throw new IllegalArgumentException("Cannot consume negative points.");
        }

        if (points >= point) {
            this.points -= point;
            System.out.println("Consumed " + point + " points. Remaining: " + points);
            return true; // 성공적으로 소비
        } else {
            System.out.println("Not enough points to consume. Required: " + point + ", Available: " + points);
            return false; // 소비 실패
        }
    }

    // 현재 포인트를 반환하는 메서드
    public int getPoints() {
        return points;
    }
}
