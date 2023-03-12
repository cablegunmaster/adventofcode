import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class MainTest {

    public String calcEncodedString(Main m, int skip) throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day8partTwo\\testinput.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int lineNumber = 0;
        while ((st = br.readLine()) != null) {
            if(skip == lineNumber) {
                return m.encodedString(st);
            }
            ++lineNumber;
        }
        return "";
    }

    @Test
    public void checkTwoQuotesEncodedTest() throws IOException {
        Main m = new Main();
        assertEquals("\"\\\"\\\"\"", calcEncodedString(m, 0));
        assertEquals(6, calcEncodedString(m, 0).length());
    }

    @Test
    public void checkABCEncodedTest() throws IOException {
        Main m = new Main();

        assertEquals("\"\\\"abc\\\"\"", calcEncodedString(m, 1));
        assertEquals(9, calcEncodedString(m, 1).length());
    }
    @Test
    public void checkAAAAAEncodedSingleEscapeTest() throws IOException {
        Main m = new Main();

        assertEquals("\"\\\"aaa\\\\\\\"aaa\\\"\"", calcEncodedString(m, 2));
        assertEquals(16, calcEncodedString(m, 2).length());
    }


    @Test
    public void checkEncodedAsciiTest() throws IOException {
        Main m = new Main();
        assertEquals("\"\\\"\\\\x27abc\\\"\"", calcEncodedString(m, 3));
        assertEquals(14, calcEncodedString(m, 3).length());
    }

    @Test
    public void checkEncodedHardStringTest() throws IOException {
        Main m = new Main();
        assertEquals("\"\\\"byc\\\\x9dyxuafof\\\\\\\\\\\\xa6uf\\\\\\\\axfozomj\\\\\\\\olh\\\\x6a\\\"\"", calcEncodedString(m, 4));
    }
}

