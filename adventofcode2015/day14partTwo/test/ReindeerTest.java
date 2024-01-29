import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReindeerTest {

    public Main main;

    @Before
    public void setUp() throws Exception {
        main = new Main();
    }

    @Test
    public void setUpComet(){
        Reindeer rd = ReindeerFactoryTest.getComet();
        Assert.assertEquals("Comet",rd.getName());
        Assert.assertEquals(14,rd.getSpeed());
        Assert.assertEquals(10,rd.getMaxFlyingTime());
        Assert.assertEquals(127,rd.getRestingTime());
        Assert.assertEquals(0,rd.getDistance());
        Assert.assertFalse(rd.isExhausted());
        Assert.assertFalse(rd.isRested());
    }

    @Test
    public void setUpDancer(){
        Reindeer rd = ReindeerFactoryTest.getDancer();
        Assert.assertEquals(rd.getName(),"Dancer");
        Assert.assertEquals(rd.getSpeed(),16);
        Assert.assertEquals(rd.getMaxFlyingTime(),11);
        Assert.assertEquals(rd.getRestingTime(),162);
        Assert.assertEquals(rd.getDistance(),0);
        Assert.assertFalse(rd.isExhausted());
        Assert.assertFalse(rd.isRested());
    }

    @Test
    public void cometAfterOneSecond(){
        Reindeer rd = ReindeerFactoryTest.getComet();
        List<Reindeer> list = new ArrayList<>();
        list.add(rd);

        main.calcRace(1, list);
        Assert.assertEquals(14, rd.getDistance());
    }

    @Test
    public void dancerAfterOneSecond(){
        Reindeer rd = ReindeerFactoryTest.getDancer();
        List<Reindeer> list = new ArrayList<>();
        list.add(rd);

        main.calcRace(1, list);

        Assert.assertEquals(16, rd.getDistance());
    }

    @Test
    public void bothReindeerAfterTenSeconds(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());
        list.add(ReindeerFactoryTest.getComet());

        main.calcRace(10, list);

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(160, list.get(0).getDistance());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertEquals(140, list.get(1).getDistance());
    }

    @Test
    public void cometBeginsResting11SecondIn(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getComet());

        main.calcRace(11, list);

        Assert.assertEquals("Comet", list.get(0).getName());
        Assert.assertEquals(140, list.get(0).getDistance());
        Assert.assertTrue(list.get(0).isResting());
    }

    @Test
    public void dancerContinuesOneMoreOn11Seconds(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());

        main.calcRace(11, list);

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(176, list.get(0).getDistance());
        Assert.assertTrue(list.get(0).isFlying());
    }

    @Test
    public void bothReindeerAfterTwelveSecondsRest() {
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());
        list.add(ReindeerFactoryTest.getComet());

        main.calcRace(12, list);

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(176, list.get(0).getDistance());
        Assert.assertTrue(list.get(0).isResting());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertTrue(list.get(1).isResting());
        Assert.assertEquals(140, list.get(1).getDistance());
    }

    @Test
    public void situationOn138SecondsTo148SecondsCometFlies10Seconds(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());
        list.add(ReindeerFactoryTest.getComet());

        main.calcRace(138, list);

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(176, list.get(0).getDistance());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertEquals(154, list.get(1).getDistance());

        //10 more seconds.
        main.calcRace(10, list);

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(176, list.get(0).getDistance());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertEquals(280, list.get(1).getDistance());

        main.calcRace(25, list);

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(176, list.get(0).getDistance());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertEquals(280, list.get(1).getDistance());

        main.calcRace(11, list);

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(352, list.get(0).getDistance());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertEquals(280, list.get(1).getDistance());
    }

    @Test
    public void SituationOn185Seconds(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());
        list.add(ReindeerFactoryTest.getComet());

        main.calcRace(185, list);

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(352, list.get(0).getDistance());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertEquals(280, list.get(1).getDistance());
    }

    @Test
    public void SituationOn1000Seconds(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());
        list.add(ReindeerFactoryTest.getComet());

        main.calcRace(1000, list);

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(1056, list.get(0).getDistance());
        Assert.assertTrue(list.get(0).isResting());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertEquals(1120, list.get(1).getDistance());
        Assert.assertTrue(list.get(1).isResting());
    }
}
