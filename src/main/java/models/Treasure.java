package models;

public class Treasure {
    private final Coordinate coordinate;

    public Treasure(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return "models.Treasure{" +
                "coordinate=" + coordinate +
                '}';
    }
}
