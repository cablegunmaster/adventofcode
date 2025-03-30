import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class AdventOfCode2A {

    int totalSafe = 0;
    int totalUnsafe = 0;

    /**
     * Day 2: Red-Nosed Reports
     */
    public static void main(String args[]) throws Exception {

        AdventOfCode2A a = new AdventOfCode2A();
        FileInputStream fr = new FileInputStream(
                "F:\\development\\adventofcode\\src\\adventofcode2024\\adventofcode2\\input.txt"
        );

        //Add to list.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr));) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strArr = line.split(" ");

                int[] intArray = Arrays.stream(strArr)
                        .mapToInt(Integer::parseInt)
                        .toArray();

                boolean isSafe = a.calcSafeOrUnsafe(intArray);
                a.addToSafe(isSafe);
            }
            System.out.println(a.totalSafe);
        }
    }

    public boolean calcSafeOrUnsafe(int[] arr) {

        boolean isGoingDown = false;
        boolean isGoingUp = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if(i == 0) {
                isGoingUp = checkNumberGoingUp(arr[0], arr[1]);
                isGoingDown = checkNumberGoingDown(arr[0], arr[1]);
            }

            boolean isConsistentChanging = checkConsistentGoingUpOrDown(arr[i], arr[i+1], isGoingDown, isGoingUp);
            if(!isConsistentChanging){
                return false;
            }
            if(!isSafe(arr[i], arr[i+1])){
                return false;
            }
        }
        return true;
    }

    private boolean isSafe(int a, int b) {
        return (Math.abs(b - a)) <= 3;
    }

    private boolean checkNumberGoingUp(int a, int b) {
        return b > a;
    }

    private boolean checkNumberGoingDown(int a, int b) {
        return b < a;
    }

    public boolean checkConsistentGoingUpOrDown(int a, int b, boolean isGoingDown, boolean isGoingUp) {
        if(isGoingDown){
            return b < a;
        }

        if(isGoingUp) {
            return b > a;
        }
        return false;
    }

    public void addToSafe(boolean isSafe) {
        if(isSafe){
            totalSafe++;
        }else {
            totalUnsafe++;
        }
    }
}