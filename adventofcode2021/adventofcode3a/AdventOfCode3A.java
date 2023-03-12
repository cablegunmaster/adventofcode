package adventofcode3a;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AdventOfCode3A {

    int[] commonBit = new int[12];
    List<String> list = new ArrayList<>();

    /**
     *  Q3A:What is the power consumption of the submarine? (Be sure to represent your answer in decimal, not binary.)
     *  2498354
     */
    public static void main(String[] args) throws IOException {
        new AdventOfCode3A();
    }

    /**
     * Get power consumption multiply Gamma and Epsilon and get a decimal number out of it
     * Using something called a common bit? what is a common bit?
     * Get Two new Binary numbers somehow out of a range of bits?
     * "most common bit in the corresponding position"
     */
    public AdventOfCode3A() throws IOException {

        //read input.
        FileInputStream fr = new FileInputStream("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode3a\\input.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr));) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        }


        //get Common Bit for 12 diff locations out of X amount.
        for (String word : list) {
            //for each word in the list.

            //not counting the 11th index was the error 0-11
            for (int j = 0; j <= 11; j++) {
                char c = word.charAt(j);
                //for each symbol

                //if 1 add +1
                if (c == 49) {
                    commonBit[j] += 1; // increase counter
                }
                //if 0 add -1
                if (c == 48) {
                    commonBit[j] -= 1; // lowers counter
                }
            }
        }
        System.out.println(multiplyGammaAndEpsilon());
    }

    public String getCommonBitFromArray(){
        StringBuilder output = new StringBuilder();

        for (int j : commonBit) {
            if (j > 0) {
                output.append("1");
            }
            if (j < 0) {
                output.append("0");
            }
        }
        return output.toString(); //needs to be 12 long.
    }

    public String getLeastCommonBitFromArray(){
        StringBuilder output = new StringBuilder();

        for (int j : commonBit) {
            if (j > 0) {
                output.append("0");
            }
            if (j < 0) {
                output.append("1");
            }
        }
        return output.toString();
    }

    public int multiplyGammaAndEpsilon(){
        return Integer.parseInt(getCommonBitFromArray(),2) * Integer.parseInt(getLeastCommonBitFromArray(),2);
    }
}
