import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode1BTest {

    AdventOfCode1B app;

    @BeforeEach
    void setup() {
        app = new AdventOfCode1B();
    }

    @Test
    public void testListOneHasANumberFiveAndSimilarityOfOneEqualsOutputOfFive() {
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        one.add(5);
        one.add(1);
        one.add(1);
        two.add(2);
        two.add(2);
        two.add(5);

        assertEquals(5, app.calcSimilarityFromLists(one, two));
    }

    @Test
    public void testListOneHasANumberSixAndSimilarityOfTwoEqualsOutputOfTwelve() {
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();

        one.add(6);
        one.add(2);
        one.add(1);
        two.add(6);
        two.add(6);
        two.add(3);

        assertEquals(12, app.calcSimilarityFromLists(one, two));
    }
}