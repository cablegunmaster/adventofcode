import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public final String NEGATIVE = "lose";
    List<Person> list = new ArrayList<>();
    int maxHappiness = 0;
    Table table = new Table();

    // https://adventofcode.com/2015/day/13
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.load();
        main.printUniqueCombinations(main.list.toArray(),main.list.size(), new Object[8],0, new HashSet());
    }

    public int calculatePerPerson(Person p) {
        table = new Table();
        table.setPersonAtTable(p);

        Stack<Person> stack = new Stack<>();
        stack.push(p);

        while(IsAnyPersonUnseated(list) != null){
            Person unseatedPerson = getNextUnseatedPerson(list,p);
            stack.push(unseatedPerson);

            if (!table.isTableFull()) {
                table.setPersonAtTable(unseatedPerson);
            }

            if (table.isTableFull()) {
                return calculateCurrentArrangement(table);
            }
            p = stack.peek();
        }
        return calculateCurrentArrangement(table);
    }


    //WRONG why? its not the most liked seated person you want to know but bruteforce the next person.
    public Person getNextUnseatedPerson(List<Person> list, Person inputPerson) {
        //foreach person in the list compare your name with the most liked person.
        Person person = null;
        for (Person p: list){
            person = p;

            if(p.getName().equals(inputPerson.getName()) || p.isSeated()){
                continue;
            }

            int likeValue = p.getNeighbourHappinessByName(inputPerson.getName());
            System.out.println(p.getName() +" - Left "+ inputPerson.getName() + " "+ likeValue);
            int likeValue2 = inputPerson.getNeighbourHappinessByName(p.getName());
            System.out.println(inputPerson.getName() +" - Right "+ p.getName() + " "+ likeValue2);
            if(!p.isSeated()) {
                return person;
            }
        }
        return person;
    }

    private Person IsAnyPersonUnseated(List<Person> list){
        Optional<Person> findPerson =
                list.stream()
                        .filter(p -> !p.isSeated())
                        .findAny();
        return findPerson.orElse(null);
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

    public int calculateCurrentArrangement(Table t) {
        int currHappiness = t.calculateHappinessOfTable();
        if (currHappiness > maxHappiness) {
            maxHappiness = currHappiness;
        }
        return maxHappiness;
    }

    public void printUniqueCombinations(Object[] arr, int length, Object[] combination, int index, Set<String> set) {
        if (index == length) {
            String combinationString = Arrays.toString(combination);
            if (!set.contains(combinationString)) {
                set.add(combinationString);
                System.out.println(combinationString);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                combination[index] = arr[i];
                printUniqueCombinations(arr, length, combination, index + 1, set);
            }
        }
    }
}
