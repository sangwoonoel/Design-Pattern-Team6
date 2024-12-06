package rabbitescape.engine;

import java.util.Map;

public interface StarRecoder {
    public void record(String levelName, int star);
    public Map<String, Integer> getStarsMap();
    public int getStar(String levelName);
}
