import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void getCoordinates(){
        Main m = new Main();

        m.getCoordinates("toggle 678,333 through 752,957");
        assertEquals(678, m.coordinates[0]);
        assertEquals(333, m.coordinates[1]);
        assertEquals(752, m.coordinates[2]);
        assertEquals(957, m.coordinates[3]);

        m.getCoordinates("turn on 678,333 through 752,957");
        assertEquals(678, m.coordinates[0]);
        assertEquals(333, m.coordinates[1]);
        assertEquals(752, m.coordinates[2]);
        assertEquals(957, m.coordinates[3]);

        m.getCoordinates("turn off 678,333 through 752,957");
        assertEquals(678, m.coordinates[0]);
        assertEquals(333, m.coordinates[1]);
        assertEquals(752, m.coordinates[2]);
        assertEquals(957, m.coordinates[3]);
    }

    @Test
    public void testToSeeIf9LightsAreOn(){
        Main m = new Main();
        m.lights = new int[3][3];
        m.fillSquaresWithValue(0,0,
                2,2,
                1);
        assertEquals(9, m.amountOfLightsOn());
    }

    @Test
    public void testToSeeIfCounterWorks(){
        Main m = new Main();
        m.lights = new int[1][1];
        m.fillSquaresWithValue(0,0,0,0,Main.ON);

        assertEquals(1, m.amountOfLightsOn());
    }

    @Test
    public void testToSeeIfCounterWorksBoundaryMax(){
        Main m = new Main();
        m.lights = new int[3][3];
        m.fillSquaresWithValue(0,0,2,2,Main.ON);

        assertEquals(9, m.amountOfLightsOn());
    }

    @Test
    public void testToSeeIfSomeCanBeTurnedOff(){
        Main m = new Main();
        m.fillSquaresWithValue(0,0, 999,999, Main.ON); //turn all on.
        m.fillSquaresWithValue(499,499,500,500, Main.OFF); // turn 4 off.

        assertEquals(999996, m.amountOfLightsOn());
    }

    @Test
    public void testAllLightsAreOn(){
        Main m = new Main();
        m.fillSquaresWithValue(0,0, 999,999, Main.ON);

        assertEquals(1000000, m.amountOfLightsOn());
    }

    @Test
    public void testAllLightsAreOff(){
        Main m = new Main();
        assertEquals(0, m.amountOfLightsOn());
    }

    @Test
    public void testAllLightsAreZero(){
        Main m = new Main();
        m.fillSquaresWithZero();
        assertEquals(0, m.amountOfLightsOn());
    }

    @Test
    public void toggleSquaresWithValue(){
        Main m = new Main();
        m.toggleSquares(0,0, 999,999);
        assertEquals(2000000, m.amountOfLightsOn());
    }
}
