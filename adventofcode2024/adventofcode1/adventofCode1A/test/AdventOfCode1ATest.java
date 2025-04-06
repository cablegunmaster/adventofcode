import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode1ATest {

    AdventOfCode1A app;

    @BeforeEach
    void setup() {
        app = new AdventOfCode1A();
    }

    @Test
    public void testListOneIsSmallerAsListTwoShouldEqualTwo() {
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        one.add(5);
        two.add(7);

        assertEquals(2, app.calcDistanceFromLists(one, two));
    }

    @Test
    public void testListTwoIsSmallerAsListOneShouldEqualNine() {
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        one.add(10);
        two.add(1);

        assertEquals(9, app.calcDistanceFromLists(one, two));
    }
}