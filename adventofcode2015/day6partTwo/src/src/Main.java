import java.io.*;

/**
* Because your neighbors keep defeating you in the holiday house decorating contest year after year,
* you've decided to deploy one million lights in a 1000x1000 grid.
* Furthermore, because you've been especially nice this year,
* Santa has mailed you instructions on how to display the ideal lighting configuration.
* Lights in your grid are numbered from 0 to 999 in each direction;
 * the lights at each corner are at 0,0, 0,999, 999,999, and 999,0.
 * The instructions include whether to turn on, turn off,
 * or toggle various inclusive ranges given as coordinate pairs.
 * Each coordinate pair represents opposite corners of a rectangle,
 * inclusive; a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square.
 * The lights all start turned off.
* To defeat your neighbors this year,
 * all you have to do is set up your lights by doing the instructions Santa sent you in order.
**/
public class Main {

    int[][] lights = new int[1000][1000];
    int[] coordinates = new int[4];
    public static final int ON = 1;
    public static final int OFF = -1;
    public static Main main;

    // https://adventofcode.com/2015/day/6
    public static void main(String[] args) throws IOException {
        main = new Main();
        main.fillSquaresWithZero();
        System.out.println("result: "+main.calc());
    }

    public int calc() throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day6\\input.txt");

        if(!file.exists()){
            System.out.println("File does not exist.");
        }

        main.fillSquaresWithZero();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            parseLine(st);
        }
        return amountOfLightsOn();
    }

    public void parseLine(String input){
        getCoordinates(input);

        int beginx = coordinates[0];
        int beginy = coordinates[1];
        int endx = coordinates[2];
        int endy = coordinates[3];

        if(input.contains("turn on")){
            fillSquaresWithValue(beginx,beginy,endx,endy, ON);
        }

        if(input.contains("turn off")){
            fillSquaresWithValue(beginx,beginy,endx,endy, OFF);
        }

        if(input.contains("toggle")){
            toggleSquares(beginx,beginy,endx,endy);
        }
    }

    public void getCoordinates(String input) {
        resetCoordinate();
        setCoordinateFromString(input, "toggle");
        setCoordinateFromString(input, "turn on");
        setCoordinateFromString(input, "turn off");
    }

    public void setCoordinateFromString(String input, String cmd){
        if(input.contains(cmd)) {
            String[] result = input.split(cmd, 2);
            String s1 = result[1].trim();
            var result2 = s1.split("through");

            String[] coordinateBegin = result2[0].trim().split(",");
            String[] coordinateEnd = result2[1].trim().split(",");

            var begin = getCoordinates(coordinateBegin);
            coordinates[0] = begin[0];
            coordinates[1] = begin[1];
            var end = getCoordinates(coordinateEnd);
            coordinates[2] = end[0];
            coordinates[3] = end[1];
        }
    }

    public int[] getCoordinates(String[] coordinate){
        int[] coordinates = new int[2];

        int x = Integer.parseInt(coordinate[0]);
        int y = Integer.parseInt(coordinate[1]);

        coordinates[0] = x;
        coordinates[1] = y;

        return coordinates;
    }

    public void toggleSquares(int beginX, int beginY,
                              int endX, int endY){
        for (int i = beginX; i <= endX ; i++) {
            for(int j = beginY; j <= endY; j++){
                lights[i][j] = lights[i][j]+ 2;
            }
        }
    }

    public void fillSquaresWithValue(int beginX, int beginY,
                                int endX, int endY,
                                int value){

        for (int i = beginX; i <= endX ; i++) {
            for(int j = beginY; j <= endY; j++){
                if(lights[i][j] > 0 && value == OFF ||
                lights[i][j] >= 0 && value == ON) {
                    lights[i][j] = lights[i][j] + value;
                }
            }
        }
    }

    public int amountOfLightsOn(){

       int amount = 0;
        for (int i = 0; i < lights.length; i++) {
            for(int j = 0; j < lights[0].length; j++){
                amount = amount + lights[i][j];
            }
        }
        return amount;
    }

    public void fillSquaresWithZero(){
        fillSquaresWithValue(0, 999,0, 999,0);
    }

    public void resetCoordinate(){
        coordinates[0] = -1;
        coordinates[1] = -1;
        coordinates[2] = -1;
        coordinates[3] = -1;
    }
}
