import models.Adventurer;
import models.Coordinate;
import models.MapSize;
import models.Orientation;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static MapSize parseMapSize(List<String> lineSplit) {
        return new MapSize(Integer.parseInt(lineSplit.get(1)), Integer.parseInt(lineSplit.get(2)));
    }

    public static Adventurer parseAdventurer(List<String> lineSplit) {
        return new Adventurer(
                lineSplit.get(1),
                new Coordinate(Integer.parseInt(lineSplit.get(2)), Integer.parseInt(lineSplit.get(3))),
                new Orientation(lineSplit.get(4)),
                new ArrayList<>()
        );
    }

    public static Coordinate parseCoordinate(List<String> lineSplit) {
        return new Coordinate(
                Integer.parseInt(lineSplit.get(1)),
                Integer.parseInt(lineSplit.get(2))
        );
    }

    public static List<String> parseInstructions(List<String> lineSplit) {
        return List.of(lineSplit.get(5).split(""));
    }

}
