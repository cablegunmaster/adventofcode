import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MainTest {

    Main m;

    @Before
    public void setUp() {
        m = new Main();
    }

    @Test
    public void testCleanNameRemovesLastChar(){
        String output = m.cleanName("Henk.");
        assertEquals("Henk",output);
    }

    @Test
    public void getPersonFromTheListNotFoundIsNullByName(){
        Person p = m.getPersonByName("Henk");
        assertNull(p);
    }

    @Test
    public void getPersonFromTheListByNameIsFound(){
        m.list.add(new Person("Henk"));
        Person p = m.getPersonByName("Henk");
        assertEquals("Henk", p.getName());
    }

    @Test
    public void parseStringIsDoneProperly() {
        String input = "Alice would gain 54 happiness units by sitting next to Bob.";
        m.parseLine(input);
        Person p = m.getPersonByName("Alice");

        assertEquals("Alice", p.getName());
        assertEquals(54, (int) p.neighbourHappiness.get("Bob"));
    }

    @Test
    public void parseStringIsDoneProperlyWithTwoLines() {
        String input = "Alice would gain 54 happiness units by sitting next to Bob.";
        m.parseLine(input);
         input = "Alice would lose 79 happiness units by sitting next to Carol.";
        m.parseLine(input);
        Person p = m.getPersonByName("Alice");

        assertEquals(1, m.list.size());
        assertEquals("Alice", p.getName());
        assertEquals(-79, (int) p.neighbourHappiness.get("Carol"));
    }
}

