import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class MainTest {


    public int calcLiteral(Main m, int skip) throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day8\\testinput.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int lineNumber = 0;
        while ((st = br.readLine()) != null) {
            if(skip == lineNumber) {
                return m.countCodeRepresentationOfStringLiteral(st);
            }
            ++lineNumber;
        }
        return -1;
    }

    public int calcTheInMemoryString(Main m, int skip) throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day8\\testinput.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int lineNumber = 0;
        while ((st = br.readLine()) != null) {
            if(skip == lineNumber) {
                return m.inMemoryString(st);
            }
            ++lineNumber;
        }
        return -1;
    }

    @Test
    public void checkTwoQuotesTest() throws IOException {
        Main m = new Main();
        assertEquals(2, calcLiteral(m, 0));
    }

    @Test
    public void checkTwoQuotesInMemoryTest() throws IOException {
        Main m = new Main();
        assertEquals(0, calcTheInMemoryString(m, 0));
    }

    @Test
    public void checkABCTest() throws IOException {
        Main m = new Main();

        assertEquals(5, calcLiteral(m, 1));
    }

    @Test
    public void checkABCInMemoryTest() throws IOException {
        Main m = new Main();

        assertEquals(3, calcTheInMemoryString(m, 1));
    }

    @Test
    public void checkAAAAASingleEscapeTest() throws IOException {
        Main m = new Main();

        assertEquals(10, calcLiteral(m, 2));
    }

    @Test
    public void checkAAAAAInMemorySingleEscapeTest() throws IOException {
        Main m = new Main();

        assertEquals(7, calcTheInMemoryString(m, 2));
    }

    @Test
    public void checkAsciiTest() throws IOException {
        Main m = new Main();

        assertEquals(9, calcLiteral(m, 3));
    }

    @Test
    public void checkInMemoryAsciiTest() throws IOException {
        Main m = new Main();

        assertEquals(4, calcTheInMemoryString(m, 3));
    }
    @Test
    public void checkAsciiTestTwo() throws IOException {
        Main m = new Main();

        assertEquals(43, calcLiteral(m, 4));
    }

    @Test
    public void checkInMemoryAsciiTwoTest() throws IOException {
        Main m = new Main();
        assertEquals(29, calcTheInMemoryString(m, 4));
    }

    @Test
    public void checkEscapedQuoteIsCounted() throws IOException {
        Main m = new Main();
        assertEquals(9, calcLiteral(m, 5));
        assertEquals(6, calcTheInMemoryString(m, 5));
    }
}

