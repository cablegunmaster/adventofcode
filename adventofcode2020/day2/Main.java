package adventofcode2020.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       getList();
    }

    public static void getList() throws IOException {
        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day2\\input.txt");
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

    private static boolean IsValid(int low, int high , char needle, String stack){
        int amount = 0;
        for (int i = 0; i < stack.length() ; i++) {
            if(stack.charAt(i) == needle){
                 amount++;
            }
        }
        return amount >= low && amount <= high;
    }

}