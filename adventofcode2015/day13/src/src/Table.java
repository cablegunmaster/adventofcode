public class Table {

    public int totalHappiness = 0;
    public Person[] peopleAtTable = new Person[4];

    public int MOST_LEFT_SIDE = 0;
    public int MOST_RIGHT_SIDE = peopleAtTable.length;

    public Table() {}

    public int calculateHappinessOfTable(){
        int totalHappiness = 0;
        for (int i = 0; i < peopleAtTable.length; i++) {
            Person currentSeat = peopleAtTable[i];
            addToHappiness(getLeftPersonHappiness(i,currentSeat));
            addToHappiness(getRightPersonHappiness(i, currentSeat));
        }
        return totalHappiness;
    }

    private void addToHappiness(int happiness){
        totalHappiness = totalHappiness + happiness;
    }
    private int getLeftPersonHappiness(int tableLocation, Person currentSeat) {
        //most left Location.
        int happiness = 0;
        if(tableLocation == MOST_LEFT_SIDE){
            Person leftSidePerson = peopleAtTable[peopleAtTable.length -1];
            happiness = happiness + leftSidePerson.getNeighbourHappinessByName(currentSeat.getName());
            happiness = happiness + currentSeat.getNeighbourHappinessByName(leftSidePerson.getName());
        }else{
            Person leftSidePerson = peopleAtTable[tableLocation - 1];
            happiness = happiness + leftSidePerson.getNeighbourHappinessByName(currentSeat.getName());
            happiness = happiness + currentSeat.getNeighbourHappinessByName(leftSidePerson.getName());
        }
        return happiness;
    }

    private int getRightPersonHappiness(int tableLocation, Person currentSeat) {
        //most Right Location.
        int happiness = 0;
        if(tableLocation == MOST_RIGHT_SIDE){
            Person rightSidePerson = peopleAtTable[0];
            happiness = happiness + rightSidePerson.getNeighbourHappinessByName(currentSeat.getName());
            happiness = happiness + currentSeat.getNeighbourHappinessByName(rightSidePerson.getName());
        }else{
            Person rightSidePerson = peopleAtTable[tableLocation + 1];
            happiness = happiness + rightSidePerson.getNeighbourHappinessByName(currentSeat.getName());
            happiness = happiness + currentSeat.getNeighbourHappinessByName(rightSidePerson.getName());
        }
        return happiness;
    }
}
