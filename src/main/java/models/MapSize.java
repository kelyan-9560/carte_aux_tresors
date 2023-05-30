package models;

import java.util.Objects;

public class MapSize {
    private final int nbRows;
    private final int nbColumns;

    public MapSize(int nbRows, int nbColumns) {
        this.nbRows = nbRows;
        this.nbColumns = nbColumns;
    }

    public int getNbRows() {
        return nbRows;
    }

    public int getNbColumns() {
        return nbColumns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapSize mapSize = (MapSize) o;
        return nbRows == mapSize.nbRows && nbColumns == mapSize.nbColumns;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbRows, nbColumns);
    }

    @Override
    public String toString() {
        return "models.MapSize{" +
                "nbRows=" + nbRows +
                ", nbColumns=" + nbColumns +
                '}';
    }
}
