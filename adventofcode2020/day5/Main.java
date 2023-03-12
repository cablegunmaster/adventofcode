package adventofcode2020.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    double range = 128;
    double highest = 127;
    double lowest = 0;
    int highestSeatId;

    //https://adventofcode.com/2020/day/5
    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {

        Main m = new Main();
        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day5\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            //0-6 will be F or B

            //0 will indicate (front or back )
            // 0-63 or 64 - 127
            int row = m.getRange(st.substring(0,7));
            int column = m.getColumn(st.substring(7,10));

            int seatId = (row * 8) + column;
            if(seatId > m.highestSeatId){
                m.highestSeatId = seatId;
            }
        }
        System.out.println(m.highestSeatId);
    }

    /**
     * @param upperOrLower 7 characters consisting of F and B which corresponds to
     *                     Front and Back
     */
    public int getRange(String upperOrLower) {

        if (upperOrLower != null) {

            //Reset based on range.
            range = 128;
            highest = 127;
            lowest = 0;

            for (int i = 0, n = upperOrLower.length(); i < n; i++) {
                String str = Character.toString(upperOrLower.charAt(i));

                range = Math.ceil(range / 2);
                //first half
                if (str.equals("F")) {
                    highest = highest - range;
                }

                //second half
                if (str.equals("B")) {
                    lowest = highest - range + 1;
                }
            }

        }
        return (int) lowest;
    }

    public int getColumn(String column){
        range = 8;
        lowest = 0;
        highest = 7;

        if(column != null){

            for (int i = 0, n = column.length() -1; i < n; i++) {
                String str = Character.toString(column.charAt(i));

                range = Math.ceil(range / 2);
                if (str.equals("L")) {
                    highest = highest - range;
                }

                if (str.equals("R")) {
                    lowest = highest - range + 1;
                }
            }
        }

        assert column != null;
        String str = Character.toString(column.charAt(column.length() -1));
        if (str.equals("L")) {
            return (int) lowest;
        }else{
            return (int) highest;
        }
    }
}
