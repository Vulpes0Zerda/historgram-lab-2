
package histogram;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        String filePath = "./file.txt";
        fileReader.printFileCharacters(filePath);
    }
}
