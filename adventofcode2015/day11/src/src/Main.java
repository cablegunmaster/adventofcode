import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // https://adventofcode.com/2015/day/11
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        String input = "hxbxxyzz"; //hxcaabcc (password 2);
        System.out.println(main.findNextPassword(input));
    }

    /**
     * Returns next valid password.
     * @param input password combination last used
     * @return new password as a string.
     */
    public String findNextPassword(String input) {
        boolean notValid = true;
        while(notValid){
            input = incrementLetterOnce(input);
            if(isValidPassword(input)){
                notValid = false;
            }
        }
        return input;
    }

    /**
     * Checks all 3 reasoning.
     * @param input possible password
     * @return true if its a good password, false if its a bad one.
     */
    public boolean isValidPassword(String input){
        return !doesContainLetters(input) &&
                containsTwoPairsOfLetters(input)
                && isInSerie(input);
    }

    /**
     * Passwords must include one increasing straight of at least three letters,
     * like abc, bcd, cde, and so on, up to xyz.
     * They cannot skip letters; abd doesn't count.
     * @param input string possible password combination
     * @return true if a serie of 3 letters is found or false if no serie is found.
     */
    public boolean isInSerie(String input) {
        for (int i = 0; i < input.length() ; i++) {
            if(i + 2 < input.length()) {
                int a = input.charAt(i);
                int b = input.charAt(i + 1);
                int c = input.charAt(i + 2);
                if (b - a == 1 &&
                        c - b == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public String incrementLetterOnce(String input) {
        char[] inputChars = input.toCharArray();
        for (int i = input.length(); i-- > 0;) {
            char c = input.charAt(i);
            inputChars[i] = (char) (((c - 'a' + 1) % 26) + 'a');
            if(c != 'z'){
                break;
            }
        }
        return String.valueOf(inputChars);
    }

    //Passwords may not contain the letters i, o, or l,
    //as these letters can be mistaken for other characters and are therefore confusing.
    public boolean doesContainLetters(String input) {
        return input.contains("i") || input.contains("o") || input.contains("l");
    }

    //check 2 are existing.
    //Passwords must contain at least two different,
    //non-overlapping pairs of letters, like aa, bb, or zz.
    public boolean containsTwoPairsOfLetters(String input){
        List list = new ArrayList();
        for (int i = 0; i < input.length(); i++) {
            int c = checkTwo(i, input);
            if(c != 0 && !list.contains(c) ) {
                list.add(c);
            }
        }
        return list.size() >= 2;
    }

    public char checkTwo(Integer i, String input){
        char c = input.charAt(i);
        if(i + 1 < input.length()) {
            char b = input.charAt(i + 1);
            if (c == b) {
                return c;
            }
        }
        return 0;
    }
}
