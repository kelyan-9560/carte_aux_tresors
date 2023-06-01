import exceptions.CoordinateException;
import exceptions.MapSizeExceptions;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static MapSize parseMapSize(List<String> lineSplit) {
        int nbRows;
        try {
            nbRows = Integer.parseInt(lineSplit.get(1));
        } catch (Exception e) {
            throw new MapSizeExceptions("Map size X must be a number");
        }

        int nbColumns;
        try {
            nbColumns = Integer.parseInt(lineSplit.get(2));
        } catch (Exception e) {
            throw new MapSizeExceptions("Map size Y must be a number");
        }

        return new MapSize(nbRows, nbColumns);
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
        int x;
        try {
            x = Integer.parseInt(lineSplit.get(1));
        } catch (Exception e) {
            throw new CoordinateException("Map size X must be a number");
        }

        int y;
        try {
            y = Integer.parseInt(lineSplit.get(2));
        } catch (Exception e) {
            throw new CoordinateException("Map size Y must be a number");
        }

        return new Coordinate(x, y);
    }

    public static List<Instruction> parseInstructions(List<String> lineSplit) {
        List<Instruction> instructions = new ArrayList<>();
        for (char instruction : lineSplit.get(5).toCharArray()) {
            instructions.add(new Instruction(String.valueOf(instruction)));
        }
        return instructions;
    }

}
