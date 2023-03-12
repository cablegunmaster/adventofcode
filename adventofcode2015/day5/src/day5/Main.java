package adventofcode2015.day5.src.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * --- Day 5: Doesn't He Have Intern-Elves For This? ---
 * Santa needs help figuring out which strings in his text file are naughty or nice.
 *
 * A nice string is one with all of the following properties:
 *
 * It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
 * It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
 * It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
 * For example:
 *
 * ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and none of the disallowed substrings.
 * aaa is nice because it has at least three vowels and a double letter, even though the letters used by different rules overlap.
 * jchzalrnumimnmhp is naughty because it has no double letter.
 * haegwjzuvuyypxyu is naughty because it contains the string xy.
 * dvszwmarrgswjxmb is naughty because it contains only one vowel.
 * How many strings are nice?
 */

public class Main {

    //public static String ALPHABET= "ABCDEFGHIJKLMNOPQRSTUVWXYZA";
    public static String VOWELS = "AEIOU";

    // https://adventofcode.com/2015/day/4
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        // https://adventofcode.com/2015/day/5
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day5\\input.txt");

        if(!file.exists()){
            System.out.println("File bestaat niet.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int total = 0;
        while ((st = br.readLine()) != null) {
            if(isNiceString(st)) {
                total++;
            }
        }
        System.out.println(total);
    }

    //It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
    //It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
    //It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
    public static boolean isNiceString(String input){
        return hasDoubleLetter(input) && !hasStrings(input) && hasThreeOrMoreVowels(input);
    }

    public static boolean hasStrings(String input) {
        //ab, cd, pq, or xy
        return input != null && (
                input.contains("ab") ||
                input.contains("cd") ||
                input.contains("pq") ||
                input.contains("xy"));
    }

    /**
     * @param input could be any string check if it has three or more vowels
     * @return true if it has more or equal to three vowels in a string: with the following vowels:'AEIOU'
     */
    public static boolean hasThreeOrMoreVowels(String input) {
        if(input == null){
            return false;
        }

        int count= 0;
        for (int i = 0; i < input.length(); i++) {
            String vowel = String.valueOf(input.charAt(i));
            if(VOWELS.toLowerCase().contains(vowel.toLowerCase())){
                count++;
            }
        }

        return count >= 3;
    }

//    /**
//     * @deprecated
//     * @param input String to check , goes over one letter at the time checking if AB or CD is happening inside the string.
//     * @return true if 2 characters are found to be alphabetic in a string meaning next to it in the alphabet false if it does not happen.
//     */
//    @Deprecated
//    public static boolean isAlphabetic(String input) {
//        if(input == null){
//            return false;
//        }
//
//        boolean isLetterNextToItAlphabetic = false;
//        for (int i = 0; i < input.length(); i++) {
//            int o = i;
//            String firstLetter = String.valueOf(input.charAt(i));
//            if(++o < input.length()) {
//                String secondLetter = String.valueOf(input.charAt(o));
//                isLetterNextToItAlphabetic = checkIsAlphabetic(firstLetter, secondLetter);
//            }
//        }
//        return isLetterNextToItAlphabetic;
//    }
//
//    /**
//     * @param firstLetter A
//     * @param secondLetter B
//     * @return true if its set to be alphabetic , which means A = 0 minus B = 1
//     */
//    public static boolean checkIsAlphabetic(String firstLetter, String secondLetter){
//        return (ALPHABET.indexOf(secondLetter) - ALPHABET.indexOf(firstLetter)) == 1;
//    }

    public static boolean hasDoubleLetter(String input) {
        if(input == null){
            return false;
        }
        boolean isDoubleLetter = false;
        for (int i = 0; i < input.length(); i++) {
            int o = i;
            String firstLetter = String.valueOf(input.charAt(i));
            if(++o < input.length()) {
                String secondLetter = String.valueOf(input.charAt(o));
                isDoubleLetter = checkisDoubleLetter(firstLetter, secondLetter);

                if(isDoubleLetter){
                    return true;
                }
            }
        }
        return isDoubleLetter;
    }

    private static boolean checkisDoubleLetter(String firstLetter, String secondLetter) {
        return firstLetter.equals(secondLetter);
    }
}
