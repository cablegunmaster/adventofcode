package adventofcode2a;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class AdventOfCode2A {

    int horizontal;
    int depth;
    int aim;

    /**
     * What do you get if you multiply your final horizontal position by your final depth?
     * 1383564
     */
    public static void main(String args[]) throws IOException {
        new AdventOfCode2A();
    }

    public AdventOfCode2A() throws IOException {
        FileInputStream fr = new FileInputStream("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode2a\\input.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr));) {
            String line;
            while ((line = br.readLine()) != null) {
                //splitString on space.
                String[] output = line.split(" ");
                String action = output[0].toLowerCase(Locale.ROOT);
                int amount = Integer.parseInt(output[1]);
                switch(action){
                    case "forward":
                         horizontal += amount;
                        break;
                    case "down":
                        depth += amount;
                        break;
                    case "up":
                        depth -= amount;
                        break;
                    default:
                        System.out.println("oopsie woopsie owo something went wrong.");
                }
            }
        }
        System.out.println(getDepth());
    }

    public int getDepth(){
        return horizontal * depth;
    }

}
