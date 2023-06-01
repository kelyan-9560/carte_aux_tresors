import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriter {
    private final String filePath;

    public FileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void write(String content) {
        try {
            Path path = Path.of(filePath);

            if(!Files.exists(path)) {
                Files.createFile(path);
            } else {
                Files.delete(path);
            }

            Files.writeString(path, content, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
