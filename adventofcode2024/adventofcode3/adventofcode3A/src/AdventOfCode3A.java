import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class AdventOfCode3A {

    int digit1 = 0;
    int digit2 = 0;

    /**
     * Day 3: Mull It Over
     */
    public static void main(String args[]) throws Exception {

        AdventOfCode3A app = new AdventOfCode3A();
        FileInputStream fr = new FileInputStream(
                "F:\\development\\adventofcode\\src\\adventofcode2024\\adventofcode3\\input.txt"
        );

        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr));) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] output = app.splitLineOnMulOpening(line);
                for (String input : output) {
                    if(app.isValidMultiplication(input)){

                    }
                }
            }
        }
    }

    public String[] splitLineOnMulOpening(String line) {
        return line.split("mul");
    }

    public boolean isValidMultiplication(String input) {
        digit1 = 0;
        digit2 = 0;

        String openingChat = "(";
        int digit1;
        String isCommaFound = ",";
        int digit2;
        String endChar = ")";
        return true;
    }

    public boolean isDigit(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}