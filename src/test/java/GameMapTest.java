import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameMapTest {

    GameMap gameMap = new GameMap(new MapSize(3, 4));

    Adventurer adventurer = new Adventurer(
            "Lara",
            new Coordinate(1, 1),
            new Orientation("N"),
            new ArrayList<>()
    );

    @Test
    @DisplayName("isInsideTheMap : should return false when 'x' coordinate is negative")
    void isInsideTheMap_should_return_false_when_x_coordinate_is_negative() {
        assertFalse(gameMap.isInsideTheMap(new Coordinate(-1, 1)));
    }

    @Test
    @DisplayName("isInsideTheMap : should return false when 'y' coordinate is negative")
    void isInsideTheMap_should_return_false_when_y_coordinate_is_negative() {
        assertFalse(gameMap.isInsideTheMap(new Coordinate(1, -1)));
    }

    @Test
    @DisplayName("isInsideTheMap : should return false when 'x' coordinate is greater than the number of rows")
    void isInsideTheMap_should_return_false_when_x_coordinate_is_greater_than_the_number_of_rows() {
        assertFalse(gameMap.isInsideTheMap(new Coordinate(4, 1)));
    }

    @Test
    @DisplayName("isInsideTheMap : should return false when 'y' coordinate is greater than the number of columns")
    void isInsideTheMap_should_return_false_when_y_coordinate_is_greater_than_the_number_of_columns() {
        assertFalse(gameMap.isInsideTheMap(new Coordinate(1, 5)));
    }

    @Test
    @DisplayName("isInsideTheMap : should return true when 'x' and 'y' coordinates are inside the map")
    void isInsideTheMap_should_return_true_when_coordinate_is_inside_the_map() {
        assertTrue(gameMap.isInsideTheMap(new Coordinate(1, 1)));
        assertTrue(gameMap.isInsideTheMap(new Coordinate(2, 3)));
    }

    @Test
    @DisplayName("addMountain : should add a mountain on the map")
    void addMountain() {
        gameMap.addMountain(new Coordinate(1, 1));
        assertEquals(gameMap.getMap()[1][1], "M");
    }

    @Test
    @DisplayName("addTreasure : should add a treasure on the map")
    void addTreasure() {
        gameMap.addTreasure(new Coordinate(1, 1));
        assertEquals(gameMap.getMap()[1][1], "T");
    }

    @Test
    @DisplayName("addAdventurer : should add an adventurer on the map")
    void addAdventurer() {
        gameMap.addAdventurer(adventurer);
        assertEquals(gameMap.getMap()[1][1], "A");
    }
}