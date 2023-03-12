package adventofcode2020.day6partTwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {

        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day6\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Main m = new Main();

        String st;
        int total = 0;
        String compare = null;
        while ((st = br.readLine()) != null) {

            if(st.equals("") && compare != null){
                total = total + compare.length();
                compare = null;
            }

            if(!st.equals("")) {
                if (compare == null) {
                    compare = st;
                } else {
                    compare = m.compareLine(st, compare);
                }
            }
        }
        System.out.println(total);
    }

    /**
     * Compare if 2 characters are found in a string
     * @param s1 input string like ex: "abc"
     * @param s2 input string to compare with ex:" bcs"
     * @return output string like ex:"bc" only returning letters which are found in both statements.
     */
    public String compareLine(String s1, String s2) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            String in1 = Character.toString(s1.charAt(i));
            for (int j = 0; j < s2.length(); j++) {
                String in2 = Character.toString(s2.charAt(j));
                if(in1.equals(in2)){
                    sb.append(in1);
                }
            }
        }
        return sb.toString();
    }
}