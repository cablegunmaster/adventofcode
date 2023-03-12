package adventofcode2020.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * Learned dont forget the last data input which needs inputted aswell.
 */
public class Main {

    HashSet<String> list = new HashSet<>();

    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {

        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day6\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Main m = new Main();

        String st;
        int total = 0;
        while ((st = br.readLine()) != null) {

            for (int i = 0, n = st.length(); i < n; i++) {
                String str = Character.toString(st.charAt(i));
                m.list.add(str);
            }

            if(st.equals("")){
                total = total + m.list.size();
                m.list.clear();
            }
        }
        System.out.println(total);
    }
}