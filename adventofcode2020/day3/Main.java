package adventofcode2020.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //https://adventofcode.com/2020/day/3
    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {

        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day3\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        List<String> forest = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            forest.add(st);
        }

       System.out.println(
       amountOfTreesHitByIdiot(forest, 1,1)  + " " +
       amountOfTreesHitByIdiot(forest, 3, 1) + " " +
       amountOfTreesHitByIdiot(forest, 5, 1) + " " +
       amountOfTreesHitByIdiot(forest, 7, 1) + " " +
       amountOfTreesHitByIdiot(forest, 1, 2));
        //(MULTIPLY ALL TOGETHER.)
        //5007658656
    }

    public static int amountOfTreesHitByIdiot(List<String> forest,
                                       Integer xAxis,
                                       Integer yAxis){
        //check if tree is found # should be a tree.
        int treeFound = 0;
        int location = 0;

        for (int i = 0; i <= forest.size(); i +=yAxis) {
            location = (location + xAxis) % 31;
            try {
                if (forest.get(i + yAxis).charAt(location) == '#') {
                    treeFound++;
                }
            }catch(IndexOutOfBoundsException ignored){ }
        }
        return treeFound;
    }
}
