package rabbitescape.render;

import static rabbitescape.engine.util.Util.*;

import java.io.PrintStream;
import java.util.Locale;

import rabbitescape.engine.*;
import rabbitescape.engine.util.FileSystem;

import rabbitescape.engine.points.PointAwarder;
import rabbitescape.engine.util.ScoreCalculator;

public abstract class SingleGameEntryPoint
{
    public abstract GameLaunch createGameLaunch(
        World world, LevelWinListener winListener );

    private static final int SUCCESS             = 0;
    private static final int FAILED_TO_LOAD_FILE = 1;
    private static final int UNKNOWN_ERROR       = 42;

    private final FileSystem fs;
    public final PrintStream out;
    private final Locale locale;
    private final PointAwarder pointAwarder;
    private final StarRecoder starRecoder;
    private final ScoreCalculator scoreCalculator = new ScoreCalculator();

    public SingleGameEntryPoint( FileSystem fs, PrintStream out, Locale locale, PointAwarder pointAwarder, StarRecoder starRecoder )
    {
        this.fs = fs;
        this.out = out;
        this.locale = locale;
        this.pointAwarder = pointAwarder;
        this.starRecoder = starRecoder;
    }

    public void run( String[] args )
    {
        int status = launchGame( args, new IgnoreLevelWinListener() );
        System.exit( status );
    }

    public int launchGame( String[] args, LevelWinListener winListener )
    {
        reAssert( args.length >= 1 );

        try
        {
            String levelName = args[0];

            World world = new LoadWorldFile( fs ).load(
                new IgnoreWorldStatsListener(), levelName );

            GameLaunch gameLaunch = createGameLaunch( world, winListener );

            gameLaunch.run( args );


            int calculatedStar = scoreCalculator.calculate( world );

            int beforeStar = starRecoder.getStar( levelName );

            System.out.println( "[DEBUG] BeforeStar = " + beforeStar );

            System.out.println( "[DEBUG] CalculatedStar = " + calculatedStar );

            starRecoder.recordStar( levelName , calculatedStar );

            int newSTar = starRecoder.getStar( levelName );

            System.out.println( "[DEBUG] NewStar = " + newSTar );

            int recordedPoint = pointAwarder.recordPoint(
                world,
                levelName
            );// 레벨별 및 총 점수 업데이트

            out.println("[DEBUG] Points for level '" + levelName + "': " + recordedPoint);
            out.println("[DEBUG] Total points: " + pointAwarder.getTotalPoints());

            gameLaunch.showResult(  new GameResultMeta( newSTar, recordedPoint ) );


        }
        catch( LoadWorldFile.Failed e )
        {
            out.println( e.translate( locale ) );
            return FAILED_TO_LOAD_FILE;
        }
        catch( Throwable e )
        {
            e.printStackTrace();
            return UNKNOWN_ERROR;
        }

        return SUCCESS;
    }
}
