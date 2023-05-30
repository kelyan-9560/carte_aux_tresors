package models;

import exceptions.InstructionsException;
import exceptions.OrientationException;
import services.MoveValidator;

import java.util.List;
import java.util.Objects;



public class Adventurer {
    private final String name;
    private final Coordinate coordinate;
    private final Orientation orientation;
    private final List<Treasure> treasures;

    public Adventurer(String name, Coordinate coordinate, Orientation orientation, List<Treasure> treasures) {
        this.name = name;
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.treasures = treasures;
    }


    //TODO : maybe create a new class for this
    public Adventurer move(String instruction, GameMap gameMap){
        switch (instruction) {
            case "A":
                var newCoordinate = goTo();

                var moveValidator = new MoveValidator(gameMap, newCoordinate);
                if (moveValidator.isPossible()) {
                    return new Adventurer(name, newCoordinate, orientation, treasures);
                }
                return this;

            case "G":
                return new Adventurer(
                        name,
                        coordinate,
                        orientation.turnLeft(),
                        treasures
                );

            case "D":
                return new Adventurer(
                        name,
                        coordinate,
                        orientation.turnRight(),
                        treasures
                );
            default:
                throw new InstructionsException("Instruction not recognized");
        }
    }


    //TODO : return a new Adventurer with the new coordinate
    private Coordinate goTo() {
        switch (orientation.getValue()) {
            case "N":
                return new Coordinate(coordinate.getX(), coordinate.getY() - 1);
            case "S":
                return new Coordinate(coordinate.getX(), coordinate.getY() + 1);
            case "E":
                return new Coordinate(coordinate.getX() + 1, coordinate.getY());
            case "W":
                return new Coordinate(coordinate.getX() - 1, coordinate.getY());
            default:
                throw new OrientationException("Orientation not recognized");
        }
    }



    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adventurer that = (Adventurer) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(coordinate, that.coordinate) &&
                Objects.equals(orientation, that.orientation) &&
                Objects.equals(treasures, that.treasures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinate, orientation, treasures);
    }

    @Override
    public String toString() {
        return "Adventurer{" +
                "name='" + name + '\'' +
                ", coordinate=" + coordinate +
                ", orientation=" + orientation +
                ", treasures=" + treasures +
                '}';
    }

    public String toFile() {
        return "A - " + name + " - " + coordinate.getX() + " - " + coordinate.getY() + " - " + orientation.getValue() + " - " + treasures.size();
    }
}
