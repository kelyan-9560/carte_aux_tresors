import models.Game;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/files/input.txt";
        FileReader fileReader = new FileReader(filePath);

        Game game = fileReader.readFile();
        game.play();


        FileWriter fileWriter = new FileWriter("src/main/java/files/output.txt");




        fileWriter.write(game.toFile());

    }
}
