import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MainTest {

    @Test
    public void testToSeeFunctionShouldReturnExtraOneDigit() {
        //prepare
        Main m = new Main();
        String input = "1";

        //test
        String output = m.calculateOnce(input);

        //assert
        assertEquals("1 becomes 11 (1 copy of digit 1).","11", output);
    }

    @Test
    public void testToSeeFunctionShouldReturnTwoDigitsOfOne() {
        //prepare
        Main m = new Main();
        String input = "11";

        //test
        String output = m.calculateOnce(input);

        //assert
        assertEquals("11 becomes 21 (2 copy of digit 1).","21", output);
    }

    @Test
    public void testToSeeFunctionShouldReturnThousandTwoHundredAndEleven() {
        //prepare
        Main m = new Main();
        String input = "21";

        //test
        String output = m.calculateOnce(input);

        //assert
        assertEquals("21 becomes 1211 (one 2 followed by one 1).","1211", output);
    }

    @Test
    public void testToSeeFunctionShouldReturnBigNumber() {
        //prepare
        Main m = new Main();
        String input = "1211";

        //test
        String output = m.calculateOnce(input);

        //assert
        assertEquals("1211 becomes 111221 (one 1, one 2, and two 1s).","111221", output);
    }

    @Test
    public void testToSeeFunctionShouldReturnBiggerNumber() {
        //prepare
        Main m = new Main();
        String input = "111221";

        //test
        String output = m.calculateOnce(input);

        //assert
        assertEquals("111221 becomes 312211 (three 1s, two 2s, and one 1).","312211", output);
    }
}

