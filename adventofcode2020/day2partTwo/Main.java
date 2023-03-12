package adventofcode2020.day2partTwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        getList();
    }

    private static void getList() throws IOException {
        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day2partTwo\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int passwordValid = 0;

        String st;
        while ((st = br.readLine()) != null){

            String content[] = st.split(" ");

            //Get low high string.
            String amountLowHigh = content[0]; //1-3
            String[] lowHigh = amountLowHigh.split("-");
            int low = Integer.parseInt(lowHigh[0]);
            int high = Integer.parseInt(lowHigh[1]);

            String letterRule = content[1]; //a:
            char needle = letterRule.charAt(0);
            String stack = content[2].trim(); // " ish "
            if(IsValid(low,high,needle,stack)){
                passwordValid++;
            };
        }

        System.out.println(passwordValid);
    }

    private static boolean IsValid(int locationA,
                                   int locationB,
                                   char needle,
                                   String stack){
        char b;
        try {
            b = stack.charAt(locationB - 1);
        }catch (StringIndexOutOfBoundsException ex) {
            b = 1;
        }

        return (stack.charAt(locationA - 1) == needle && b != needle) ||
                (stack.charAt(locationA - 1) != needle && b == needle);
    }

}