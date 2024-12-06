package rabbitescape.engine;

import java.util.Map;

public interface StarRecoder {
    void recordStar(String levelName, int star);
    Map<String, Integer> getStarsMap();
    int getStar(String levelName);
}
