package adventofcode2021.adventofcode4b;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testCard {

    @Test
    public void testSingleLine() {
        AdventOfCode4B a = new AdventOfCode4B();
        int[] number = a.lineToIntArray("14 21 17 24  4");
        assertEquals(14, number[0]);
        assertEquals(21, number[1]);
        assertEquals(17, number[2]);
        assertEquals(24, number[3]);
        assertEquals(4, number[4]);
    }

    @Test
    public void checkLineNumbers() throws IOException {
        AdventOfCode4B a = new AdventOfCode4B();
        a.loadVariablesFromInput("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode4a\\exampleTest.txt");
        assertEquals(15, a.getLineNumber());
    }

    @Test
    public void checkSizeCard() throws IOException {
        AdventOfCode4B a = new AdventOfCode4B();
        a.loadVariablesFromInput("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode4a\\exampleTest.txt");
        for (int i = 0; i < a.bingoCards.size(); i++) {
            HashMap<Integer, int[]> bingoCard = a.bingoCards.get(i); //get single card.
            assertEquals(bingoCard.size(), 5);
        }
    }

    @Test
    public void checkSingleNumber() throws IOException {
        AdventOfCode4B a = new AdventOfCode4B();
        a.loadVariablesFromInput("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode4a\\exampleTest.txt");
        a.markNumber(7);
        assertEquals(-1, a.getFirstBingoCardMarkedRow());
    }

    @Test
    public void checkRowOfNumberIsSet() throws IOException {
        AdventOfCode4B a = new AdventOfCode4B();
        a.loadVariablesFromInput("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode4a\\exampleTest.txt");

        //last row of a bingocard.
        a.markNumber(7);
        a.markNumber(2);
        a.markNumber(0);
        a.markNumber(12);
        a.markNumber(3);

        int bingoCard = a.getFirstBingoCardMarkedRow();
        assertEquals(2, bingoCard);
    }

    @Test
    public void checkRowOfNumberIsSetOneRow() throws IOException {
        AdventOfCode4B a = new AdventOfCode4B();
        a.loadVariablesFromInput("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode4a\\exampleTest.txt");

        //one row above last row.
        a.markNumber(22);
        a.markNumber(11);
        a.markNumber(13);
        a.markNumber(6);
        a.markNumber(5);

        int bingoCard = a.getFirstBingoCardMarkedRow();
        assertEquals(2, bingoCard);
    }

    @Test
    public void checkColumnIsSet() throws IOException {
        AdventOfCode4B a = new AdventOfCode4B();
        a.loadVariablesFromInput("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode4a\\exampleTest.txt");

        //one row above last row.
        a.markNumber(14);
        a.markNumber(10);
        a.markNumber(18);
        a.markNumber(22);
        a.markNumber(2);

        int bingoCard = a.getFirstBingoCardMarkedColumn();
        assertEquals(2, bingoCard);
    }

    @Test
    public void checkColumnIsSetFalse() throws IOException {
        AdventOfCode4B a = new AdventOfCode4B();
        a.loadVariablesFromInput("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode4a\\exampleTest.txt");

        //one row above last row.
        a.markNumber(14);
        a.markNumber(10);
        a.markNumber(22);
        a.markNumber(2);

        int bingoCard = a.getFirstBingoCardMarkedColumn();
        assertEquals(-1, bingoCard);
    }

    @Test
    public void checkColumnLastRowIsBingo() throws IOException {
        AdventOfCode4B a = new AdventOfCode4B();
        a.loadVariablesFromInput("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode4a\\exampleTest.txt");
        //one row above last row.
        a.markNumber(22);
        a.markNumber(5);
        a.markNumber(23);
        a.markNumber(4);
        a.markNumber(6);
        assertTrue(a.isBingo());
    }

    @Test
    public void checkModuloFive(){
        int i = 0;
        assertEquals(i, 0);
        assertEquals(0, i % 5);
        i++;
        assertEquals(1, i % 5);
        i++;
        assertEquals(2, i % 5);
        i++;
        assertEquals(3, i % 5);
        i++;
        assertEquals(4, i % 5);
        i++;
        assertEquals(0, i % 5);
    }
}
