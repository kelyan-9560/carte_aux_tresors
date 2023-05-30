import exceptions.OrientationException;
import models.Orientation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrientationTest {

    @Test
    @DisplayName("TURN LEFT : orientation should change from 'N' to 'W'")
    void turn_left_from_the_north() {
        var orientation = new Orientation("N");
        var turnedOrientation = orientation.turnLeft();
        
        assertEquals(turnedOrientation.getValue(), "W");
    }
    
    @Test
    @DisplayName("TURN LEFT : orientation should change from 'W' to 'S'")
    void turn_left_from_the_west() {
        var orientation = new Orientation("W");
        var turnedOrientation = orientation.turnLeft();
        
        assertEquals(turnedOrientation.getValue(), "S");
    }
    
    @Test
    @DisplayName("TURN LEFT : orientation should change from 'S' to 'E'")
    void turn_left_from_the_south() {
        var orientation = new Orientation("S");
        var turnedOrientation = orientation.turnLeft();
        
        assertEquals(turnedOrientation.getValue(), "E");
    }
    
    @Test
    @DisplayName("TURN LEFT : orientation should change from 'E' to 'N'")
    void turn_left_from_the_east() {
        var orientation = new Orientation("E");
        var turnedOrientation = orientation.turnLeft();
        
        assertEquals(turnedOrientation.getValue(), "N");
    }

    @Test
    @DisplayName("TURN LEFT : must throw an OrientationException because 'A' is not a valid orientation")
    void turn_left_with_an_unexpected_value() {
        var orientation = new Orientation("A");

        assertThrows(OrientationException.class, orientation::turnLeft);
    }
    
    @Test
    @DisplayName("TURN RIGHT : orientation should change from 'N' to 'E'")
    void turn_right_from_the_north() {
        var orientation = new Orientation("N");
        var turnedOrientation = orientation.turnRight();
        
        assertEquals(turnedOrientation.getValue(), "E");
    }
    
    @Test
    @DisplayName("TURN RIGHT : orientation should change from 'E' to 'S'")
    void turn_right_from_the_east() {
        var orientation = new Orientation("E");
        var turnedOrientation = orientation.turnRight();
        
        assertEquals(turnedOrientation.getValue(), "S");
    }
    
    @Test
    @DisplayName("TURN RIGHT : orientation should change from 'S' to 'W'")
    void turn_right_from_the_south() {
        var orientation = new Orientation("S");
        var turnedOrientation = orientation.turnRight();
        
        assertEquals(turnedOrientation.getValue(), "W");
    }
    
    @Test
    @DisplayName("TURN RIGHT : orientation should change from 'W' to 'N'")
    void turn_right_from_the_west() {
        var orientation = new Orientation("W");
        var turnedOrientation = orientation.turnRight();
        
        assertEquals(turnedOrientation.getValue(), "N");
    }

    @Test
    @DisplayName("TURN RIGHT : must throw an OrientationException because 'A' is not a valid orientation")
    void turn_right_with_an_unexpected_value() {
        var orientation = new Orientation("A");

        assertThrows(OrientationException.class, orientation::turnRight);
    }

    
}