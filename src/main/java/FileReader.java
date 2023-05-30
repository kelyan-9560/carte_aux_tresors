import models.Adventurer;
import models.GameMap;
import models.MapSize;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class FileReader {
    private final String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public void readFile() {

        try (Stream<String> lines = Files.lines(resolveFilePath())) {

            AtomicReference<GameMap> gameMap = new AtomicReference<>();

            lines.forEach(line -> {
                line = line.replace(" ", "");
                if (line.startsWith("#")) return;

                List<String> lineSplit = List.of(line.split("-"));

                if (line.startsWith("C")){
                    System.out.println("-----------------------------------");
                    System.out.println("Map : " + line);

                    MapSize mapSize = InputParser.parseMapSize(lineSplit);
                    gameMap.set(new GameMap(mapSize));
                }
                if (line.startsWith("M")){
                    System.out.println("-----------------------------------");
                    System.out.println("Mountain : " + line);

                    var mountainCoordinate = InputParser.parseCoordinate(lineSplit);
                    gameMap.get().addMountain(mountainCoordinate);

                }
                if (line.startsWith("T")){
                    System.out.println("-----------------------------------");
                    System.out.println("Treasure : " + line);

                    int nbTreasure = Integer.parseInt(lineSplit.get(3));
                    for (int i = 0; i < nbTreasure; i++) {
                        var treasureCoordinate = InputParser.parseCoordinate(lineSplit);
                        gameMap.get().addTreasure(treasureCoordinate);
                    }

                }
                if (line.startsWith("A")){
                    System.out.println("-----------------------------------");
                    System.out.println("Adventurer : " + line);

                    Adventurer adventurer = InputParser.parseAdventurer(lineSplit);

                    Instructions instructions = new Instructions(InputParser.parseInstructions(lineSplit));
                    for (String instruction : instructions.getValues()) {
                        adventurer = adventurer.move(instruction, gameMap.get());

                        System.out.println(adventurer.toFile());
                    }
                }
            });

            System.out.println("Map : " + gameMap.get().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
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
