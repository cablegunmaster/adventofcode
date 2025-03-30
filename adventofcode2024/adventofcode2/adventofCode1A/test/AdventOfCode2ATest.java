import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode1ATest {

    @Test
    public void testListOneIsSmallerAsListTwoShouldEqualTwo() {
        AdventOfCode1A a1 = new AdventOfCode1A();
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        one.add(5);
        two.add(7);

        assertEquals(2, a1.calcDistanceFromLists(one, two) );
    }

    @Test
    public void testListTwoIsSmallerAsListOneShouldEqualNine() {
        AdventOfCode1A a1 = new AdventOfCode1A();
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        one.add(10);
        two.add(1);

        assertEquals(9, a1.calcDistanceFromLists(one, two) );
    }
}