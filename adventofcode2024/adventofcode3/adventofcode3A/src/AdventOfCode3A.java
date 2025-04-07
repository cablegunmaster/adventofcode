import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AdventOfCode3A {

    StringBuilder firstDigit = new StringBuilder();
    StringBuilder secondDigit = new StringBuilder();
    Integer result = 0;

    /**
     * Day 3: Mull It Over
     */
    public static void main(String[] args) throws Exception {

        AdventOfCode3A app = new AdventOfCode3A();
        FileInputStream fr = new FileInputStream(
                "F:\\development\\adventofcode\\src\\adventofcode2024\\adventofcode3\\input.txt"
        );

        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr))) {
            String line;
            while ((line = br.readLine()) != null) {

                Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
                Matcher matcher = pattern.matcher(line);
                List<String> mulMatches = new ArrayList<>();

                while (matcher.find()) {
                    mulMatches.add(matcher.group());
                }

                for (String match : mulMatches) {
                    System.out.println(match);

                    char[] array = app.splitLineOnMulOpening(match.substring(3))[0].toCharArray();
                    if (app.checkIsValidMultiplication(array)) {

                        app.result += Math.multiplyExact(
                                Integer.parseInt(app.firstDigit.toString()),
                                Integer.parseInt(app.secondDigit.toString()));

                        //numbers...
//                        System.out.println(inputLine + " i:"+ i + " " +
//                                "1d:"+ app.firstDigit.toString() + "," +
//                                "2d:"+ app.secondDigit.toString() + "," +
//                                "m:" + Math.multiplyExact(Integer.parseInt(app.firstDigit.toString()), Integer.parseInt(app.secondDigit.toString())) + "," +
//                                "r:" + app.result);

                    }
                }
            }
        }
        System.out.println("Result : " + app.result);
    }

    public boolean checkIsValidMultiplication(char[] charArray) {

        firstDigit = new StringBuilder();
        secondDigit = new StringBuilder();

        int firstChar = 0;
        boolean findOpeningBracket = false;
        boolean commaFound = false;
        boolean findClosingBracket = false;

        for (int i = 0; i < charArray.length; i++) {

            // (
            if (i == firstChar){
                if (charArray[i] == '(') {
                    findOpeningBracket = true;
                    continue;
                } else {
                    System.out.println("Missing opening bracket");
                    break;
                }
            }

            //  (DDD,DDD)
            //  0123,5678 max length 9
            if (i <= 4 && !commaFound) {
                if (!isDigit(charArray[i] + "") && charArray[i] != ',') {
                    //invalid char found.
                    firstDigit = new StringBuilder();
                    secondDigit = new StringBuilder();
                    System.out.println("Invalid char found in 1st digit");
                    break;
                }

                if (isDigit(charArray[i] + "")) {
                    firstDigit.append(charArray[i]);
                    continue;
                } else if (charArray[i] == ',' && firstDigit.length() > 0) {
                    commaFound = true;
                    continue;
                }

            } else if (!commaFound) {
                //incorrect statement.
                firstDigit = new StringBuilder();
                secondDigit = new StringBuilder();
                System.out.println("No comma found");
                break;
            }

            //DDD) remaining. D length can be 1-3 but must have end bracket.
            if (commaFound) {
                if (isDigit(charArray[i] + "") && charArray[i] != ')' && secondDigit.length() < 3) {
                    secondDigit.append(charArray[i]);
                } else if (charArray[i] == ')') {
                    findClosingBracket = true;
                    break;
                } else {
                    //weird character found.
                    System.out.println("weird char found in 2nd digit");
                    firstDigit = new StringBuilder();
                    secondDigit = new StringBuilder();
                    break;
                }
            }else {
                System.out.println("something weird happened");
                break;
            }
        }
        return findOpeningBracket && commaFound && findClosingBracket &&
                firstDigit.length() <= 3 && firstDigit.length() > 0 &&
                secondDigit.length() <= 3 && secondDigit.length() > 0;
    }

    public String[] splitLineOnMulOpening(String line) {
        return line.split("mul");
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