import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode3ATest {

    AdventOfCode3A app;

    @BeforeEach
    void setup() {
        app = new AdventOfCode3A();
    }

    String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
    String inputSimpleRight = "mul(2,4)";
    String inputWrong = "mul[2,4]";

    @Test
    void testNumbersConsistentGoingDown_ExpectsTrue() {
        AdventOfCode3A a = new AdventOfCode3A();

        String[] k = a.getInputStatements(input);
        assertEquals("2,4", k[0]);
        assertEquals("5,5", k[1]);
        assertEquals("11,8", k[2]);
        assertEquals("8,5", k[3]);
    }

    @Test
    void testIfStatementIsCorrect() {

    }
}