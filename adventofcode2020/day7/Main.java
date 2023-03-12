package adventofcode2020.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static Map<String, String> mapBag = new HashMap<>();

    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {

        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day7\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            addToBagList(st);
        }
        System.out.println(calculateTotalColors(mapBag));
    }

    private static int calculateTotalColors(Map<String, String> mapBag) {
        Set<String> colors= new HashSet<>();

        for ( String key : mapBag.keySet() ) {
            if(doesContainGoldBag(key)) {
                colors.add(key);
            }
        }
        return colors.size();

    }

    public static boolean doesContainGoldBag(String key){
            String value = mapBag.get(key);

            if(value == null){
                return false;
            }

            //checking.
            if(value.contains("shiny gold")){
                return true;
            }else {
                String[] bags = value.split(",");
                for (String bag : bags) {
                    if(doesContainGoldBag(bag.trim())) {
                       return true;
                    }
                }
            }
        return false;
    }

    public static void addToBagList(String bagLine){
        String[] bags = bagLine.replace("bags" , "")
                .replace("bag", "")
                .split("contain");

        String bagName = bags[0].trim();
        String bagContent =  bags[1].replaceAll("\\d","")
                .replaceAll("\\.", "")
                .trim();
        mapBag.put(bagName,bagContent);
    }
}