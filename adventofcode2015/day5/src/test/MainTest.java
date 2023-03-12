package adventofcode2015.day5.src.test;

import adventofcode2015.day5.src.day5.Main;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    //IsNiceString
    @Test
    public void isNiceStringTest(){
        assertTrue(Main.isNiceString("ugknbfddgicrmopn"));
    }

    @Test
    public void testMoreAsThreeVowelsIsNiceString() {
        assertTrue(Main.hasThreeOrMoreVowels("ugknbfddgicrmopn"));
    }

    //HasMultiple Vowels.
    @Test
    public void testMoreAsThreeVowels() {
        assertTrue(Main.hasThreeOrMoreVowels("AELKIPO"));
    }

    @Test
    public void testTwoVowels() {
        assertFalse(Main.hasThreeOrMoreVowels("AELKP"));
    }

    @Test
    public void noVowelsTest() {
        assertFalse(Main.hasThreeOrMoreVowels("PPPPPPPP"));
    }

    @Test
    public void noStringinputTest() {
        assertFalse(Main.hasThreeOrMoreVowels(null));
    }

    //Letter Check
    @Test
    public void testHasNoLetters() {
        assertFalse(Main.hasDoubleLetter(null));
    }

    @Test
    public void testDoubleLetter() {
        assertTrue(Main.hasDoubleLetter("DDDDD"));
    }

    @Test
    public void testHasDoubleLetterOnEnd() {
        assertTrue(Main.hasDoubleLetter("ASBCDEFGDD"));
    }

    @Test
    public void testHasNoDoubleLetterOnEnd() {
        assertFalse(Main.hasDoubleLetter("ASBCDEFG"));
    }

    @Test
    public void testHasDoubleLetters() {
        assertTrue(Main.hasDoubleLetter("ASBBCDEFFG"));
    }

    //Alphabetic
//    @Test
//    public void testCanDealWithNull() {
//        assertFalse(Main.isAlphabetic(null));
//    }
//
//    @Test
//    public void testIsAlphabetic(){
//        assertTrue(Main.isAlphabetic("ABCDE"));
//    }
//
//    @Test
//    public void testIsAlphabeticInTheEnd(){
//        assertTrue(Main.isAlphabetic("LONO"));
//    }
//
//    @Test
//    public void testIsNotAlphabeticInTheEnd(){
//        assertFalse(Main.isAlphabetic("ACED"));
//    }

    //hasStrings
    @Test
    public void testNullString(){
        assertFalse(Main.hasStrings(null));
    }

    @Test
    public void testSimpleString() {
        assertFalse(Main.hasStrings("KOPOK"));
    }

    @Test
    public void testSimpleStringIsTrueContainsValue() {
        assertTrue(Main.hasStrings("KOPOKxy"));
    }
}
