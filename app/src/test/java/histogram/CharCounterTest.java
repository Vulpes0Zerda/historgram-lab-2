package histogram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import histogram.fileIO.FileReader;

// sudo bash ./gradlew clean build
public class CharCounterTest {

    private CharacterCounter characterCounter;

    @BeforeEach
    public void setUp() {
        characterCounter = new CharacterCounter();
    }

    @Test
    public void testCountCharactersFromFile() throws IOException {
        String filePath = "file.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Hello World!");
        }

        FileReader fileReader = new FileReader(filePath);
        fileReader.getCharacterStream().forEach(line -> {
            for (char c : line.toCharArray()) {
                characterCounter.add(c);
            }
        });

        assertEquals(1, characterCounter.charCount.get('H'));
        assertEquals(3, characterCounter.charCount.get('l'));
        assertEquals(2, characterCounter.charCount.get('o'));
        assertEquals(1, characterCounter.charCount.get('W'));
        assertEquals(1, characterCounter.charCount.get('r'));
        assertEquals(1, characterCounter.charCount.get('d'));
        assertEquals(1, characterCounter.charCount.get('e'));
    }
}
