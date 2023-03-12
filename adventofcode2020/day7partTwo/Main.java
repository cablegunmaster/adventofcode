package adventofcode2020.day7partTwo;

import java.io.*;
import java.util.*;

// each logic has its own object.
// make object if it has its own logic.
// Contains, so everything inside, minus itself.
public class Main {

    public static void main(String[] args) {
        String debug = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\development\\adventofcode\\src\\adventofcode2020\\day7\\input.txt"));
            List<Bag> allBags = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                allBags.add(new Bag(line));
            }

            for (Bag b : allBags) {
                if(b.getName().equals("shiny gold ")){
                    System.out.println(b.containsNumberOfBags(allBags));
                    break;
                };
            }

        }catch (Exception e ){
            System.out.println("Debug:"+ debug);
        }
    }
}