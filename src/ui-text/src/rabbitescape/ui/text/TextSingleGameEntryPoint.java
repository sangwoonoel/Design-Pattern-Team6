package rabbitescape.ui.text;

import java.io.PrintStream;
import java.util.Locale;

import rabbitescape.engine.LevelWinListener;
import rabbitescape.engine.World;
import rabbitescape.engine.i18n.Translation;
import rabbitescape.engine.util.FileSystem;
import rabbitescape.engine.util.RealFileSystem;
import rabbitescape.render.GameLaunch;
import rabbitescape.render.SingleGameEntryPoint;

import rabbitescape.engine.points.PointAwarder;

public class TextSingleGameEntryPoint extends SingleGameEntryPoint
{
    public TextSingleGameEntryPoint( 
        FileSystem fs, 
        PrintStream out,          
        Locale locale,
        PointAwarder pointAwarder // 추가
    )
    {
        super( fs, out, locale, pointAwarder );
    }

    public static void entryPoint( String[] args )
    {
        Locale locale = Locale.getDefault();
        Translation.init( locale );

        PointAwarder pointAwarder = new PointAwarder(TextConfigSetup.createConfig());

        SingleGameEntryPoint m = new TextSingleGameEntryPoint(
            new RealFileSystem(), 
            System.out, 
            locale,
            pointAwarder
        );

        m.run( args );
    }

    @Override
    public GameLaunch createGameLaunch( 
        World world,
        LevelWinListener winListener 
    )
    {
        return new TextGameLaunch(
            world,
            winListener,
            new Terminal( System.in, System.out, Locale.getDefault() )
        );
    }

    @Override
    protected int calculatePoints(World world)
    {
        // 임시
        return world.num_saved;
    }
}
