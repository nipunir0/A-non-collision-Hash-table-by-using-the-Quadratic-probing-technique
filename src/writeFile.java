import java.io.FileWriter;
import java.io.IOException;

public class writeFile {

    void fileWriter(String text, String path) {
        try {
            FileWriter writer = new FileWriter(path + ".txt");
            writer.write(text);
            writer.close();
            System.out.println("Text has been written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}