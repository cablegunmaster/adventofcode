import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventOfCode2ATest {
    AdventOfCode2A app;

    @BeforeEach
    void setup() {
        app = new AdventOfCode2A();
    }

    @Test
    void testNumbersConsistentGoingDown_ExpectsTrue() {
        int one = 7;
        int two = 5;

        assertTrue(app.checkConsistentGoingUpOrDown(one, two, true, false));
    }

    @Test
    void testNumbersConsistentGoingDown_ExpectsFalse() {
        int one = 7;
        int two = 9;

        assertEquals(false, app.checkConsistentGoingUpOrDown(one, two, true, false));
    }

    @Test
    void testNumbersConsistentGoingUp_ExpectsTrue() {
        int one = 7;
        int two = 9;

        assertTrue(app.checkConsistentGoingUpOrDown(one, two, false, true));
    }

    @Test
    void testNumbersConsistentGoingUp_ExpectsFalse() {
        int one = 3;
        int two = 1;

        assertFalse(app.checkConsistentGoingUpOrDown(one, two, false, true));
    }
}