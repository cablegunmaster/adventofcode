import java.util.List;

public class Reindeer {

    private final int speed;
    private final String name;
    private int distance = 0;
    private int resting = 0;
    private int flying = 0;
    private int points;
    private final int maxFlyingTime;
    private final int maxRestingTime;
    private boolean isResting;

    public Reindeer(String name, String speed, String timeInAir, String restingTime) {
        this.name = name;
        this.speed = Integer.parseInt(speed);
        this.maxFlyingTime = Integer.parseInt(timeInAir);
        this.maxRestingTime = Integer.parseInt(restingTime);
        isResting = false;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxFlyingTime() {
        return maxFlyingTime;
    }

    public int getRestingTime() {
        return maxRestingTime;
    }

    public boolean isResting() {
        return isResting;
    }

    public boolean isFlying() {
        return !isResting;
    }

    public void setResting(boolean resting) {
        isResting = resting;
    }

    public void increaseDistance() {
        distance = distance + speed;
    }

    public boolean isExhausted() {
        if (flying > 0) {
            return flying >= maxFlyingTime;
        }
        return false;
    }

    public void increaseResting() {
        resting++;
    }

    public void increaseFlying() {
        flying++;
    }

    public void increasePoint() {
        points++;
    }

    public int getPoints() {
        return points;
    }

    public boolean isRested() {
        return resting == maxRestingTime;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void resetRestTime() {
        resting = 0;
    }

    public void resetFlyingTime() {
        flying = 0;
    }

    public boolean isEvenFastAs(List<Reindeer> fastest) {
        return fastest.stream().anyMatch(rd -> rd.getDistance() == this.getDistance());
    }

    public boolean isFasterAs(List<Reindeer> fastest) {
        return fastest.stream().noneMatch(rd -> rd.getDistance() >= this.getDistance());
    }
}
