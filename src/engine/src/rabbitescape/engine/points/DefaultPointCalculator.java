package rabbitescape.engine.points;

import rabbitescape.engine.World;

public class DefaultPointCalculator implements PointCalculator
{
    @Override
    public int calculate( World world )
    {
        int pointsFromSavedRabbits = world.num_saved * 10;
        int pointsFromRemainingRabbits = world.numRabbitsOut() * 5;

        // 추가 보너스: 토끼가 모두 대기 없이 도착했다면 보너스
        int bonusPoints = (world.num_waiting == 0) ? 50 : 0;

        return pointsFromSavedRabbits + pointsFromRemainingRabbits + bonusPoints;
    }
}
