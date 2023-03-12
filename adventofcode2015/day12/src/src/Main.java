import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;


public class Main {

    // https://adventofcode.com/2015/day/12
    public static void main(String[] args) throws IOException, ParseException {
        Main main = new Main();
        String s = main.load();
        System.out.println(main.parseToJson(s));
    }

    public int parseToJson(String input) throws ParseException {
        JSONParser parser = new JSONParser();
        Object o = parser.parse(input);
        if (o instanceof JSONArray) {
            return countJsonArray((JSONArray) o, 0);
        }
        if (o instanceof JSONObject) {
            return countJsonObject((JSONObject) o, 0);
        }
        return 0;
    }

    public int countJsonObject(JSONObject jsonObject, int amount) {
        if (jsonObject.isEmpty()) {
            return amount;
        } else {
            Set<Map.Entry<Object, Object>> objectSet = jsonObject.entrySet();
            int totalSize = objectSet.toArray().length;
            for (int i = 0; i < totalSize; i++) {
                Object o = ((Map.Entry) objectSet.toArray()[i]).getValue();
                amount = countAmount(o, amount);
            }
        }
        return amount;
    }

    public int countJsonArray(JSONArray jsonArray, int amount) {
        if (jsonArray.isEmpty()) {
            return amount;
        } else {
            ListIterator it = jsonArray.listIterator();
            while (it.hasNext()) {
                Object o = it.next();
                amount = countAmount(o, amount);
            }
        }
        return amount;
    }

    public int countAmount(Object o, int amount) {
        if (o instanceof JSONArray) {
            amount = countJsonArray((JSONArray) o, amount);
        }
        if (o instanceof JSONObject) {
            amount = countJsonObject((JSONObject) o, amount);
        }

        if (o instanceof String) {
            try {
                amount = amount + Integer.parseInt((String) o);
            } catch (NumberFormatException ex) {
                //is not a number.
            }
        }

        if (o instanceof Long) {
            try {
                amount = amount + ((Long) o).intValue();
            } catch (NumberFormatException ex) {
                //is not a number.
            }
        }
        return amount;
    }

    public String load() throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day12\\input.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        StringBuilder sb = new StringBuilder();
        while ((st = br.readLine()) != null) {
            sb.append(st);
        }
        return sb.toString();
    }
}
