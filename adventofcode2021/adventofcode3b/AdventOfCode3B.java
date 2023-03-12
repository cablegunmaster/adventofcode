package adventofcode3b;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdventOfCode3B {

    List<String> inputList = new ArrayList<>();

    /**
     * Get power consumption multiply Gamma and Epsilon and get a decimal number out of it
     * Using something called a common bit? what is a common bit?
     * Get Two new Binary numbers somehow out of a range of bits?
     * "most common bit in the corresponding position"
     *
     * @param args none.
     * @throws IOException anything with IOException.
     */
    public static void main(String args[]) throws IOException {
        new AdventOfCode3B();
    }

    public AdventOfCode3B() throws IOException {

        //read input.
        FileInputStream fr = new FileInputStream("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode3a\\input.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr));) {
            String line;
            while ((line = br.readLine()) != null) {
                inputList.add(line);
            }
        }
        System.out.println(printLifeSupportRating());
    }

    public int printLifeSupportRating() {
        //System.out.println(getOxygenNumber(inputList, 0));
        //System.out.println(getCo2Rating(inputList, 0));

        return Integer.parseInt(getOxygenNumber(inputList, 0), 2) *
               Integer.parseInt(getCo2Rating(inputList, 0), 2);
    }

    /**
     * get narrowed down from left the most common in a string.
     * check most common bit and if 2 equals 1.
     * Keep the number with 1.
     */
    public String getOxygenNumber(List<String> list, int index) {
        int commonBit = getCommonBit(list,index);
        int finalIndex = index;

        //filter.
        List<String> filtered =
                list.stream()
                        .filter(c -> c.charAt(finalIndex) == commonBit)
                        .collect(Collectors.toList());

        if (filtered.size() == 1) {
            return filtered.get(0); //should be able to do as 1 is left.
        } else {
            return getOxygenNumber(filtered, ++index);
        }
    }

    /**
     * Keep the number with 0.
     */
    public String getCo2Rating(List<String> list, int index) {
        int unCommonBit = getUncommonBit(list,index);
        int finalIndex = index;

        //filter.
        List<String> filtered =
                list.stream()
                        .filter(c -> c.charAt(finalIndex) == unCommonBit)
                        .collect(Collectors.toList());

        if (filtered.size() == 1) {
            return filtered.get(0); //should be able to do as 1 is left.
        } else {
            return getCo2Rating(filtered, ++index);
        }
    }

    private int countCharAtIndex(List<String> list, int index) {
        int counter = 0;
        for (String word : list) {
            char c = word.charAt(index);
            //if 1 add +1
            if (c == 49) {
                ++counter; // increase counter
            }
            //if 0 add -1
            if (c == 48) {
                --counter; // lowers counter
            }
        }
        return counter;
    }

    private int getCommonBit(List<String> list, int index) {
        return (getCommonBitOnIndex(list, index) == 1) ? 49 : 48;
    }

    private int getUncommonBit(List<String> list, int index) {
        return (getLeastCommonBitOnIndex(list, index) == 1) ? 49 : 48;
    }

    private int getCommonBitOnIndex(List<String> list, int index) {
        return (countCharAtIndex(list, index) >= 0) ? 1 : 0;
    }

    private int getLeastCommonBitOnIndex(List<String> list, int index) {
        return countCharAtIndex(list, index) >= 0 ? 0 : 1;
    }

}
