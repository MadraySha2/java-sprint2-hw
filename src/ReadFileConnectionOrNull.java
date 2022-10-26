import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


class ReadFileConnectionOrNull {
    public String readFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            return null;
        }

    }


}

