import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

class AdventOfCode1B {

    /**
     * Day 1: Historian Hysteria
     */
    public static void main(String args[]) throws Exception {

        AdventOfCode1B a1 = new AdventOfCode1B();

        ArrayList<Integer> listOne = new ArrayList<>();
        ArrayList<Integer> listTwo = new ArrayList<>();

        FileInputStream fr = new FileInputStream(
                "F:\\development\\adventofcode\\src\\adventofcode2024\\adventofcode1\\input.txt"
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
        System.out.println(a1.calcSimilarityFromLists(listOne,listTwo));
    }

    public int calcSimilarityFromLists(ArrayList<Integer> one, ArrayList<Integer> two){
        int total= 0;

        for (int i = 0; i < one.size(); i++) {
            int number = one.get(i);
            int similarity = 0;
            for(int j = 0; j < two.size(); j++){
                if(number == two.get(j)){
                    similarity++;
                }
            }
            total += number * similarity;
        }
        return total;
    }
}