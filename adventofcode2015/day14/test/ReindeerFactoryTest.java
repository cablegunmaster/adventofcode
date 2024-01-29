public class ReindeerFactoryTest {

    public static Reindeer getComet(){
        return new Reindeer("Comet","14","10","127");
    }

    public static Reindeer getDancer(){
        return new Reindeer("Dancer","16","11","162");
    }

    //Actual input test
    public static Reindeer getDancerActual() {
        return new Reindeer("Dancer", "27", "5", "132");
    }

    public static Reindeer getCupidActual() {
        return new Reindeer("Cupid", "22", "2", "41");
    }

    public static Reindeer getRudolphActual(){
        return new Reindeer("Rudolph", "11", "5", "48");
    }

    public static Reindeer getDonnerActual(){
        return new Reindeer("Donner", "28", "5", "134");
    }

    public static Reindeer getDasherActual(){
        return new Reindeer("Dasher", "4", "16", "55");
    }

    public static Reindeer getBlitzenActual(){
        return new Reindeer("Blitzen", "14", "3", "38");
    }

    public static Reindeer getPrancerActual(){
        return new Reindeer("Prancer", "3", "21", "40");
    }

    public static Reindeer getCometActual(){
        return new Reindeer("Comet", "18", "6", "103");
    }

    public static Reindeer getVixenActual(){
        return new Reindeer("Vixen", "18", "5", "84");
    }
}
