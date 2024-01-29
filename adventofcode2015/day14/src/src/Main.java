import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     --- Day 14: Reindeer Olympics ---
     This year is the Reindeer Olympics! Reindeer can fly at high speeds, but must rest occasionally to recover their energy. Santa would like to know which of his reindeer is fastest, and so he has them race.

     Reindeer can only either be flying (always at their top speed) or resting (not moving at all), and always spend whole seconds in either state.

     For example, suppose you have the following Reindeer:

     Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.
     Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.
     After one second, Comet has gone 14 km, while Dancer has gone 16 km. After ten seconds,
     Comet has gone 140 km, while Dancer has gone 160 km.
     On the eleventh second, Comet begins resting (staying at 140 km),
     and Dancer continues on for a total distance of 176 km. On the 12th second, both reindeer are resting.
     They continue to rest until the 138th second, when Comet flies for another ten seconds. On the 174th second,
     Dancer flies for another 11 seconds.

     In this example, after the 1000th second, both reindeer are resting, and Comet is in the lead at 1120 km (poor Dancer has only gotten 1056 km by that point). So, in this situation, Comet would win (if the race ended at 1000 seconds).

     Given the descriptions of each reindeer (in your puzzle input), after exactly 2503 seconds, what distance has the winning reindeer traveled?
     */

    private List<Reindeer> list = new ArrayList<>();
    private int secondsPassed = 2503;
    private String path;

    // https://adventofcode.com/2015/day/14
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        String inputPath = null;

        if (args.length == 0) {
            throw new RuntimeException("Need args[0] input as a digit; maxAmount");
        }

        if (args.length == 2) {
            inputPath = args[1];
        }

        main.setSecondsPassed(Integer.parseInt(args[0]));
        main.setPath(inputPath);

        main.load(main.getPath());

        main.calcRace(main.secondsPassed, main.getList());
        main.showResults();
    }

    public void load(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new RuntimeException("File does not exist.");
        } else {
            System.out.println(getPath());
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            parseLine(st);
        }
    }

    public void parseLine(String line) {
        String[] arr = line.split(" ");
        list.add(new Reindeer(arr[0], arr[3], arr[6], arr[13]));
    }

    public void calcRace(int maxSeconds, List<Reindeer> list){
        //race distance
        for (int i = 1; i <= maxSeconds; i++) {

            //each Reindeer behaviour.
            for (Reindeer rd : list) {
                if (rd.isResting()) {
                    rd.increaseResting();
                    if (rd.isRested()) {
                        rd.setResting(false);
                        rd.resetRestTime();
                        rd.resetFlyingTime();
                    }
                }

                if (rd.isExhausted()) {
                    rd.setResting(true);
                }

                if (rd.isFlying()) {
                    if (!rd.isExhausted()) {
                        rd.increaseDistance();
                        rd.increaseFlying();
                    }
                }
            }
        }
    }

    private void showResults() {
        for (Reindeer rd : list) {
            System.out.println(rd.getName() + " distance:" + rd.getDistance() + " isResting: " + rd.isResting());
        }
    }

    private void setSecondsPassed(Integer secondsPassed) {
        this.secondsPassed = secondsPassed;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        if (path == null) {
            return "F:\\development\\adventofcode\\src\\adventofcode2015\\day14\\input.txt";
        }
        return path;
    }

    private List<Reindeer> getList() {
        return list;
    }
}
