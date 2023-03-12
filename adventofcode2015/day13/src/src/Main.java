import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Main {
    public final String NEGATIVE = "lose";
    List<Person> list = new ArrayList<>();

    // https://adventofcode.com/2015/day/13
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.load();
    }

    public void load() throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day13\\inputTest.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            parseLine(st);
        }
    }

    public void parseLine(String line) {
        String[] arr = line.split(" ");
        String name = arr[0];
        Person personSearch = new Person(name);
        if (list.contains(personSearch)) {
            Person p = getPersonByName(name);
            String nameNeighbour = cleanName(arr[10]);
            String sortOfAffection = arr[2];
            String affectionStr = arr[3];
            p.setValueNeighbours(nameNeighbour, getAffection(affectionStr, sortOfAffection));
        } else {
            Person p = new Person(name);
            list.add(p);
        }
    }

    public String cleanName(String s) {
        return s.substring(0, s.length() -1);
    }

    public int getAffection(String str, String sortOfAffection){
        int affection = Integer.parseInt(str);
        if(sortOfAffection.equals(NEGATIVE)){
            affection = affection * -1;
        }
        return affection;
    }

    public Person getPersonByName(String name) {
        Optional<Person> findPerson =
                list.stream()
                        .filter(p -> p.getName().equals(name))
                        .findFirst();
        return findPerson.orElse(null);
    }

    public int calculateCurrentArrangement() {
        int maxHappiness = 0;
        Table t = new Table();
        int currHappiness = t.calculateHappinessOfTable();
        if(currHappiness > maxHappiness){
            maxHappiness = currHappiness;
        }
        return maxHappiness;
    }
}
