import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    Main m;

    @Before
    public void setUp() throws Exception {
        m = new Main();
        m.load();
    }

    @Test
    public void AssertArrayJsonObjectIsCountedUpToSix() throws ParseException {
        //prepare
        String input = "[1,2,3]";

        //test
        int output = m.parseToJson(input);

        //assert
        assertEquals("test to see if all numbers in array count to 6", 6, output);
    }

    @Test
    public void testIsObjectCountUpIsSix() throws ParseException {
        //prepare
        String input = "{\"a\":2,\"b\":4}";

        //test
        int output = m.parseToJson(input);

        //assert
        assertEquals("test to see increment to 6 with object input", 6, output);
    }

    @Test
    public void IsArrayJsonObjectThree() throws ParseException {
        //prepare
        String input = "[[[3]]]";

        //test
        int output = m.parseToJson(input);

        //assert
        assertEquals("test to see array counts up to 3", 3, output);
    }

    @Test
    public void IsObjectEqualToThree() throws ParseException {
        //prepare
        String input = "{\"a\":{\"b\":4},\"c\":-1}";

        //test
        int output = m.parseToJson(input);

        //assert
        assertEquals("test to see Object content count up to 3", 3, output);
    }

    @Test
    public void IsObjectAndArrayEqualToZero() throws ParseException {
        //prepare
        String input = "{\"a\":[-1,1]}";

        //test
        int output = m.parseToJson(input);

        //assert
        assertEquals("test to see Object and Array content count up to 0", 0, output);
    }

    @Test
    public void IgnoreObjectWithREDasValueCountsToFour() throws ParseException {
        //prepare
        String input = "[1,{\"c\":\"red\",\"b\":2},3]";

        //test
        int output = m.parseToJson(input);

        //assert
        assertEquals("test to see Object and Array content count up to 4 RED IGNORE", 4, output);
    }

    @Test
    public void IgnoreArrayWithREDasValueHasNoEffect() throws ParseException {
        //prepare
        String input = "[1,\"red\",5]";

        //test
        int output = m.parseToJson(input);

        //assert
        assertEquals("test to see Array with Red in it is still counted", 6, output);
    }

    @Test
    public void IgnoreObjectWithREDasValueCountsToZero() throws ParseException {
        //prepare
        String input = "{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}";

        //test
        int output = m.parseToJson(input);

        //assert
        assertEquals("test to see ignore object 0 RED", 0, output);
    }

    @Test
    public void IsEmptyObjectEqualToZero() throws ParseException {
        //prepare
        String input = "{}";

        //test
        int output = m.parseToJson(input);

        //assert
        assertEquals("test to see if empty Object is 0", 0, output);
    }

    @Test
    public void IsEmptyArrayEqualToZero() throws ParseException {
        //prepare
        String input = "[]";

        //test
        int output = m.parseToJson(input);

        //assert
        assertEquals("test to see if empty array is 0", 0, output);
    }
}

