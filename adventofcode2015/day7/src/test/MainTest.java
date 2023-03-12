import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void setXWire() {
        Main m = new Main();
        m.parseLine("123 -> x");
        assertTrue(123 == m.wireMap.get("x"));
    }

    @Test
    public void setYWire() {
        Main m = new Main();
        m.parseLine("456 -> y");
        assertTrue(456 == m.wireMap.get("y"));
    }

    @Test
    public void checkAndFunction(){
        Main m = new Main();
        m.parseLine("123 -> x");
        m.parseLine("456 -> y");
        m.parseLine("x AND y -> d");

        assertTrue(72 == m.wireMap.get("d"));
    }

    @Test
    public void checkOrFunction() {
        Main m = new Main();
        m.parseLine("123 -> x");
        m.parseLine("456 -> y");
        m.parseLine("x OR y -> e");

        assertTrue(507 == m.wireMap.get("e"));
    }

    @Test
    public void checkLShiftFunction() {
        Main m = new Main();
        m.parseLine("123 -> x");
        m.parseLine("x LSHIFT 2 -> f");

        assertTrue(492 == m.wireMap.get("f"));
    }

    @Test
    public void checkRShiftFunction() {
        Main m = new Main();
        m.parseLine("456 -> y");
        m.parseLine("y RSHIFT 2 -> g");

        assertTrue(114 == m.wireMap.get("g"));
    }

    @Test
    public void checkNotFunction() {
        Main m = new Main();
        m.parseLine("123 -> x");
        m.parseLine("456 -> y");
        m.parseLine("NOT x -> h");
        m.parseLine("NOT y -> i");

        assertTrue(65412 == m.wireMap.get("h"));
        assertTrue(65079 == m.wireMap.get("i"));
    }
}
