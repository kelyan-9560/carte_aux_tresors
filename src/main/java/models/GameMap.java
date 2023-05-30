package models;

import java.util.Arrays;

public class GameMap {
    private final MapSize mapSize;
    private String[][] map;

    public GameMap(MapSize mapSize) {
        this.mapSize = mapSize;
        initMap();
    }

    private void initMap() {
        map = new String[mapSize.getNbRows()][mapSize.getNbColumns()];

        for (int i = 0; i < mapSize.getNbRows(); i++) {
            for (int j = 0; j < mapSize.getNbColumns(); j++) {
                map[i][j] = "O";
            }
        }
    }

    public Boolean isInsideTheMap(Coordinate coordinate) {
        return coordinate.getX() >= 0 && coordinate.getX() < mapSize.getNbRows() &&
                coordinate.getY() >= 0 && coordinate.getY() < mapSize.getNbColumns();
    }

    public void addMountain(Coordinate coordinate) {
        map[coordinate.getX()][coordinate.getY()] = "M";
    }

    public void addTreasure(Coordinate coordinate) {
        map[coordinate.getX()][coordinate.getY()] = "T";
    }
    public void addAdventurer(Adventurer adventurer) {
        map[adventurer.getCoordinate().getX()][adventurer.getCoordinate().getY()] = "A";
    }

    public MapSize getMapSize() {
        return mapSize;
    }

    public String[][] getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "models.Map{" +
                "mapSize=" + mapSize.toString() +
                ", map=" + Arrays.toString(map) +
                '}';
    }
}
