import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    Main m;
    @Before
    public void setUp() throws Exception {
        m = new Main();
    }

    @Test
    public void testToSeeFunctionReturnNextLetterInAlphabet() {
        //prepare
        String input = "a";

        //test
        String output = m.incrementLetterOnce(input);

        //assert
        assertEquals("a increments to b", "b", output);
    }

    @Test
    public void testToSeeZFlipsToA() {
        //prepare
        String input = "z";

        //test
        String output = m.incrementLetterOnce(input);

        //assert
        assertEquals("z increments to a", "a", output);
    }

    @Test
    public void testToSeeZFlipsNextLetter() {
        //prepare
        String input = "az";

        //test
        String output = m.incrementLetterOnce(input);

        //assert
        assertEquals("flip next Letter in chain", "ba", output);
    }

    @Test
    public void testConstraintDontAOnZero() {
        //prepare
        String input = "aaz";

        //test
        String output = m.incrementLetterOnce(input);

        //assert
        assertEquals("flip next Letter in chain, forget next letter", "aba", output);
    }

    @Test
    public void getPasswordCheckWithoutBoundaries() {
        //prepare
        String input = "abcdefgh";

        //test
        while (!"abcdffaa".equals(input)) {
            input = m.incrementLetterOnce(input);
            System.out.println(input);
        }
        //assert
        assertEquals("abcdffaa", input);
    }

    @Test
    public void getPasswordCheckWithTwoLetters() {
        //prepare
        String input = "abcdefgh";

        //test
        while (!"abcdffaa".equals(input)) {
            input = m.incrementLetterOnce(input);

            if (m.containsTwoPairsOfLetters(input)) {
                System.out.println(input + " contains 2 double letters");
            }
            System.out.println(input);
        }
        //assert
        assertEquals("abcdffaa", input);
    }

    @Test
    public void getPasswordCheckWithoundaries() {
        //prepare
        String input = "hxbxwxba";

        //test
        while (!m.isValidPassword(input)) {
            input = m.incrementLetterOnce(input);

            if (m.containsTwoPairsOfLetters(input)) {
                System.out.println(input + " contains 2 double letters");
            }
            System.out.println(input);
        }
        //assert
        assertEquals("ghjaabcc", input);
    }

    @Test
    public void isInSerieFalse() {
        //prepare
        String input = "abdce";

        //test
        boolean output = m.isInSerie(input);

        //assert
        assertFalse("the output string has not got a serie like 'abc' or 'def' ",output);
    }

    @Test
    public void isInSerieTrueHIJKLMN() {
        //prepare
        String input = "hijklmmn";

        //test
        boolean output = m.isInSerie(input);

        //assert
        assertTrue("the output string has got a serie like 'HIJ' or 'KLMN' ",output);
    }

    @Test
    public void isInSerieTrue() {
        //prepare
        String input = "abddef";

        //test
        boolean output = m.isInSerie(input);

        //assert
        assertTrue("output string has a series of 3 letters next to each other, DEF",output);
    }


}

