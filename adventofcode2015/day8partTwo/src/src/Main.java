import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import static java.lang.Character.isDigit;

/**
 * Each wire has an identifier (some lowercase letters) and can carry a 16-bit signal (a number from 0 to 65535).
 * A signal is provided to each wire by a gate, another wire, or some specific value.
 * Each wire can only get a signal from one source, but can provide its signal to multiple destinations.
 * A gate provides no signal until all of its inputs have a signal.
 **/
public class Main {

    public static Main main;
    public int literalcharacters = 0;
    public int encodedStringData = 0;
    private boolean isHexaDecimalNumber;

    public Main() {
    }

    // https://adventofcode.com/2015/day/8
    public static void main(String[] args) throws IOException {
        main = new Main();
        main.calc();
        System.out.println("Literal Characters: "+ main.literalcharacters);
        System.out.println("encoded: "+ main.encodedStringData);

        System.out.println(main.encodedStringData - main.literalcharacters);
    }

    public void calc() throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day8partTwo\\input.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            literalcharacters = stringLiteralLength(st) + literalcharacters;
            encodedStringData = encodedString(st).length() + encodedStringData;
        }
    }


    public int stringLiteralLength(String input){
        return input.trim().length();
    }


    public String encodedString(String input) {
        input = input.trim();

        boolean isOpened = false;
        boolean isEscaped = false;

        StringBuilder sb = new StringBuilder();
        StringBuilder hexadecimal = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {

            char k = input.charAt(i);

            //Open string.
            if (k == '"' && !isOpened) {
                isOpened = true;
                sb.append("\"\\\"");
                continue;
            }

            //end cycle
            if (k == '"' && !isEscaped) {
                sb.append("\\\"\"");
                break;
            }

            //Escape next character.
            if (k == '\\' && !isEscaped) {
                sb.append("\\\\");
                isEscaped = true;
                continue;
            }

            if (isEscaped) {
                //Escaped part.
                if (k == 'x') {
                    isHexaDecimalNumber = true;
                }

                if (k == '\\') {
                    sb.append("\\\\");
                    isEscaped = false;
                    continue;
                }

                if (isHexaDecimalNumber) {
                    if (isDigit(k) || isHexaDecimalLetter(k) && hexadecimal.length() < 2) {
                        hexadecimal.append(k);
                    }
                    if (hexadecimal.length() == 2) {
                        isHexaDecimalNumber = false;
                        hexadecimal = new StringBuilder();
                        isEscaped = false;
                    }
                }

                if (k == '"') {
                    sb.append("\\");
                    isEscaped = false;
                }
            }
            sb.append(k);
        }
        return sb.toString();
    }

    private boolean isHexaDecimalLetter(char k) {
        return k == 'a' || k == 'b' || k == 'c' || k == 'd' || k == 'e' || k == 'f';
    }
}
