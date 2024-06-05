package org.example;

import java.util.ArrayList;
import java.util.List;

/**
* To run make a main.java and paste in below code in the main constructor.
*         Solution solution = new Solution();
*        List<String> list = solution.commonChars( new String[]{"bella","label","roller"});
*        List<String> list2 = solution.commonChars( new String[]{"cool","lock","cook"});
*        System.out.println(list);
*        System.out.println(list2);
*/
public class Solution {

    List list = new ArrayList<String>();

    public List<String> commonChars(String[] words) {
        for(int i = 0; i < words.length; i++){
            char[] wordA = words[i].toCharArray();

            //first time only
            if(i == 0){
                char[] wordB = words[1].toCharArray();
                compareWords(wordA,wordB);
                continue;
            }

            //second time and on.
            if(i > 1){
                char[] wordC = words[i].toCharArray();
                compareStillValid(listToChar(list), wordC);
            }
        }
        return list;
    }

    //compare words.
    public List<String> compareWords(char[] a,char[] b) {
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                if(isSameLetter(a[i],b[j])){
                    list.add(a[i] + "");
                    b[j] = '-';
                    break;
                }
            }
        }
        return list;
    }

    //compareStillValidNextWords
    public List compareStillValid(char[] a, char[] b) {
        for(int i = 0; i < a.length; i++){
            boolean found = false;
            for(int j = 0; j < b.length; j++){
                if(isSameLetter(a[i],b[j])){
                    b[j] = '-';
                    found = true;
                    break;
                }
            }

            if(!found && list.contains(String.valueOf(a[i]))) {
                //when letter is not found remove from list.
                list.remove(String.valueOf(a[i]));
            }
        }
        return list;
    }

    //list to char Array.
    public char[] listToChar(List<String> list){
        char[] charArray = new char[list.size()];
        for(int i = 0; i < list.size(); i++){
            charArray[i] = list.get(i).charAt(0);
        }
        return charArray;
    }

    public boolean isSameLetter(char a, char b) {
        return a == b;
    }
}
