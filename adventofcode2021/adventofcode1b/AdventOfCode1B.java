package adventofcode2021.adventofcode1b;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class AdventOfCode1B {

    int largerMeasurement = 0;
    int window = 0;
    int[] numberArray = new int[3]; // default {0,0,0,0}

    int sumA;
    int sumB;

    /**
     * Q1B: Consider sums of a three-measurement sliding window.
     * How many sums are larger than the previous sum?
     * 1858
     */
    public static void main(String args[]) throws Exception {
        new AdventOfCode1B();
    }

    /**
     * count A+B+C = Sum(A+B+C)  if ABC is bigger than last ABC its increased.
     * <p>
     * read 3 numbers.
     * count the numbers up, if it can read a 4th number it can do the calculation.
     * calculation is ABC bigger as BCD? Yes? increase counter. and continue.
     * <p>
     * can use a % modulo sign for it?
     */
    public AdventOfCode1B() throws Exception {
        FileInputStream fr = new FileInputStream("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode1a\\input.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr));) {
            String line;

            while ((line = br.readLine()) != null) {

                if(canCount()){
                    sumA = count();
                }

                setNumberInArray(line);
                if(canCount()){
                    sumB = count();

                    if(sumB > sumA && sumA != 0 && sumB != 0){
                        ++largerMeasurement;
                    }
                }
            }
        }
        System.out.println(largerMeasurement);
    }

    private int count() {
        return (numberArray[0] + numberArray[1] +numberArray[2]);
    }

    private void setNumberInArray(String line) {
        numberArray[window % 3 ] = Integer.parseInt(line);
        window++;
    }

    public boolean canCount() {
        return numberArray[0] != 0
                && numberArray[1] != 0
                && numberArray[2] != 0;
    }
}