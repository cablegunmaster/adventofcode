import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * --- Day 5: Doesn't He Have Intern-Elves For This? ---
 * Santa needs help figuring out which strings in his text file are naughty or nice.
 * A nice string is one with all of the following properties:
 * <p>
 * It contains a pair of any two letters that appears at least twice in the string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
 * It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi (efe), or even aaa.
 * <p>
 * How many strings are nice?
 */
public class Main {

    // https://adventofcode.com/2015/day/5
    public static void main(String[] args) throws IOException {
        // https://adventofcode.com/2015/day/5
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day5partTwo\\input.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int total = 0;
        while ((st = br.readLine()) != null) {
            if (isNiceString(st)) {
                total++;
            }
        }
        System.out.println(total);
    }

    //It contains a pair of any two letters that appears at least twice in the string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
    //It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi (efe), or even aaa.
    public static boolean isNiceString(String input) {
        return hasDoubleLetterAppearTwice(input) && repeatOneLetter(input);
    }

    /**
     * It contains a pair of any two letters that appears at least twice in the string without overlapping,
     * like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
     *
     * @param input
     * @return
     */
    public static boolean hasDoubleLetterAppearTwice(String input) {
        if (input == null) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length()) {
                String twoCharacters = String.valueOf(input.charAt(i))
                        .concat(String.valueOf(input.charAt(i + 1)));
                if ((i + 2) < input.length()) {
                    String output = input.substring(i + 2);
                    if (output.contains(twoCharacters)) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * It contains at least one letter which repeats with exactly one letter between them,
     * like xyx, abcdefeghi (efe), or even aaa.
     *
     * @param input a string input.
     * @return true or false , true if it has a xyx false if it does not repeat.
     */
    public static boolean repeatOneLetter(String input) {
        if (input == null) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            if (i + 2 < input.length()) {
                String firstLetter = String.valueOf(input.charAt(i));
                String secondLetter = String.valueOf(input.charAt(i + 2));
                if (checkIsLetterEqual(firstLetter, secondLetter)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkIsLetterEqual(String firstLetter, String secondLetter) {
        return firstLetter.equals(secondLetter);
    }
}
