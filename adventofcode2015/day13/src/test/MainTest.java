import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class MainTest {
    Main m;

    @Before
    public void setUp() throws IOException {
        m = new Main();
        this.load();
    }

    @Test
    public void testAllLikeAroundTableShouldBe330Size() {
        for (Person p : m.list) {
            m.calculatePerPerson(p);
        }
        assertEquals(330, m.maxHappiness);
    }

    @Test
    public void testAllLikeAroundTableShouldBeMainTest() throws IOException {
        Main main = new Main();
        main.load();

        for (Person p : main.list) {
            main.calculatePerPerson(p);
        }
        assertTrue(main.maxHappiness > 605);
        System.out.println(main.maxHappiness);
    }

    public void load() throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day13\\inputTest.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            m.parseLine(st);
        }
    }

    @Test
    public void shouldBeUniqueArray() {
        for (Person p : m.list) {
            m.calculatePerPerson(p);
            assertTrue(isUnique(m.table));
        }
    }

    private boolean isUnique(Table table) {
        return new HashSet<>(Arrays.asList(table.peopleAtTable)).size() == 4;
    }

    @Test
    public void testCleanNameRemovesLastChar() {
        String output = m.cleanName("Henk.");
        assertEquals("Henk", output);
    }

    @Test
    public void getPersonFromTheListNotFoundIsNullByName() {
        Person p = m.getPersonByName("Henk");
        assertNull(p);
    }

    @Test
    public void getPersonFromTheListByNameIsFound() {
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
        assertEquals(54, (int) p.getNeighbourHappinessByName("Bob"));
    }

    @Test
    public void parseStringIsDoneProperlyWithTwoLines() {
        String input = "Alice would gain 54 happiness units by sitting next to Bob.";
        m.parseLine(input);
        input = "Alice would lose 79 happiness units by sitting next to Carol.";
        m.parseLine(input);
        Person p = m.getPersonByName("Alice");

        assertEquals("Alice", p.getName());
        assertEquals(-79, (int) p.getNeighbourHappinessByName("Carol"));
    }

    @Test
    public void getMostLikedPersonUnseatedShouldBeBob() throws IOException {
        m = new Main();
        this.load();

        Person p = m.getPersonByName("Alice");
        Table table = new Table();
        table.setPersonAtTable(p);

        Person likeablePerson = m.getNextUnseatedPerson(m.list, p);
        assertEquals("Bob", likeablePerson.getName());
    }

    @Test
    public void getMostLikedPersonUnseatedShouldBeCarol() throws IOException {
        m = new Main();
        this.load();

        Person p = m.getPersonByName("Bob");
        Table table = new Table();
        table.setPersonAtTable(p);

        Person likeablePerson = m.getNextUnseatedPerson(m.list, p);
        assertEquals("Alice", likeablePerson.getName());
    }

    @Test
    public void getMostLikedPersonUnseatedShouldBeCarolPartTwo() throws IOException {
        m = new Main();
        this.load();

        Person p = m.getPersonByName("David");
        Table table = new Table();
        table.setPersonAtTable(p);

        Person likeablePerson = m.getNextUnseatedPerson(m.list, p);
        assertEquals("Carol", likeablePerson.getName());
    }
}

