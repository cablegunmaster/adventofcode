import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdventOfCode3ATest {

    AdventOfCode3A app;

    @BeforeEach
    void setup() {
        app = new AdventOfCode3A();
    }

    String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
    String inputSimpleRight = "mul(2,4)";
    String inputWrong = "mul[2,4]";
    String inputbigNumber ="mul(233,239)";

    @Test
    void testMulReturnsProperString() {
        Assertions.assertEquals(7, app.splitLineOnMulOpening(input).length);
    }

    @Test
    void testSplitOnMulHasTwo() {
        Assertions.assertEquals(2, app.splitLineOnMulOpening(inputSimpleRight).length);
        Assertions.assertEquals(2, app.splitLineOnMulOpening(inputWrong).length);
    }

    @Test
    void testSplitHasOpeningBracket() {
        int rightSideOfSplit = 1;
        int firstChar = 0;
        Assertions.assertEquals('(', app.splitLineOnMulOpening(inputSimpleRight)[rightSideOfSplit].toCharArray()[firstChar]);
        Assertions.assertEquals('[', app.splitLineOnMulOpening(inputWrong)[rightSideOfSplit].toCharArray()[firstChar]);
    }

    @Test
    void loopThroughChars() {
        int rightSideOfSplit = 1;
        int firstChar = 0;
        StringBuilder firstDigit = new StringBuilder();
        StringBuilder secondDigit = new StringBuilder();
        char[] charArray = app.splitLineOnMulOpening(inputSimpleRight)[rightSideOfSplit].toCharArray();

        boolean findOpeningBracket = false;
        boolean commaFound = false;
        boolean findClosingBracket = false;
        for (int i = 0; i < charArray.length; i++) {

            // (
            if (i == firstChar) {
                findOpeningBracket = charArray[i] == '(';
                continue;
            }

            // number until "," max size 3 if bigger as 3 numbers or different thing found incorrect.
            if (findOpeningBracket && i <= 4 && !commaFound) {

                if (!app.isDigit(charArray[i] + "") && charArray[i] != ',') {
                    //invalid char found.
                    break;
                }

                if (app.isDigit(charArray[i] + "")) {
                    firstDigit.append(charArray[i]);
                } else if (charArray[i] == ',' && firstDigit.length() > 0) {
                    commaFound = true;
                }

            } else if (!commaFound) {
                //incorrect statement.
                break;
            }

            if (commaFound) {
                if (app.isDigit(charArray[i] + "") && charArray[i] != ')' && secondDigit.length() < 3) {
                    secondDigit.append(charArray[i]);
                } else if (charArray[i] == ')') {
                    findClosingBracket = true;
                }
            }
        }

        Assertions.assertEquals(firstDigit.toString(), "2");
        Assertions.assertEquals(secondDigit.toString(), "4");
        Assertions.assertTrue(findOpeningBracket);
        Assertions.assertTrue(commaFound);
        Assertions.assertTrue(findClosingBracket);
    }

    @Test
    void testSimpleInputTextWithSingleMultiplication() {
        String[] output = app.splitLineOnMulOpening(inputSimpleRight);
        for (String inputLine : output) {
            if (app.splitLineOnMulOpening(inputLine)[0].length() != 1) {
                char[] array = app.splitLineOnMulOpening(inputLine)[0].toCharArray();
                if (app.checkIsValidMultiplication(array)) {
                    app.result = Math.multiplyExact(
                            Integer.parseInt(app.firstDigit.toString()),
                            Integer.parseInt(app.secondDigit.toString()));
                }
            }
        }
        Assertions.assertEquals(8, app.result);
    }

    @Test
    void testSimpleInputTextWithMultiple_Multiplication_Counted() {
        String[] output = app.splitLineOnMulOpening(input);
        for (String inputLine : output) {
            if (app.splitLineOnMulOpening(inputLine)[0].length() != 1) {
                char[] array = app.splitLineOnMulOpening(inputLine)[0].toCharArray();
                if (app.checkIsValidMultiplication(array)) {
                    app.result += Math.multiplyExact(
                            Integer.parseInt(app.firstDigit.toString()),
                            Integer.parseInt(app.secondDigit.toString()));
                }else{
                    System.out.println(array);
                }
            }
        }
        Assertions.assertEquals(161, app.result);
    }

    @Test
    void testBigNumberIsCorrectlyParsed_multiplicationTest(){
        String[] output = app.splitLineOnMulOpening(inputbigNumber);
        for (String inputLine : output) {
            if (app.splitLineOnMulOpening(inputLine)[0].length() != 1) {
                char[] array = app.splitLineOnMulOpening(inputLine)[0].toCharArray();
                if (app.checkIsValidMultiplication(array)) {
                    app.result += Math.multiplyExact(
                            Integer.parseInt(app.firstDigit.toString()),
                            Integer.parseInt(app.secondDigit.toString()));
                }else{
                    System.out.println(array);
                }
            }
        }
        Assertions.assertEquals(55687, app.result);
    }
}