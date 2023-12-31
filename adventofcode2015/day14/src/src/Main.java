import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    List<Reindeer> list = new ArrayList<>();
    private int secondsPassed = 0;
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

        main.calcRace();
        main.showResults();
    }

    public void load(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist.");
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

    public void calcRace() {
        //race distance
        for (int i = 1; i <= secondsPassed; i++) {

            //each Reindeer behaviour.
            for (Reindeer rd : list) {
                if (rd.isFlying()) {
                    if (rd.isExhausted()) {
                        rd.setResting(true);
                    } else {
                        rd.increaseDistance();
                        rd.increaseFlying();
                    }
                } else if (rd.isResting()) {
                    rd.increaseResting();
                    if (rd.isRested()) {
                        rd.setResting(false);
                        rd.resetRestTime();
                        rd.resetFlyingTime();
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
}
