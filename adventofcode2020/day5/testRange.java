package adventofcode2020.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRange {

    @Test
    public void testRangeSingleFront(){
        Main m = new Main();
        m.getRange("F");

        assertEquals(64.0, m.range);
        assertEquals(0, m.lowest);
        assertEquals(63, m.highest);
    }

    @Test
    public void testRangeSingleBack() {
        Main m = new Main();
        m.getRange("B");

        assertEquals(64.0, m.range);
        assertEquals(64, m.lowest);
        assertEquals(127, m.highest);
    }

    @Test
    public void testRangeDoubleFront() {
        Main m = new Main();
        m.getRange("FF");

        assertEquals(32, m.range);
        assertEquals(0, m.lowest);
        assertEquals(31, m.highest);
    }

    @Test
    public void testRangeOneFrontOneBack() {
        Main m = new Main();
        m.getRange("FB");

        assertEquals(32, m.range);
        assertEquals(32, m.lowest);
        assertEquals(63, m.highest);
    }

    @Test
    public void testRangeOneBackOneFront() {
        Main m = new Main();
        m.getRange("BF");

        assertEquals(32, m.range);
        assertEquals(64, m.lowest);
        assertEquals(95, m.highest);
    }

    @Test
    public void testRangeDoubleBack() {
        Main m = new Main();
        m.getRange("BB");

        assertEquals(32, m.range);
        assertEquals(96, m.lowest);
        assertEquals(127, m.highest);
    }


    @Test
    public void testRangeTripleBack() {
        Main m = new Main();
        m.getRange("BBB");

        assertEquals(16, m.range);
        assertEquals(112, m.lowest);
        assertEquals(127, m.highest);
    }

    @Test
    public void testRangeTripleFront() {
        Main m = new Main();
        m.getRange("FFF");

        assertEquals(16, m.range);
        assertEquals(0, m.lowest);
        assertEquals(15, m.highest);
    }

    @Test
    public void testRangeBackFrontFront() {
        Main m = new Main();
        m.getRange("BFF");

        assertEquals(16, m.range);
        assertEquals(64, m.lowest);
        assertEquals(79, m.highest);
    }

    @Test
    public void testRange(){
        Main m = new Main();
        m.getRange("FBFBBFF");

        assertEquals(44, m.lowest);
        assertEquals(44, m.highest);
    }


    //Column function.
    @Test
    public void testColumn(){
        Main m = new Main();
        m.getColumn("RLR");

        assertEquals(5, m.getColumn("RLR"));
        assertEquals(4, m.lowest);
        assertEquals(5, m.highest);
    }

    @Test
    public void testColumnDoubleRightLeft(){
        Main m = new Main();
        m.getColumn("RRL");

        assertEquals(6, m.lowest);
        assertEquals(7, m.highest);
    }

    @Test
    public void testColumnTripleRight(){
        Main m = new Main();

        assertEquals(7, m.getColumn("RRR"));
        assertEquals(6, m.lowest);
        assertEquals(7, m.highest);
    }


    @Test
    public void testColumnTripleLeft(){
        Main m = new Main();

        assertEquals(0, m.getColumn("LLL"));
        assertEquals(0, m.lowest);
        assertEquals(1, m.highest);
    }

    @Test
    public void testColumnLeftLeftRight(){
        Main m = new Main();
        m.getColumn("LLR");

        assertEquals(1, m.getColumn("LLR"));
        assertEquals(0, m.lowest);
        assertEquals(1, m.highest);
    }

    @Test
    public void testColumnLeftRightRight(){
        Main m = new Main();
        assertEquals(3, m.getColumn("LRR"));
        assertEquals(2, m.lowest);
        assertEquals(3, m.highest);
    }
}
