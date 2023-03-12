import java.util.HashMap;
import java.util.Objects;

public class Person {

    private final String name;
    HashMap<String, Integer> neighbourHappiness = new HashMap<>();

    boolean isSeated = false;

    public Person(String name) {
        this.name = name;
    }

    public void setValueNeighbours(String name, int happiness) {
        this.neighbourHappiness.put(name,happiness);
    }

    public int getNeighbourHappinessByName(String name) {
        return neighbourHappiness.get(name);
    }

    public String getName() {
        return name;
    }

    public boolean isSeated() {
        return isSeated;
    }

    public void setSeated(boolean seated) {
        isSeated = seated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
