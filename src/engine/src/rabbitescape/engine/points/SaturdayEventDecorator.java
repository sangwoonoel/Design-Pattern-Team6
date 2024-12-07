package rabbitescape.engine.points;

import rabbitescape.engine.World;
import rabbitescape.engine.points.PointCalculator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SaturdayEventDecorator extends PointCalculatorDecorator
{
    public SaturdayEventDecorator( PointCalculator decoratedCalculator )
    {
        super( decoratedCalculator );
    }

    @Override
    public int calculate( World world )
    {
        // 현재 날짜 확인
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("u"); // "u"는 1~7까지 요일 (월요일=1, 토요일=6)
        int dayOfWeek = Integer.parseInt(sdf.format(date));

        // 토요일은 6
        if (dayOfWeek == 6)
        {
            return decoratedCalculator.calculate( world ) * 2;
        }
        else
        {
            return decoratedCalculator.calculate( world );
        }
    }
}