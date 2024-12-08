package rabbitescape.engine.util;

import java.util.Date;

public class JavaDateTimeProvider implements TimeProvider
{
    public Date getDate()
    {
        return new Date();
    }
}
