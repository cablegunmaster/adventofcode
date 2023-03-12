import java.io.IOException;

public class Main {

    // https://adventofcode.com/2015/day/10
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        String s = main.calculateBigNumberLength();
        System.out.println(s.length());
    }

    private String calculateBigNumberLength() throws IOException {
        String s = "1321131112";
        for (int i = 0; i < 50; i++) {
            s = calculateOnce(s);
        }
        return s;
    }

    public String calculateOnce(String input) {
        StringBuilder output = new StringBuilder();
        int amount = 0;
        char lastNumber = '-';
        for (int i = 0; i < input.length(); i++) {
            char number = input.charAt(i);

            //als getal gelijk is ++ het aantal.
            //als geen getal zet getal.
            if (firstNumber(i) || isNumberEqual(number,lastNumber)) {
                amount++;
                lastNumber = number;
            }

            //als getal anders is voeg aantal aan string toe.
            //als getal laatste van de string is voeg het toe met huidig amount.
            if (lastNumber(i, input.length()) ||
            nextNumberDifferent(input, i)) {
                output.append(amount).append(number);
                amount = 1;
            }
            lastNumber = number;
        }
        return output.toString();
    }

    private boolean nextNumberDifferent(String c, int i) {
        return (i + 1) < c.length() && c.charAt(i) != c.charAt(i+ 1);
    }

    public boolean firstNumber(int i){
        return i == 0;
    }

    public boolean isNumberEqual(char number, char lastNumber){
        return number == lastNumber;
    }

    public boolean lastNumber(int i, int length){
        return i + 1 == length;
    }
}
