package adventofcode2020.day1part2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> list = getList();
        computeList(list);
    }

    public static List<Integer> getList() throws IOException {
        List<Integer> list = new ArrayList<Integer>();
        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day1\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            list.add(Integer.parseInt(st));
        return list;
    }

    private static void computeList(List<Integer> list) {
        for (Integer firstNumber : list) {
            for (Integer secondNumber : list) {
                for(Integer thirdNumber: list) {
                    if (areNumberTogether2020(
                            firstNumber,
                            secondNumber,
                            thirdNumber)
                    ) {
                        System.out.println(firstNumber * secondNumber * thirdNumber);
                    }
                }
            }
        }
    }

    private static boolean areNumberTogether2020(Integer a,
                                                Integer b,
                                                Integer c) {
        return (a + b + c) == 2020;
    }
}