import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class AdventOfCode3B {

    /**
     * Day 3: Mull It Over
     */
    public static void main(String args[]) throws Exception {

        AdventOfCode3B b = new AdventOfCode3B();
        FileInputStream fr = new FileInputStream(
                "F:\\development\\adventofcode\\src\\adventofcode2024\\adventofcode3\\input.txt"
        );

        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr));) {
            String line;
            while ((line = br.readLine()) != null) {
//                String[] strArr = line.split(" ");
//
//                int[] intArray = Arrays.stream(strArr)
//                        .mapToInt(Integer::parseInt)
//                        .toArray();

            }
        }
    }
}