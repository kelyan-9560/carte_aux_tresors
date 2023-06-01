package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameMap {
    private final MapSize mapSize;
    private String[][] map;
    private final List<Treasure> treasures;

    public GameMap(MapSize mapSize, List<Treasure> treasures) {
        this.mapSize = mapSize;
        this.treasures = treasures;
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
        treasures.add(new Treasure(coordinate));
    }

    public void removeTreasure(Coordinate coordinate) {
        treasures.stream()
                .filter(treasure -> treasure.getCoordinate().equals(coordinate))
                .findFirst()
                .map(treasures::remove);

        var treasureAlreadyHere = treasures.stream()
                .filter(treasure -> treasure.getCoordinate().equals(coordinate))
                .findFirst();

        if(treasureAlreadyHere.isEmpty()){
            map[coordinate.getX()][coordinate.getY()] = "O";
        }
    }
    public void addAdventurer(Adventurer adventurer) {
        map[adventurer.getCoordinate().getX()][adventurer.getCoordinate().getY()] = "A";
    }

    private List<Treasure> treasuresAt(Coordinate coordinate){
        return treasures.stream()
                .filter(treasure -> treasure.getCoordinate().equals(coordinate))
                .collect(Collectors.toList());
    }

    private List<String> mountainsToFile(){
        var res = new ArrayList<String>();

        for (int i = 0; i < mapSize.getNbRows(); i++) {
            for (int j = 0; j < mapSize.getNbColumns(); j++) {
                if(map[i][j].equals("M")){
                    res.add("M - " + i + " - " + j);
                }
            }
        }

        return res;
    }

    private List<String> treasuresToFile(){
        var distinctTreasureCoordinate = treasures
                .stream()
                .map(Treasure::getCoordinate)
                .distinct()
                .collect(Collectors.toList());

        var res = new ArrayList<String>();

        distinctTreasureCoordinate.forEach(coordinate -> {
            var nbTreasure = treasuresAt(coordinate).size();
            res.add("T - " + coordinate.getX() + " - " + coordinate.getY() + " - " + nbTreasure);
        });

        return res;
    }

    public List<String> toFile(){
        var res = new ArrayList<String>();

        res.addAll(mountainsToFile());
        res.addAll(treasuresToFile());

        return res;
    }

    public MapSize getMapSize() {
        return mapSize;
    }

    public String[][] getMap() {
        return map;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    @Override
    public String toString() {
        return "models.Map{" +
                "mapSize=" + mapSize.toString() +
                ", map=" + Arrays.toString(map) +
                '}';
    }
}
