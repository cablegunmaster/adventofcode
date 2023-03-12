package adventofcode2020.day6partTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class comparison {


    @Test
    public void testSimpleCompareSingleLine(){
        Main m = new Main();
        String s1 = "abc";
        String s2 = "bc";

        assertEquals("bc", m.compareLine(s1, s2));
    }

    @Test
    public void testSimpleSingleLine(){
        Main m = new Main();
        String s1 = "acb";
        String s2 = "bc";
        String s3 = "c";

        String result = m.compareLine(s1,s2);
        assertEquals("c", m.compareLine(result, s3));
    }
}
