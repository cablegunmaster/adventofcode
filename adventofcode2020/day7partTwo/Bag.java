package adventofcode2020.day7partTwo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bag {

    private Map<String, Integer> contains = new HashMap<>();
    String name;

    public Bag(String rule){
        String[] sArr = rule.split("bags contain ");
        name = sArr[0];
        rule = sArr[1];

        Pattern p = Pattern.compile("(\\d+) (\\w+ \\w+)");

        for(String s: rule.split(",")){
            s = s.replaceAll("bags*[,.]\\.*", "").trim();
            Matcher m = p.matcher(s);
            if(m.find()){
                int num = Integer.parseInt(m.group(1));
                String name = m.group(2);
                contains.put(name,num);
            }
        }
    }

    public String getName() {
        return name;
    }

    private Bag findBag(List<Bag> allBags, String name){
        for(Bag b : allBags) {
            if (b.getName().trim().equals(name)) {
                return b;
            }
        }
        return null;
    }

    public long containsNumberOfBags(List<Bag> allBags) {
        long numOfBags = 1;
        for (Map.Entry<String, Integer> bag : contains.entrySet()){
            Bag foundbag = findBag(allBags, bag.getKey());
            numOfBags += bag.getValue() * foundbag.containsNumberOfBags(allBags);
        }
        return numOfBags;
    }
}
