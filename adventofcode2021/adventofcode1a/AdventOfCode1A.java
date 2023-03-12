package adventofcode1a;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class AdventOfCode1A {

    /**
     * Q1A: How many measurements are larger than the previous measurement?
     * 1832
     */
    public static void main(String args[]) throws Exception {

        int largerMeasurement = 0;
        int formerDepth = 0;

        FileInputStream fr = new FileInputStream(
                "D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode1a\\input.txt"
        );

        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr));) {
            String line;
            while ((line = br.readLine()) != null) {
                int currentDepth = Integer.parseInt(line);
                if (formerDepth != 0 && currentDepth > formerDepth) {
                    largerMeasurement++;
                }
                formerDepth = currentDepth;
            }
        }
        System.out.println(largerMeasurement);
    }
}