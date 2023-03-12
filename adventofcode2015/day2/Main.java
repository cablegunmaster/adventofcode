package adventofcode2015.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
            int smallestSide = 0;

            String input[] = st.split("x");
            l = Integer.parseInt(input[0]);
            w = Integer.parseInt(input[1]);
            h = Integer.parseInt(input[2]);
            smallestSide = 0;

            int sideA = l * w;
            int sideB = w * h;
            int sideC = h * l;

            if (sideA < sideB && sideA < sideC){
                smallestSide = sideA;
            }

            if(sideA == sideB && sideA < sideC) {
                smallestSide = sideA;
            }

            if (sideB < sideA && sideB < sideC){
                smallestSide = sideB;
            }

            if(sideB == sideC && sideB < sideA) {
                smallestSide = sideB;
            }

            if (sideC < sideA && sideC < sideB){
                smallestSide = sideC;
            }

            if(sideA == sideC && sideC < sideB) {
                smallestSide = sideC;
            }

            if (sideA == sideB && sideA == sideC) {
                smallestSide = sideA;
            }

            if (smallestSide == 0) {
                throw new RuntimeException();
            }

            total = (2 * sideA + 2 * sideB + 2 * sideC) + smallestSide + total;

        }
        System.out.println(total);
    }
}
