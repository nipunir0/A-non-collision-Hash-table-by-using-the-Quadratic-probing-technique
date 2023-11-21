import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
    public static <Stirng> void main(String[] args) throws IOException {

        String[] words;
        String textLine = "", path = "C:/Users/randu/IdeaProjects/nipuniminiproject/src/file.txt";
        File file = new File(path);
        file.createNewFile();

        try{
            Scanner scanner = new Scanner(file);//read the file
            while(scanner.hasNextLine()){
                textLine = textLine.concat(scanner.nextLine() + "\n");
            }
        }catch (IOException e){
            System.out.println("file not found");
        }

        words = textLine.replaceAll("[^a-zA-Z]+", " ").split("\\s+");
        System.out.println(Arrays.toString(words));
        Set <String> uniqueWords = new HashSet<>();
        for (String word : words) {
            // If word is not already in uniqueWords and is not identical to an existing word (ignoring case),
            // add it to the uniqueWords set
            if (!uniqueWords.contains(word) && !uniqueWords.contains(word.toLowerCase()) && !uniqueWords.contains(word.toUpperCase())) {
                uniqueWords.add(word);
            }
        }

        System.out.println(uniqueWords);
        HashFunction listObj = new HashFunction(uniqueWords);
        listObj.hashKey();

    }
}
