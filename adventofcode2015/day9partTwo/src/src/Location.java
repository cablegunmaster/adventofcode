import java.util.HashMap;

class Location {

    private String city;
    private HashMap<String, Integer> locationDistance;
    private boolean isVisited = false;

    private Location(LocationBuilder builder) {
        this.city = builder.city;
        this.locationDistance = builder.locationDistance;
    }

    String getCity() {
        return city;
    }

    HashMap<String, Integer> getLocationDistance() {
        return locationDistance;
    }

    boolean isVisited() {
        return isVisited;
    }

    void setVisited(boolean visited) {
        isVisited = visited;
    }

    static class LocationBuilder {
        private String city;
        private String place;
        private int distance;

        private HashMap<String, Integer> locationDistance = new HashMap<>();

        public LocationBuilder inputA(String input){
            String[] in = input.split(" ");
            city(in[0]);
            place(in[2]);
            distance(Integer.parseInt(in[4]));
            addLocation(place, distance);
            return this;
        }

        public LocationBuilder inputB(String input){
            String[] in = input.split(" ");
            city(in[2]);
            place(in[0]);
            distance(Integer.parseInt(in[4]));
            addLocation(place, distance);
            return this;
        }

        public LocationBuilder city(String city) {
            this.city = city;
            return this;
        }

        public LocationBuilder place(String place) {
            this.place = place;
            return this;
        }

        public LocationBuilder distance(Integer distance) {
            this.distance = distance;
            return this;
        }

        public LocationBuilder addLocation(String location, int distance) {
            locationDistance.put(location, distance);
            return this;
        }

        public String getCity() {
            return city;
        }

        public String getPlace() {
            return place;
        }

        public int getDistance() {
            return distance;
        }

        public Location build() {
            return new Location(this);
        }
    }
}
