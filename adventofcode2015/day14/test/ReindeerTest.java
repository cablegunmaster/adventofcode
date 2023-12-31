import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReindeerTest {

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
    public void cometAfterOneSecond(){
        Reindeer rd = ReindeerFactoryTest.getComet();
        rd.increaseDistance();
        Assert.assertEquals(14, rd.getDistance());
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
    public void dancerAfterOneSecond(){
        Reindeer rd = ReindeerFactoryTest.getDancer();
        rd.increaseDistance();
        Assert.assertEquals(16, rd.getDistance());
    }

    @Test
    public void bothReindeerAfterTenSeconds(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());
        list.add(ReindeerFactoryTest.getComet());

        for (int i = 1; i <= 10; i++) {
            for (Reindeer rd: list) {
                rd.increaseDistance();
            }
        }

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(160, list.get(0).getDistance());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertEquals(140, list.get(1).getDistance());
    }

    @Test
    public void cometBeginsResting11SecondIn(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getComet());

        for (int i = 1; i <= 11; i++) {
            for (Reindeer rd: list) {
                if (rd.isFlying()) {
                    if (rd.isExhausted()) {
                        rd.setResting(true);
                    } else {
                        rd.increaseDistance();
                        rd.increaseFlying();
                    }
                }
            }
        }

        Assert.assertEquals("Comet", list.get(0).getName());
        Assert.assertEquals(140, list.get(0).getDistance());
    }

    @Test
    public void dancerContinuesOneMoreOn11Seconds(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());

        for (int i = 1; i <= 11; i++) {
            for (Reindeer rd: list) {
                if (rd.isFlying()) {
                    if (rd.isExhausted()) {
                        rd.setResting(true);
                    } else {
                        rd.increaseDistance();
                        rd.increaseFlying();
                    }
                }
            }
        }

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(176, list.get(0).getDistance());
    }

    @Test
    public void bothReindeerAfterTwelveSecondsRest() {
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());
        list.add(ReindeerFactoryTest.getComet());

        for (int i = 1; i <= 12; i++) {
            for (Reindeer rd: list) {
                if (rd.isFlying()) {
                    if (rd.isExhausted()) {
                        rd.setResting(true);
                    } else {
                        rd.increaseDistance();
                        rd.increaseFlying();
                    }
                }
            }
        }

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertTrue(list.get(0).isResting());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertTrue(list.get(1).isResting());
    }

    @Test
    public void SituationOn138Seconds(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());
        list.add(ReindeerFactoryTest.getComet());

        for (int i = 1; i <= 148; i++) {
            for (Reindeer rd: list) {
                if (rd.isFlying()) {
                    if (rd.isExhausted()) {
                        rd.setResting(true);
                    } else {
                        rd.increaseDistance();
                        rd.increaseFlying();
                    }
                } else if (rd.isResting()) {
                    rd.increaseResting();
                    if (rd.isRested()) {
                        rd.setResting(false);
                        rd.resetRestTime();
                        rd.resetFlyingTime();
                    }
                }
            }
        }

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(176, list.get(0).getDistance());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertEquals(280, list.get(1).getDistance());
    }

    @Test
    public void SituationOn185Seconds(){
        List<Reindeer> list = new ArrayList<>();
        list.add(ReindeerFactoryTest.getDancer());
        list.add(ReindeerFactoryTest.getComet());

        for (int i = 1; i <= 185; i++) {
            for (Reindeer rd: list) {
                if (rd.isFlying()) {
                    if (rd.isExhausted()) {
                        rd.setResting(true);
                    } else {
                        rd.increaseDistance();
                        rd.increaseFlying();
                    }
                } else if (rd.isResting()) {
                    rd.increaseResting();
                    if (rd.isRested()) {
                        rd.setResting(false);
                        rd.resetRestTime();
                        rd.resetFlyingTime();
                    }
                }
            }
        }

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

        for (int i = 1; i <= 1000; i++) {
            for (Reindeer rd: list) {
                if (rd.isFlying()) {
                    if (rd.isExhausted()) {
                        rd.setResting(true);
                    } else {
                        rd.increaseDistance();
                        rd.increaseFlying();
                    }
                } else if (rd.isResting()) {
                    rd.increaseResting();
                    if (rd.isRested()) {
                        rd.setResting(false);
                        rd.resetRestTime();
                        rd.resetFlyingTime();
                    }
                }
            }
        }

        Assert.assertEquals("Dancer", list.get(0).getName());
        Assert.assertEquals(1056, list.get(0).getDistance());
        Assert.assertEquals("Comet", list.get(1).getName());
        Assert.assertEquals(1120, list.get(1).getDistance());
    }
}
