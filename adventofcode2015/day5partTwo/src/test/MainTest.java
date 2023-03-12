import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    //IsNiceString test
    @Test
    public void isNiceStringTest() {
        assertTrue(Main.isNiceString("xxyxx"));
    }

    //isAppearingTestSection
    @Test
    public void isAppearringDoubleStringTest(){
        assertTrue(Main.hasDoubleLetterAppearTwice("qjhvhtzxzqqjkmpb"));
    }

    @Test
    public void isAppearringDoubleStringNullCheckTest() {
        assertFalse(Main.hasDoubleLetterAppearTwice(null));
    }

    @Test
    public void isAppearringDoubleStringNotAppearing() {
        assertFalse(Main.hasDoubleLetterAppearTwice("ëiijj"));
    }

    @Test
    public void isAppearingDoubleStringNotAppearingTest() {
        assertFalse(Main.hasDoubleLetterAppearTwice("klnop"));
    }

    @Test
    public void isAppearingTwiceTest() {
        assertTrue(Main.hasDoubleLetterAppearTwice("kkokhokk"));
    }

    //Test for Letter for Repetition
    @Test
    public void repeatOneLetterTest() {
        assertTrue(Main.repeatOneLetter("abcdefeghi"));
    }

    @Test
    public void repeatOneLetterTestEmpty() {
        assertFalse(Main.repeatOneLetter(null));
    }

    @Test
    public void repeatOneLetterKyIsDoubleTest() {
        assertTrue(Main.repeatOneLetter("kyk"));
    }

    @Test
    public void repeatLetterxYIsDoubleTest() {
        assertTrue(Main.repeatOneLetter("xxyxx"));
    }
}
