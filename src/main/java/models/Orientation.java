package models;

import exceptions.OrientationException;

public class Orientation {
    private final String value;

    public Orientation(String value) {
        this.value = value;
    }

    public Orientation turnLeft() {
        switch (value) {
            case "N":
                return new Orientation("W");
            case "W":
                return new Orientation("S");
            case "S":
                return new Orientation("E");
            case "E":
                return new Orientation("N");
            default:
                throw new OrientationException("Unexpected value: " + value);
        }
    }

    public Orientation turnRight() {
        switch (value) {
            case "N":
                return new Orientation("E");
            case "E":
                return new Orientation("S");
            case "S":
                return new Orientation("W");
            case "W":
                return new Orientation("N");
            default:
                throw new OrientationException("Unexpected value: " + value);
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Orientation{" +
                "value='" + value + '\'' +
                '}';
    }

}
