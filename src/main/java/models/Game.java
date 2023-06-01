package models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final GameMap gameMap;
    private final List<Adventurer> adventurers;

    public Game(GameMap gameMap, List<Adventurer> adventurers) {
        this.gameMap = gameMap;
        this.adventurers = adventurers;
    }
    
    
    public void play(){
        for (int i = 0; i < getMaxNumberOfInstructions(); i++) {
            for (Adventurer adventurer : adventurers) {
                if (adventurer.getInstructions().size() > i) {
                    var adventurerMoved = adventurer.move(adventurer.getInstructions().get(i), gameMap);
                    updateAdventurer(adventurer, adventurerMoved);
                }
            }
        }
        adventurers.forEach(adventurer -> System.out.println(adventurer.toFile()));
    }

    private void updateAdventurer(Adventurer adventurerToReplace, Adventurer replacementAdventurer){
        adventurers.set(adventurers.indexOf(adventurerToReplace), replacementAdventurer);
    }

    private int getMaxNumberOfInstructions(){
       return adventurers.stream()
                        .map(Adventurer::getInstructions)
                                .mapToInt(List::size)
                                        .max().orElse(0);
    }

    public String toFile(){
        List<String> lines = new ArrayList<>();

        lines.add(gameMap.getMapSize().toFile());
        lines.addAll(gameMap.toFile());
        adventurers.forEach(adventurer -> lines.add(adventurer.toFile()));

        return String.join("\n", lines);
    }
}
