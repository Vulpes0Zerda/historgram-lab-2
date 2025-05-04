package histogram.fileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

public class FileReader {

    private String path;
    private BufferedReader reader;

    public FileReader(String path) throws FileNotFoundException{
        this.path = path;
        this.reader = new BufferedReader(new java.io.FileReader(path));
    }


    public boolean isReady() throws IOException {
        return reader.ready();
    }


    public Stream<String> getCharacterStream(){
        return reader.lines();
    }

    public BufferedReader getReader(){
        return reader;
    }
    
    // // first task -> read a file and print its characters
    // public void printFileCharacters(String filePath) {
    //     try {
    //         FileInputStream fileInputStream = new FileInputStream(filePath);
    //         InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
    //         int character;
    //         while ((character = inputStreamReader.read()) != -1) {
    //             System.out.print((char) character);
    //         }
    //         inputStreamReader.close();
    //     } catch (IOException e) {
    //         System.err.println("Error reading file: " + e.getMessage());
    //     }
    // }

    // public String hashMapToString(HashMap<Character, Integer> map) {
    //     String result = "";
    //     for (Character key : map.keySet()) {
    //         result += key + ": " + map.get(key) + "\n";
    //     }
    //     return result;
    // }

    // // third task -> read a file and print its characters counting frequencies
    // public void countCharacters(String readFile) {
    //     // read a file and print its characters counting frequencies
    //     try {
    //         FileInputStream fileInputStream = new FileInputStream(readFile);
    //         InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
    //         int character;
    //         HashMap<Character, Integer> charCountMap = new HashMap<>();
    //         while ((character = inputStreamReader.read()) != -1) {
    //             char c = (char) character;
    //             if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
    //                 Integer existingCount = charCountMap.get(c);
    //                 if (existingCount == null) {
    //                     existingCount = 0;
    //                 }
    //                 charCountMap.put(c, existingCount + 1);
    //             }

    //         }
    //         inputStreamReader.close();

    //         // write the frequencies to a file
    //         try {
    //             BufferedWriter writer = new BufferedWriter(new FileWriter("frequencies.txt"));
    //             writer.write(hashMapToString(charCountMap));
    //             writer.close();
    //         } catch (IOException error) {
    //             error.printStackTrace();
    //         }

    //     } catch (IOException e) {
    //         System.err.println("Error reading file: " + e.getMessage());
    //     }
    // }
}
