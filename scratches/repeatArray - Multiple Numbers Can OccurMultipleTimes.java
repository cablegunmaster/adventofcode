import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Scratch {
    public static void main(String[] args) {
        // example usage
        int[] arr = {1, 2, 3, 4, 5};
        int length = 5;
        printUniqueCombinations(arr, length);
    }


    public static void printUniqueCombinations(int[] arr, int length) {
        Set<String> combinations = new HashSet<>();
        printUniqueCombinationsHelper(arr, length, new int[length], 0, combinations);
    }

    private static void printUniqueCombinationsHelper(int[] arr, int length, int[] combination, int index, Set<String> combinations) {
        if (index == length) {
            String combinationString = Arrays.toString(combination);
            if (!combinations.contains(combinationString)) {
                combinations.add(combinationString);
                System.out.println(combinationString);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                combination[index] = arr[i];
                printUniqueCombinationsHelper(arr, length, combination, index + 1, combinations);
            }
        }
    }
}