import models.Game;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/input/file.txt";
        FileReader fileReader = new FileReader(filePath);
        Game game = fileReader.readFile();

        game.play();

    }
}
