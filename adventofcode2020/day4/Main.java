package adventofcode2020.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * This learned me not to forget the last input. after an adding loop.
 */
public class Main {


    //https://adventofcode.com/2020/day/4
    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {

        File file = new File("D:\\development\\adventofcode\\src\\adventofcode2020\\day4\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        int valid = 0;
        String st;
        List<String> idList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while ((st = br.readLine()) != null) {
            if (st.equals("")) {
                idList.add(sb.toString());
                sb.delete(0, sb.length()); //clear buffer.
            } else {
                sb.append(st).append(" ");
            }
        }
        idList.add(sb.toString());
        sb.delete(0, sb.length()); //clear buffer.

        Passport passport = null;
        for (String id : idList) {
            passport = new Passport();
            String[] split = id.split(" ");
            parseIdentifier(split, passport);
            if(passport.isValidPassport()){
                ++valid;
            }
        }
        System.out.println(valid);
    }

    private static void parseIdentifier(String[] split, Passport p) {
        for (String s : split) {
            String[] field = s.split(":");
            String identifier = field[0];
            String value = field[1];

            switch (identifier) {
                case "byr":
                    p.setByr(value);
                    break;
                case "iyr":
                    p.setIyr(value);
                    break;
                case "eyr":
                    p.setEyr(value);
                    break;
                case "hgt":
                    p.setHgt(value);
                    break;
                case "hcl":
                    p.setHcl(value);
                    break;
                case "ecl":
                    p.setEcl(value);
                    break;
                case "pid":
                    p.setPid(value);
                    break;
                default:
            }
        }
    }
}
