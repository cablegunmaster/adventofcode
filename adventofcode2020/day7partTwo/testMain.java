package adventofcode2020.day7partTwo;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMain {

    @Test
    public void testGetBagsExampleTest() throws IOException {
        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day7partTwo\\src\\test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<Bag> allBags = new ArrayList<>();
        String st;
        while ((st = br.readLine()) != null) {
            allBags.add(new Bag(st));
        }

        Bag bag = null;
        for (Bag b : allBags) {
            if(b.getName().equals("shiny gold ")){
                bag = b;
                break;
            }
        }

        assertEquals(126, (bag.containsNumberOfBags(allBags) - 1) );
    }

    /**
     * So, a single shiny gold bag must contain:
     * 1 dark olive bag (and the 7 bags within it) plus 2 vibrant plum bags
     * (and the 11 bags within each of those): 1 + 1*7 + 2 + 2*11 = 32 bags!
     *
     * @throws IOException
     */
    @Test
    public void testGetBagsExampleOne() throws IOException {
        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day7partTwo\\src\\test1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<Bag> allBags = new ArrayList<>();
        String st;
        while ((st = br.readLine()) != null) {
            allBags.add(new Bag(st));
        }

        Bag bag = null;
        for (Bag b : allBags) {
            if(b.getName().equals("shiny gold ")){
                bag = b;
                break;
            }
        }

       assertEquals(32, (bag.containsNumberOfBags(allBags) - 1) );
    }
}
