package adventofcode2015.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2015\\day3\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int x = 0;
        int y = 0;

        Set<String> set = new HashSet<>();

        while ((st = br.readLine()) != null) {

            for (int i = 0, n = st.length(); i < n; i++) {
                String str = Character.toString(st.charAt(i));

                if(str.equals(">")){
                    ++x;
                }

                if(str.equals("<")){
                    --x;
                }

                if(str.equals("^")){
                    ++y;
                }

                if(str.equals("v")){
                    --y;
                }
                set.add(x+","+y);
            }
        }
        System.out.println(set.size());
    }
}
