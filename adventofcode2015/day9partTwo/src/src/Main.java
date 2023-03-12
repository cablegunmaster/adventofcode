import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    HashSet<Location> list = new HashSet<>();

    Main() {}

    // https://adventofcode.com/2015/day9partTwo
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.load();
        System.out.println(main.getDistance());
    }

    private void load() throws IOException {
        File file = new File("F:\\development\\adventofcode\\src\\adventofcode2015\\day9partTwo\\input.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            Location.LocationBuilder locationBuilder = new Location.LocationBuilder().inputA(st);
            setLocation(locationBuilder);
            Location.LocationBuilder locationBuilder2 = new Location.LocationBuilder().inputB(st);
            setLocation(locationBuilder2);
        }
    }

    public int getDistance(){
        boolean notAllVisited = true;
        Stack<Location> stack = new Stack<>();

        int longestDistance = -1;
        int currDistance = 0;
        while(notAllVisited){

            for (Location location : list) {
                stack.push(location);
            }

            while(!stack.empty()){
                setAllLocationsUnvisited();
                currDistance = checkDistance(stack.pop(), 0);
                if(currDistance >= longestDistance){
                    longestDistance = currDistance;
                }
            }

            if(stack.isEmpty()){
                notAllVisited = false;
            }
        }
        return longestDistance;
    }

    public int checkDistance(Location location, int distance){
        setLocationVisited(location);

        List<Location> unvisitedLocations = getByLocationUnvisited(location.getCity());
        Integer longestDistance = null;
        Location shortestLocation = null;
        for (Location unvisited : unvisitedLocations) {
            Integer amountOfDistance  = location.getLocationDistance().get(unvisited.getCity());
            if(longestDistance == null || amountOfDistance > longestDistance){
                longestDistance = amountOfDistance;
                shortestLocation = unvisited;
            }
        }

        if(getByLocationUnvisited(location.getCity()).size() != 0) {
            distance = checkDistance(shortestLocation, getDistanceLocationToUnvisitedLocation(location, shortestLocation)) + distance;
        }
        return distance;
    }

    private int getDistanceLocationToUnvisitedLocation(Location location, Location l) {
        Optional<Location> city = getByLocation(location.getCity());
        if(city.isPresent()) {
            return city.get().getLocationDistance().get(l.getCity());
        }else {
            return -100;
        }
    }

    private void setLocationVisited(Location location) {
        list.stream()
                .filter(loc-> loc.getCity().equals(location.getCity()))
                .forEach(loc -> loc.setVisited(true));
    }


    private Optional<Location> getByLocation(String city) {
        return list.stream()
                .filter(a -> a.getCity().equals(city))
                .findFirst();
    }

    private void setAllLocationsUnvisited() {
        list.forEach(a -> a.setVisited(false));
    }


    private List<Location> getByLocationUnvisited(String city) {
        return list.stream()
                .filter(a -> !a.isVisited())
                .collect(Collectors.toList());
    }

    private Boolean containsLocation(String name){
        boolean isFound = false;
        for (Location l : list) {
            isFound = l.getCity().equals(name);
            if(isFound){
                break;
            }
        }
        return isFound;
    }

    void setLocation(Location.LocationBuilder locationBuilder){
        boolean locationFound = containsLocation(locationBuilder.getCity());
        Location location = locationBuilder.build();
        if(locationFound){
            Optional<Location> city = getByLocation(locationBuilder.getCity());

            if(city.isPresent()){
                location= city.get();
                location.getLocationDistance().put(locationBuilder.getPlace(),locationBuilder.getDistance());
                list.remove(location);
            }
        }
        list.add(location);
    }
}
