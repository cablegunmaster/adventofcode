import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class AdventOfCode1A {

    /**
     * Day 1: Historian Hysteria
     */
    public static void main(String args[]) throws Exception {

        AdventOfCode1A a1 = new AdventOfCode1A();

        ArrayList<Integer> listOne = new ArrayList<>();
        ArrayList<Integer> listTwo = new ArrayList<>();

        FileInputStream fr = new FileInputStream(
                "F:\\development\\adventofcode\\src\\adventofcode2024\\adventofcode1a\\input.txt"
        );

        //Add to list.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr));) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("   ");
                listOne.add(Integer.parseInt(arr[0]));
                listTwo.add(Integer.parseInt(arr[1]));
            }
        }

        //sort it by shortest.
        Collections.sort(listOne);
        Collections.sort(listTwo);

        System.out.println(a1.calcDistanceFromLists(listOne,listTwo));
    }

    public int calcDistanceFromLists(ArrayList<Integer> one, ArrayList<Integer> two){
        int total= 0;
        //calculate the difference between.
        for (int i = 0; i < one.size(); i++) {
            if(two.get(i) > one.get(i)) {
                total += two.get(i) - one.get(i);
            }else {
                total += one.get(i) - two.get(i);
            }
        }
        return total;
    }
}