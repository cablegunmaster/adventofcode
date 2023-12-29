import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainApplication {

    public final String NEGATIVE = "lose";
    List<Person> list = new ArrayList<>();

    private int highestHappiness = 0;

    public static void main(String[] args) throws IOException {
        MainApplication main = new MainApplication();
        main.load();

        Person[] arr = main.list.toArray(new Person[main.list.size()]);
        main.printUniqueCombinationsNoRepeats(arr, main.list.size());

        System.out.println(main.getHighestHappiness());
    }

    public void load() throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day13\\input.txt");

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

        if (!list.contains(personSearch)) {
            Person p = new Person(name);
            list.add(p);
        }
        addNeighBour(getPersonByName(name), arr);
    }

    public void addNeighBour(Person p, String[] arr) {
        String nameNeighbour = cleanName(arr[10]);
        String sortOfAffection = arr[2];
        String affectionStr = arr[3];
        p.setValueNeighbours(nameNeighbour, getAffection(affectionStr, sortOfAffection));
    }

    public String cleanName(String s) {
        return s.substring(0, s.length() - 1);
    }

    public int getAffection(String str, String sortOfAffection) {
        int affection = Integer.parseInt(str);
        if (sortOfAffection.equals(NEGATIVE)) {
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

    public void printUniqueCombinationsNoRepeats(Person[] arr, int length) {
        boolean[] used = new boolean[arr.length];
        Set<String> combinations = new HashSet<>();
        printUniqueCombinationsNoRepeatsHelper(arr, length, new Person[length], 0, used, combinations);
    }

    private void printUniqueCombinationsNoRepeatsHelper(Person[] arr, int length, Person[] combination, int index, boolean[] used, Set<String> combinations) {
        if (index == length) {
            String combinationString = Arrays.toString(combination);
            if (!combinations.contains(combinationString)) {
                combinations.add(combinationString);

                ShoutOutHappiness(combination);
                System.out.println(combinationString);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    combination[index] = arr[i];
                    printUniqueCombinationsNoRepeatsHelper(arr, length, combination, index + 1, used, combinations);
                    used[i] = false;
                }
            }
        }
    }

    private void ShoutOutHappiness(Person[] personArray) {
        Table t = new Table();
        for (Person person : personArray) {
            t.setPersonAtTable(person);
        }

        int happinessCurrently = t.calculateHappinessOfTable();
        System.out.println("Happiness: " + happinessCurrently);

        if (t.calculateHappinessOfTable() > highestHappiness) {
            highestHappiness = happinessCurrently;
        }
    }

    public int getHighestHappiness() {
        return highestHappiness;
    }
}
