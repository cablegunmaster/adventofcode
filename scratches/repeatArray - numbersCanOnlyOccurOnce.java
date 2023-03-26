import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Scratch {
    public static void main(String[] args) {
        // example usage
        int[] arr = {1, 2, 3, 4, 5};
        int length = 5;
        printUniqueCombinationsNoRepeats(arr, length);
    }

    public static void printUniqueCombinationsNoRepeats(int[] arr, int length) {
        boolean[] used = new boolean[arr.length];
        Set<String> combinations = new HashSet<>();
        printUniqueCombinationsNoRepeatsHelper(arr, length, new int[length], 0, used, combinations);
    }

    private static void printUniqueCombinationsNoRepeatsHelper(int[] arr, int length, int[] combination, int index, boolean[] used, Set<String> combinations) {
        if (index == length) {
            String combinationString = Arrays.toString(combination);
            if (!combinations.contains(combinationString)) {
                combinations.add(combinationString);
                System.out.println(combinationString);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    combination[index] = arr[i];
                    printUniqueCombinationsNoRepeatsHelper(arr, length, combination, index + 1, used, combinations);
                    used[i] = false;
                }
            }
        }
    }
}