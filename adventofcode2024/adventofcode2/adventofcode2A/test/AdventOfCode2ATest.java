import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode2ATest {

    @Test
    public void testNumbersConsistentGoingDown_ExpectsTrue() {
        AdventOfCode2A a = new AdventOfCode2A();

        int one = 7;
        int two = 5;

        assertEquals(true, a.checkConsistentGoingUpOrDown(one, two, true, false));
    }

    @Test
    public void testNumbersConsistentGoingDown_ExpectsFalse() {
        AdventOfCode2A a = new AdventOfCode2A();

        int one = 7;
        int two = 9;

        assertEquals(false, a.checkConsistentGoingUpOrDown(one, two, true, false) );
    }

    @Test
    public void testNumbersConsistentGoingUp_ExpectsTrue() {
        AdventOfCode2A a = new AdventOfCode2A();

        int one = 7;
        int two = 9;

        assertEquals(true, a.checkConsistentGoingUpOrDown(one, two, false, true) );
    }

    @Test
    public void testNumbersConsistentGoingUp_ExpectsFalse() {
        AdventOfCode2A a = new AdventOfCode2A();

        int one = 3;
        int two = 1;

        assertEquals(false, a.checkConsistentGoingUpOrDown(one, two, false, true) );
    }
}