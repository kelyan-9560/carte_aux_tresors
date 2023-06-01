import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdventurerTest {

    GameMap gameMap = new GameMap(new MapSize(3, 4), new ArrayList<>());

    Adventurer adventurer;

    @Test
    @DisplayName("move : should move the adventurer to the north")
    void should_move_the_adventurer_to_the_north() {
        var orientation = new Orientation("N");

        adventurer = new Adventurer("Lara", new Coordinate(1, 1),
                                            orientation, new ArrayList<>(), new ArrayList<>());

        var adventurerWithNewCoordinate = adventurer.move(new Instruction("A"), gameMap);

        assertEquals(adventurerWithNewCoordinate.getCoordinate(), new Coordinate(1, 0));
    }

    @Test
    @DisplayName("move : should move the adventurer to the south")
    void should_move_the_adventurer_to_the_south() {
        var orientation = new Orientation("S");

        adventurer = new Adventurer("Lara", new Coordinate(1, 1),
                orientation, new ArrayList<>(), new ArrayList<>());

        var adventurerWithNewCoordinate = adventurer.move(new Instruction("A"), gameMap);

        assertEquals(adventurerWithNewCoordinate.getCoordinate(), new Coordinate(1, 2));
    }

    @Test
    @DisplayName("move : should move the adventurer to the east")
    void should_move_the_adventurer_to_the_east() {
        var orientation = new Orientation("E");

        adventurer = new Adventurer("Lara", new Coordinate(1, 1),
                orientation, new ArrayList<>(), new ArrayList<>());

        var adventurerWithNewCoordinate = adventurer.move(new Instruction("A"), gameMap);

        assertEquals(adventurerWithNewCoordinate.getCoordinate(), new Coordinate(2, 1));
    }

    @Test
    @DisplayName("move : should move the adventurer to the west")
    void should_move_the_adventurer_to_the_west() {
        var orientation = new Orientation("W");

        adventurer = new Adventurer("Lara", new Coordinate(1, 1),
                orientation, new ArrayList<>(), new ArrayList<>());

        var adventurerWithNewCoordinate = adventurer.move(new Instruction("A"), gameMap);

        assertEquals(adventurerWithNewCoordinate.getCoordinate(), new Coordinate(0, 1));
    }


    @Test
    @DisplayName("adventurer should stay at the same coordinate due to the mountain")
    void should_not_move_the_adventurer_to_the_north(){
        var orientation = new Orientation("W");
        adventurer = new Adventurer("Lara", new Coordinate(1, 1),
                orientation, new ArrayList<>(), new ArrayList<>());

        gameMap.addMountain(new Coordinate(0, 1));

        var adventurerWithNewCoordinate = adventurer.move(new Instruction("A"), gameMap);

        assertEquals(adventurerWithNewCoordinate.getCoordinate(), new Coordinate(1, 1));
    }

    @Test
    @DisplayName("adventurer should stay at the same coordinate due to an other adventurer")
    void should_not_move_the_adventurer_due_to_an_adventurer() {
        var orientation = new Orientation("W");

        adventurer = new Adventurer("Emeline", new Coordinate(1, 1),
                                    orientation, new ArrayList<>(), new ArrayList<>());

        var adventurer2 = new Adventurer("Kelyan", new Coordinate(0, 1),
                                        orientation, new ArrayList<>(), new ArrayList<>());
        gameMap.addAdventurer(adventurer2);


        var adventurerWithNewCoordinate = adventurer.move(new Instruction("A"), gameMap);
        assertEquals(adventurerWithNewCoordinate.getCoordinate(), new Coordinate(1, 1));
    }


    @Test
    @DisplayName("Adventurer should get a treasure")
    void the_adventurer_should_get_a_treasure() {
        var orientation = new Orientation("N");

        adventurer = new Adventurer("Lara", new Coordinate(1, 3),
                orientation, new ArrayList<>(), new ArrayList<>());

        gameMap.addTreasure(new Coordinate(1, 2));

        var adventurerWithNewCoordinate = adventurer.move(new Instruction("A"), gameMap);

        assertEquals(adventurerWithNewCoordinate.getTreasures().size(), 1);
    }

}