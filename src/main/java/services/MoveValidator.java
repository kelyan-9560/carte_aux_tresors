package services;

import models.Coordinate;
import models.GameMap;

public class MoveValidator {
    private final GameMap gameMap;
    private final Coordinate newCoordinate;

    public MoveValidator(GameMap gameMap, Coordinate newCoordinate) {
        this.gameMap = gameMap;
        this.newCoordinate = newCoordinate;
    }

    private boolean isMountain() {
        return gameMap.getMap()[newCoordinate.getX()][newCoordinate.getY()].equals("M");
    }

    private boolean isAdventurer() {
        return gameMap.getMap()[newCoordinate.getX()][newCoordinate.getY()].equals("A");
    }

    public boolean isPossible() {
        return gameMap.isInsideTheMap(newCoordinate) &&
                !isMountain() &&
                !isAdventurer();
    }

}
