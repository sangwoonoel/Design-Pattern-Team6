package rabbitescape.render.util;


public class StarStringBuilder
{
    public StarStringBuilder() { }

    public static String getStars( int filled, int max )
    {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < filled; i++ )
        {
            sb.append( "⭑" );
        }
        for ( int i = filled; i < max; i++ )
        {
            sb.append( "☆" );
        }
        return sb.toString();
    }
}
