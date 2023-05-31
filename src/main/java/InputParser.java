import models.*;

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
                new ArrayList<>(),
                parseInstructions(lineSplit));
    }

    public static Coordinate parseCoordinate(List<String> lineSplit) {
        return new Coordinate(
                Integer.parseInt(lineSplit.get(1)),
                Integer.parseInt(lineSplit.get(2))
        );
    }

    public static List<Instruction> parseInstructions(List<String> lineSplit) {
        List<Instruction> instructions = new ArrayList<>();
        for (char instruction : lineSplit.get(5).toCharArray()) {
            instructions.add(new Instruction(String.valueOf(instruction)));
        }
        return instructions;
    }

}
