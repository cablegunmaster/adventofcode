import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class MainTest {

    private int calcLongestRoute(Main m) throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day9\\testInput.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            Location.LocationBuilder locationBuilder = new Location.LocationBuilder().inputA(st);
            m.setLocation(locationBuilder);
            Location.LocationBuilder locationBuilder2 = new Location.LocationBuilder().inputB(st);
            m.setLocation(locationBuilder2);
        }
        return m.getDistance();
    }

    @Test
    public void checkLocationIsBuild(){
        Main m = new Main();

        Location.LocationBuilder locationBuilder = new Location.LocationBuilder().inputA("London to Dublin = 464");
        m.setLocation(locationBuilder);

        Location.LocationBuilder locationBuilder2 = new Location.LocationBuilder().inputB("London to Dublin = 464");
        m.setLocation(locationBuilder2);

        assertEquals(2,m.list.size());
    }

    @Test
    public void checkLocationAWithMultipleLocations(){
        Main m = new Main();

        Location.LocationBuilder locationBuilder = new Location.LocationBuilder().inputA("London to Dublin = 464");
        m.setLocation(locationBuilder);

        Location.LocationBuilder locationBuilder3 = new Location.LocationBuilder().inputA("London to Belfast = 518");
        m.setLocation(locationBuilder3);

        assertEquals(1,m.list.size());
    }

    @Test
    public void checkMultipleLocationBWithSingleLocation(){
        Main m = new Main();

        Location.LocationBuilder locationBuilder = new Location.LocationBuilder().inputB("London to Dublin = 464");
        m.setLocation(locationBuilder);

        Location.LocationBuilder locationBuilder3 = new Location.LocationBuilder().inputB("London to Belfast = 518");
        m.setLocation(locationBuilder3);

        assertEquals(2,m.list.size());
    }

    @Test
    public void checkLocationBWithMultipleLocations(){
        Main m = new Main();

        Location.LocationBuilder locationBuilder = new Location.LocationBuilder().inputB("Dublin to London = 464");
        m.setLocation(locationBuilder);

        Location.LocationBuilder locationBuilder3 = new Location.LocationBuilder().inputB("Belfast to London = 518");
        m.setLocation(locationBuilder3);

        assertEquals(1,m.list.size());
    }

    @Test
    public void checkLocationWithMultipleLocationsAreBuild(){
        Main m = new Main();

        Location.LocationBuilder locationBuilder = new Location.LocationBuilder().inputA("London to Dublin = 464");
        m.setLocation(locationBuilder);

        Location.LocationBuilder locationBuilder2 = new Location.LocationBuilder().inputB("London to Dublin = 464");
        m.setLocation(locationBuilder2);

        Location.LocationBuilder locationBuilder3 = new Location.LocationBuilder().inputA("London to Belfast = 518");
        m.setLocation(locationBuilder3);

        Location.LocationBuilder locationBuilder4 = new Location.LocationBuilder().inputB("London to Belfast = 518");
        m.setLocation(locationBuilder4);

        Location.LocationBuilder locationBuilder5 = new Location.LocationBuilder().inputA("Dublin to Belfast = 141");
        m.setLocation(locationBuilder5);

        Location.LocationBuilder locationBuilder6 = new Location.LocationBuilder().inputB("Dublin to Belfast = 141");
        m.setLocation(locationBuilder6);

        assertEquals(3,m.list.size());
    }

    @Test
    public void checkLongestRouteTest() throws IOException {
        assertEquals(982, calcLongestRoute(new Main()));
    }
}

