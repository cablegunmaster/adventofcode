package adventofcode2021.adventofcode4b;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdventOfCode4B {

    HashMap<Integer, int[]> currentBingoCard = null;
    public List<HashMap<Integer, int[]>> bingoCards = new ArrayList<>();
    public int[] bingoNumbers = null;
    public int lineNumber = 0;
    public int currentNumberCalled;

    public static void main(String args[]) throws IOException {
        AdventOfCode4B a = new AdventOfCode4B();
        a.loadVariablesFromInput("D:\\development\\adventofcode\\src\\adventofcode2021\\adventofcode4a\\input.txt");
        a.calculateWinner();
        a.printWinningNumber();
    }

    public AdventOfCode4B() {
    }

    public void loadVariablesFromInput(String file) throws IOException {
        //read input.
        FileInputStream fr = new FileInputStream(file);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fr));) {
            String line;
            while ((line = br.readLine()) != null) {

                //New Board.
                if (line.equals("")) {
                    currentBingoCard = new HashMap<>();
                    bingoCards.add(currentBingoCard);
                }

                //read line.
                if (bingoNumbers != null && !line.equals("")) {
                    currentBingoCard.put((lineNumber % 5), lineToIntArray(line));
                    lineNumber++;
                }

                //first line marker.
                if (bingoNumbers == null) {
                    loadPickedBingoNumbers(line);
                }
            }
        }
    }

    public void loadPickedBingoNumbers(String line){
        String[] bingoNumberString = line.split(",");
        bingoNumbers = new int[bingoNumberString.length];
        for (int i = 0; i < bingoNumberString.length; i++) {
            bingoNumbers[i] = Integer.parseInt(bingoNumberString[i]);
        }
    }

    /**
     * @param input as a string, splitting up using fixed length.
     * @return array horizontal line of a bingocard. length of 5 items in total.
     */
    public int[] lineToIntArray(String input) {
        int[] arr = new int[5];
        arr[0] = Integer.parseInt(input.substring(0, 2).trim());
        arr[1] = Integer.parseInt(input.substring(3, 5).trim());
        arr[2] = Integer.parseInt(input.substring(6, 8).trim());
        arr[3] = Integer.parseInt(input.substring(9, 11).trim());
        arr[4] = Integer.parseInt(input.substring(12, 14).trim());
        return arr;
    }

    public void markNumber(int chosenNumber) {
        for (HashMap<Integer, int[]> bingoCard : bingoCards) {
            for (int j = 0; j < bingoCard.size(); j++) {
                int[] line = bingoCard.get(j);
                for (int k = 0; k < line.length; k++) {
                    if (line[k] == chosenNumber) {
                        line[k] = -1;
                    }
                }
            }
        }
    }

    public int getFirstBingoCardMarkedColumn() {
        boolean columnIsMarked = false;

        for (int i = 0; i < bingoCards.size(); i++) {
            HashMap<Integer, int[]> bingoCard = bingoCards.get(i); //grab a card.

            for (int k = 0; k <= 4; k++) {
                columnIsMarked = true;
                for (int j = 0; j < bingoCard.size(); j++) {
                    int[] line = bingoCard.get(j);
                    if (line[k] != -1) {
                        columnIsMarked = false;
                        break;
                    }
                }
                if(columnIsMarked){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * @return -1 if not found, any number to get a bingoCard.
     */
    public int getFirstBingoCardMarkedRow() {
        boolean rowIsMarked;

        for (int i = 0; i < bingoCards.size(); i++) {
            HashMap<Integer, int[]> bingoCard = bingoCards.get(i); //grab a card.
            for (int j = 0; j < bingoCard.size(); j++) {
                int[] line = bingoCard.get(j);

                rowIsMarked = true;
                for (int value : line) {
                    if (value != -1) {
                        rowIsMarked = false;
                        break;
                    }
                }

                if(rowIsMarked){
                    return i;
                }
            }
        }
        return -1;
    }

    public int getUnmarkedNumbersOfBoard() {
        int total = 0;
        if(currentBingoCard != null){
            for (int i = 0; i < currentBingoCard.size(); i++) {
                int[] line = currentBingoCard.get(i);
                for (int j : line) {
                    if (j != -1) {
                        total = total + j;
                    }
                }
            }
        }
        return total;
    }

    //get current
    public String calculusWinningNumberFromBoard() {
        if(getUnmarkedNumbersOfBoard() * currentNumberCalled == 0){
            return "0";
        }
        return getUnmarkedNumbersOfBoard() * currentNumberCalled + "";
    }

    private void printWinningNumber() {
       System.out.println(calculusWinningNumberFromBoard());
    }

    public void calculateWinner() {
        int[] bingoNumbers = getBingoNumber();
        if(bingoNumbers != null){
            for (int number : bingoNumbers) {
                markNumber(number);
                while(isBingo()){
                    setCurrentNumber(number);
                    setWinningBingoCard();
                    printWinningNumber();
                    clearEntry();
                }
            }
        }
    }

    private void clearEntry(){
        bingoCards.remove(currentBingoCard);
        currentBingoCard = null;
    }

    private void setCurrentNumber(int number) {
        currentNumberCalled = number;
    }

    public void setWinningBingoCard() {
        if(getFirstBingoCardMarkedColumn() != -1){
            currentBingoCard = getBingoCards().get(getFirstBingoCardMarkedColumn());
        }

        if(getFirstBingoCardMarkedRow() != -1){
            currentBingoCard = getBingoCards().get(getFirstBingoCardMarkedRow());
        }
    }

    public boolean isBingo(){
        return (getFirstBingoCardMarkedColumn() != -1 ||
                getFirstBingoCardMarkedRow() != -1);
    }

    public List<HashMap<Integer, int[]>> getBingoCards() {
        return bingoCards;
    }

    public int getLineNumber(){
        return lineNumber;
    }

    public int[] getBingoNumber() {
        return bingoNumbers;
    }
}
