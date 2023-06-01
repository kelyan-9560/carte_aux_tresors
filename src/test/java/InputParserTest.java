import exceptions.MapSizeExceptions;
import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("parse : should return a the map size from a list of string")
    void should_return_a_map_size() {
        var input = List.of("C", "3", "4");
        var mapSize = InputParser.parseMapSize(input);
        assertEquals(mapSize, new MapSize(3, 4));
    }

    @Test
    @DisplayName("Should return an Coordinate() from a list of string")
    void should_return_an_coordinate() {
        var input = List.of("M", "1", "4");
        var coordinateParsed = InputParser.parseCoordinate(input);
        assertEquals(coordinateParsed, new Coordinate(1, 4));
    }

    @Test
    @DisplayName("Should return a list of Instruction() from a list of string")
    void should_return_instructions() {
        var input = List.of("A", "Kelyan", "1", "1", "N", "ADG");
        var instructionsParsed = InputParser.parseInstructions(input);
        var instructionsExpected = List.of(
                new Instruction("A"),
                new Instruction("D"),
                new Instruction("G")
        );
        assertEquals(instructionsParsed, instructionsExpected);
    }

    @Test
    @DisplayName("Should throw an exception when ndRows of the map size is not a number")
    void should_throw_an_exception_when_ndRows_of_the_map_size_is_not_a_number() {
        var input = List.of("C", "A", "4");
        assertThrows(MapSizeExceptions.class, () -> InputParser.parseMapSize(input));
    }

    @Test
    @DisplayName("Should throw an exception when nbColumns of the map size is not a number")
    void should_throw_an_exception_when_nbColumns_of_the_map_size_is_not_a_number() {
        var input = List.of("C", "3", "Z");
        assertThrows(MapSizeExceptions.class, () -> InputParser.parseMapSize(input));
    }

    @Test
    @DisplayName("Should throw an exception when x of the coordinate is not a number")
    void should_throw_an_exception_when_x_of_the_coordinate_is_not_a_number() {
        var input = List.of("M", "A", "4");
        assertThrows(MapSizeExceptions.class, () -> InputParser.parseMapSize(input));
    }

    @Test
    @DisplayName("Should throw an exception when y of the coordinate is not a number")
    void should_throw_an_exception_when_y_of_the_coordinate_is_not_a_number() {
        var input = List.of("M", "3", "Z");
        assertThrows(MapSizeExceptions.class, () -> InputParser.parseMapSize(input));
    }
}