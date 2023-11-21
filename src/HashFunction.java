import java.util.HashMap;
import java.util.Set;

class HashFunction {
    private String[] word;
    private String writableTxt = "Index\t| Character\t| Hash Key\n";
    private String writableTxtQKey = "Index\t| Character\t| Hash Key\t | New Hash Key \t | Q Hash Key \n";
    writeFile obj = new writeFile();
    private int probes;
    private int quadraticHashKey;
    private String writableTxtLine;

    HashFunction(Set<String> words) {
        this.word = words.toArray(new String[0]);
    }

    void hashKey() {
        // Create a new HashMap to store the alphabet characters
        HashMap<Character, Integer> englishAlphaList = new HashMap<Character, Integer>();
        // Assign each character from a-z to the values 26-51
        int count = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            englishAlphaList.put(c, count);
            count++;
        }
        // Assign each character from A-Z to the values 0-25
        count = 26;
        for (char c = 'A'; c <= 'Z'; c++) {
            englishAlphaList.put(c, count);
            count++;
        }


//        for(char c : englishAlphaList.keySet()) {
//            System.out.println(c + " = " + englishAlphaList.get(c));
//        }

        for (int i = 0; i < this.word.length; i++) {
            String tmpWord = word[i];
            int hashKey = 0;
            for (int j = 0; j < tmpWord.length(); j++) {
                char tmpChar = tmpWord.charAt(j);
//                System.out.print(tmpChar + ",");
                hashKey += englishAlphaList.get(tmpChar);
            }

            writableTxt += String.format("%-7d\t| %-10s\t| %-7d\n", i, tmpWord, hashKey);

            writableTxtLine += String.format("%-7d\t| %-7s\n", i, tmpWord);
//            quadraticHashFunction(tmpWord,hashKey,i, word.length);


            final int c1 = 1, c2 = 1, c3 = 0;
            probes = (c1 * i * i) + (c2 * i) + c3;
            quadraticHashKey = (hashKey + probes) % (word.length * 2);

            writableTxtQKey += String.format("%-7d\t| %-10s\t| %-7d\t | %-7d\t| %-10s\n", i, word[i], hashKey, probes, quadraticHashKey);
        }
        obj.fileWriter(writableTxt, "wordsHK2");
        obj.fileWriter(writableTxtQKey, "wordsQHK2");
        obj.fileWriter(writableTxtLine, "nonCollisionHashTable");


        System.out.println(writableTxtQKey);
        System.out.println(writableTxt);
    }
}