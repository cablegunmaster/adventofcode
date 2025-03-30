import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

class AdventOfCode2B {

    int totalSafe = 0;
    int totalUnsafe = 0;
    boolean isDampenerActivated = false;
    int indexToRemove = -1;
    int[] arr;

    /**
     * Day 2: Red-Nosed Reports
     */
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        AdventOfCode2B app = new AdventOfCode2B();
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
                boolean isSafe = app.checkWithDampener(intArray,app);
                app.print(sb, intArray,isSafe);
                app.countSafeUnsafe(isSafe);
            }
            System.out.println(app.totalSafe);
        }
    }

    public boolean checkWithDampener(int[] intArray, AdventOfCode2B app) {
        var isSafe = app.calcisSafe(intArray, app);
        if(app.isDampenerActivated){
            for (int i = 0; i < intArray.length; i++) {
                isSafe = app.calcisSafe(app.remove(intArray.clone(), i), app);
                if(isSafe){
                    break;
                }
            }
            app.disableDampener();
        }
        return isSafe;
    }

    public boolean calcisSafe(int[] arr, AdventOfCode2B app) {
        boolean isArrGoingDown = false;
        boolean isArrGoingUp = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (isFirstNumber(i)) {
                var firstNumber = arr[0];
                var secondNumber = arr[1];
                isArrGoingUp = checkNumberGoingUp(firstNumber, secondNumber);
                isArrGoingDown = checkNumberGoingDown(firstNumber, secondNumber);
            }

            var firstNumber = arr[i];
            var secondNumber = arr[i + 1];
            boolean isNumberConsistentChanging = checkConsistentGoingUpOrDown(firstNumber, secondNumber, isArrGoingDown, isArrGoingUp);
            if (!isNumberConsistentChanging){
                if (!app.isDampenerActivated) {
                    app.isDampenerActivated = true;
                }
                return false;
            }

            if (!isSafe(firstNumber, secondNumber)) {
                if (!app.isDampenerActivated) {
                    app.isDampenerActivated = true;
                }
                return false;
            }
        }
        return true;
    }

    public int[] remove(int[] arr, int in){
        if (arr == null || in < 0 || in >= arr.length)
            return arr;

        return IntStream.range(0, arr.length)
                .filter(i -> i != in)
                .map(i -> arr[i])
                .toArray();
    }

    private boolean isFirstNumber(int number){
        return number == 0;
    }

    private boolean isSafe(int a, int b) {
        return (Math.abs(b - a)) <= 3 && a != b;
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

    public void countSafeUnsafe(boolean isSafe) {
        if(isSafe){
            totalSafe++;
        }else {
            totalUnsafe++;
        }
    }

    public void disableDampener() {
        isDampenerActivated = false;
    }


    public void print(StringBuilder sb, int[] intArray, boolean isSafe){
        sb.append(Arrays.toString(intArray));
        sb.append(" isSafe: ").append(isSafe);
        System.out.println(sb);
        sb.setLength(0);
    }
}