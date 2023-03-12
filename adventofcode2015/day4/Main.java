package adventofcode2015.day4;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    //md5 exist of 32 char length chars.
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        // https://adventofcode.com/2015/day/4
        int number = 0;
        String firstPart = "";
        String key = "yzbqklnj";
        while(!firstPart.equals("000000")){
            number++;

            String result = StringToMD5(key + number);
            firstPart = result.substring(0,6);
        }
        System.out.println(number);
    }

    public static String StringToMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(str.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return hashtext;
    }
}
