package adventofcode2015.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2015\\day1\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int total = 0;
        while ((st = br.readLine()) != null) {

            for (int i = 0, n = st.length(); i < n; i++) {
                String str = Character.toString(st.charAt(i));
                if(str.equals("(")){
                    total = total + 1;
                }

                if(str.equals(")")){
                    total = total - 1;
                }
            }

        }
        System.out.println(total);
    }
}
