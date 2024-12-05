package rabbitescape.engine.behaviours;

import rabbitescape.engine.*;

import java.util.Map;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.Token.Type.freeze;

public class Freezing extends Behaviour
{
    public static final int FREEZING_STEPS = 3;
    int stepsOfFreezing;

    @Override
    public void cancel()
    {
        stepsOfFreezing = 0;
    }

    @Override
    public boolean checkTriggered( Rabbit rabbit, World world )
    {
        BehaviourTools t = new BehaviourTools( rabbit, world );
        return t.pickUpToken( freeze );
    }

    @Override
    public ChangeDescription.State newState( BehaviourTools t, boolean triggered )
    {
        if ( !triggered && stepsOfFreezing == 0 )
        {
            return null;
        }

        if ( triggered )
        {
            stepsOfFreezing = FREEZING_STEPS; // Freezing 지속 시간
            return RABBIT_FREEZING;
        }

        if ( stepsOfFreezing > 0 )
        {
            stepsOfFreezing--;
            return RABBIT_FREEZING;
        }

        return null;
    }

    @Override
    public boolean behave(
        World world,
        Rabbit rabbit,
        ChangeDescription.State state
    )
    {
        // Freezing 상태에 대한 효과 적용 (예: 움직임 중지, 얼어붙는 효과)
        return state == RABBIT_FREEZING && stepsOfFreezing > 0;
    }

    @Override
    public void saveState( Map<String, String> saveState )
    {
        BehaviourState.addToStateIfGtZero(
            saveState,
            "Freezing.stepsOfFreezing",
            stepsOfFreezing
        );
    }

    @Override
    public void restoreFromState( Map<String, String> saveState )
    {
        stepsOfFreezing = BehaviourState.restoreFromState(
            saveState,
            "Freezing.stepsOfFreezing",
            stepsOfFreezing
        );
    }
}
