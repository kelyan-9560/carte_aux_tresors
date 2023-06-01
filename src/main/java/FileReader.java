import models.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class FileReader {
    private final String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public Game readFile() {
        AtomicReference<GameMap> gameMap = new AtomicReference<>();
        List<Adventurer> adventurers = new ArrayList<>();

        try (Stream<String> lines = Files.lines(resolveFilePath())) {

            lines.forEach(line -> {
                line = line.replace(" ", "");
                if (line.startsWith("#")) return;

                List<String> lineSplit = List.of(line.split("-"));

                if (line.startsWith("C")) {
                    MapSize mapSize = InputParser.parseMapSize(lineSplit);
                    gameMap.set(new GameMap(mapSize, new ArrayList<>()));
                }
                if (line.startsWith("M")) {

                    var mountainCoordinate = InputParser.parseCoordinate(lineSplit.get(1), lineSplit.get(2));
                    gameMap.get().addMountain(mountainCoordinate);

                }
                if (line.startsWith("T")) {
                    int nbTreasure = Integer.parseInt(lineSplit.get(3));
                    for (int i = 0; i < nbTreasure; i++) {
                        var treasureCoordinate = InputParser.parseCoordinate(lineSplit.get(1), lineSplit.get(2));
                        gameMap.get().addTreasure(treasureCoordinate);
                    }

                }
                if (line.startsWith("A")) {
                    Adventurer adventurer = InputParser.parseAdventurer(lineSplit);
                    adventurers.add(adventurer);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Game(gameMap.get(), adventurers);
    }

    private Path resolveFilePath() throws IOException {
        Path currentDir = Paths.get("");
        Path absolutePath = currentDir.resolve(filePath).toAbsolutePath();
        if (!Files.exists(absolutePath)) {
            throw new IOException("File not found: " + absolutePath);
        }
        return absolutePath;
    }
}
