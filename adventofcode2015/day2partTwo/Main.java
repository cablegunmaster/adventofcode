package adventofcode2015.day2partTwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2015\\day2\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int total = 0;
        while ((st = br.readLine()) != null) {

            int l;
            int w;
            int h;

            String[] input = st.split("x");
            int[] intArray = Arrays.stream(input)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            sort(intArray);

            l = intArray[0];
            w = intArray[1];
            h = intArray[2];

            total = l + l + w + w + (l*w*h) + total;
        }
        System.out.println(total);
    }
}
