import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

/**
 * Each wire has an identifier (some lowercase letters) and can carry a 16-bit signal (a number from 0 to 65535).
 * A signal is provided to each wire by a gate, another wire, or some specific value.
 * Each wire can only get a signal from one source, but can provide its signal to multiple destinations.
 * A gate provides no signal until all of its inputs have a signal.
 **/
public class Main {

    public static Main main;
    public HashMap<String, Integer> wireMap = new HashMap<>();
    public List<String> list = new CopyOnWriteArrayList<>();
    public int NOT_YET_SET = -1;
    public int i = 0;

    // https://adventofcode.com/2015/day/7
    public static void main(String[] args) throws IOException {
        main = new Main();
        int result = main.calc();
        System.out.println("result: " + result);
        System.out.println("Took here:"+ main.i);
    }

    public int calc() throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day7\\input.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            list.add(st);
        }


        while (wireAResult() == NOT_YET_SET) {
            ListIterator itr = list.listIterator();
            while(itr.hasNext()){
                String cLine = (String) itr.next();
                boolean result = parseLine(cLine);
                if(result){
                    System.out.println("Executed: " +cLine);
                    list.remove(cLine);
                }
            }
            i++;
        }
        return wireAResult();
    }

    public boolean parseLine(String input) {
        if (input.contains("AND") ||
                input.contains("OR") ||
                input.contains("LSHIFT") ||
                input.contains("RSHIFT")) {

            String[] line = input.split(" ");
            String firstInputName = line[0];
            String secondInputName = line[2];
            String outputName = line[4];

            int a = getValueFromMap(firstInputName);
            int b = 0;
            String cmd = line[1];
            if (!cmd.contains("LSHIFT") &&
                    !cmd.contains("RSHIFT")) {
                b = getValueFromMap(secondInputName);
            }

            switch (cmd) {
                case "AND":
                    if (a != NOT_YET_SET && b != NOT_YET_SET) {
                        assignNumberToWire(outputName, AND(a, b));
                        return true;
                    }
                    break;
                case "OR":
                    if (a != NOT_YET_SET && b != NOT_YET_SET) {
                        assignNumberToWire(outputName, OR(a, b));
                        return true;
                    }
                    break;
                case "LSHIFT":
                    if (a != NOT_YET_SET) {
                        assignNumberToWire(outputName, LSHIFT(Integer.parseInt(line[2]), a));
                        return true;
                    }
                    break;
                case "RSHIFT":
                    if (a != NOT_YET_SET) {
                        assignNumberToWire(outputName, RSHIFT(Integer.parseInt(line[2]), a));
                        return true;
                    }
                    break;
            }
        } else if (input.contains("NOT")) {
            String[] line = input.split(" ");
            String firstWireName = line[1];
            String goesToWireName = line[3];

            if (firstWireName != null &&
                    goesToWireName != null) {
                int firstValue = getValueFromMap(firstWireName);
                if(firstValue != NOT_YET_SET) {
                    assignNumberToWire(goesToWireName, not(firstValue));
                    return true;
                }
            }
        } else {
            //ASSIGNMENT.
            String[] line = input.split(" ");
            int value = getValueFromInput(line[0]);
            String firstWireName = line[2];
            if (firstWireName != null && value != NOT_YET_SET) {
                assignNumberToWire(firstWireName, value);
                return true;
            }
        }
        return false;
    }

    public int getValueFromInput(String input) {
        if (isNumeric(input)) {
            return Integer.parseInt(input);
        } else {
            return getValueFromMap(input);
        }
    }

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public int getValueFromMap(String wireName) {
        if(isNumeric(wireName)){
            return Integer.parseInt(wireName);
        }

        if (wireMap.containsKey(wireName)) {
            return wireMap.get(wireName);
        } else {
            return NOT_YET_SET;
        }
    }

    public void assignNumberToWire(String wire, int op1) {
        System.out.println("Assigned: " + wire + " with value: "+ op1);
        wireMap.put(wire, op1);
    }


    public int OR(int op1, int op2) {
        return op1 | op2;
    }

    public int AND(int op1, int op2) {
        return op1 & op2;
    }

    public int LSHIFT(int shiftTime, int op1) {
        return op1 << shiftTime;
    }

    public int RSHIFT(int shiftTime, int op1) {
        return op1 >> shiftTime;
    }

    /**
     * Apply a bitwise AND operator (&) with the value 0xFFFF to preserve the 16 least significant bits of the inverted result.
     * @param op1
     * @return
     */
    public int not(int op1) {
        return ~op1 & 0xFFFF;
    }

    private int wireAResult() {
        if (wireMap.containsKey("a")) {
            return wireMap.get("a");
        }
        return NOT_YET_SET;
    }
}
