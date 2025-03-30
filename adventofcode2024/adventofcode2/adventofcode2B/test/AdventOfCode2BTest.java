import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdventOfCode2BTest {

    AdventOfCode2B app;

    @BeforeEach
    public void setup(){
        app = new AdventOfCode2B();
    }

    @Test
    public void testArray_ExpectsToBeUnsafeWithTwoNumbers() {
        int [] list = new int[]{ 1, 9 };
        Assertions.assertFalse(app.calcisSafe(list, app));
    }

    @Test
    public void testArray_ExpectsToBeUnsafeWithThreeNumbers() {
        int [] list = new int[]{ 1, 9, 5};
        Assertions.assertFalse(app.calcisSafe(list, app));
    }

    @Test
    public void testArray_ExpectsToReturnUnsafeEnding() {
        int [] list = new int[]{ 16, 17, 18, 21, 23, 24, 120, 24 };
        Assertions.assertFalse(app.calcisSafe(list,app));
    }

    @Test
    public void testArray_ExpectsToReturnsafeWith1RandomNumberTrue() {
        int [] list = new int[]{ 16, 17, 18, 120, 21, 24, 25, 27 };
        Assertions.assertTrue(app.checkWithDampener(list, app));
    }

    @Test
    public void testArray_ExpectsToReturnSafeAsTrue() {
        int [] list = new int[]{  24, 24 };
         Assertions.assertFalse(app.calcisSafe(list,app));
    }

    @Test
    public void testArray_ExpectsToBeUnsafeHasTwoUnsafeMoments() {
        int [] list = new int[]{ 1, 2, 7, 8, 9 };
        Assertions.assertFalse(app.calcisSafe(list,app));
    }

    @Test
    public void testArray_ExpectsToBeUnsafeHasTwoUnsafeAtTheEnd() {
        AdventOfCode2B app = new AdventOfCode2B();
        int [] list = new int[]{ 1, 2, 7, 8 };
        Assertions.assertFalse(app.calcisSafe(list,app));
    }

    @Test
    public void testArray_ExpectsToBeUnsafeHasTwoUnsafeIrregular() {
        int [] list = new int[]{ 1, 2, 7, 5, 6, 10, 8 };
        Assertions.assertFalse(app.calcisSafe(list,app));
    }

    @Test
    public void testArray_ExpectsToBeUnsafeHasOneUnsafeIrregularUpwards() {
        int [] list = new int[]{ 1, 2, 7, 5 };
        app.calcisSafe(list,app);
        list = app.remove(list, 2);

        Assertions.assertEquals(1, list[0]);
        Assertions.assertEquals(2, list[1]);
        Assertions.assertEquals(5, list[2]);

        Assertions.assertTrue(app.calcisSafe(list, app));
    }

    @Test
    public void testArray_ExpectsToBeUnsafeHasOneUnsafeIrregularDownwards() {
        int [] list = new int[]{ 7, 5, 1, 2 };
        app.calcisSafe(list,app);
        list = app.remove(list, 2); //index to remove.

        Assertions.assertEquals(7, list[0]);
        Assertions.assertEquals(5, list[1]);
        Assertions.assertEquals(2, list[2]);

        Assertions.assertTrue(app.calcisSafe(list, app));
    }

    @Test
    public void testArray_ExpectsToBeUnsafeHasMultipleUnsafeIrregular() {
        int [] list  = new int[]{ 1, 2, 7, 8, 9}; // 2,7
        int [] list2 = new int[]{ 9, 7, 6, 2, 1}; // 6,2
        int [] list3 = new int[]{ 6, 2, 1};       // 6,2
        int [] list4 = new int[]{ 2, 7, 8};       // 2,7

        Assertions.assertFalse(app.calcisSafe(list,app));
        app.disableDampener();
        Assertions.assertFalse(app.calcisSafe(list2,app));
        app.disableDampener();
        Assertions.assertFalse(app.calcisSafe(list3, app));
        app.disableDampener();
        Assertions.assertFalse(app.calcisSafe(list4, app));
    }

    @Test
    public void testArray_ExpectsToBeUnSafe_MultipleUpsAndDowns() {
        int [] list = new int[]{ 9, 12, 9, 11, 14, 16, 17, 20}; // 12, 9 , 11 removal of 9 and  11 is too many.
        Assertions.assertFalse(app.checkWithDampener(list, app));
    }

    @Test
    public void testArray_ExpectsToBeUnsafeHasMultipleUnsafeIrregularRegardingWhichLevel() {
        int [] list  = new int[]{ 1, 2, 7, 8, 9}; // 2,7
        int [] list2 = new int[]{ 9, 7, 6, 2, 1}; // 6,2

        app.disableDampener();

        Assertions.assertFalse(app.checkWithDampener(list,app));
        Assertions.assertFalse(app.checkWithDampener(list2,app));
    }

    @Test
    public void testArray_ExpectsTestInput() {
        int [] list  = new int[]{ 7, 6, 4, 2, 1}; //safe
        int [] list2 = new int[]{ 1, 3, 2, 4, 5}; //safe by removing one.
        int [] list3 = new int[]{ 8, 6, 4, 4, 1}; //safe by removing one.
        int [] list4 = new int[]{ 1, 3, 6, 7, 9}; //safe without removal
        Assertions.assertTrue(app.calcisSafe(list, app));
        Assertions.assertTrue(app.checkWithDampener(list2, app));
        Assertions.assertFalse(app.calcisSafe(list3, app));
        Assertions.assertTrue(app.checkWithDampener(list3, app));
        Assertions.assertTrue(app.calcisSafe(list4, app));
    }

    @Test
    public void testArray_ExpectsTestInputBeFalseSinceTwoErrors(){
        //double error going down and 5 difference.
        int [] list = new int[]{ 83, 85, 88, 91, 90, 96 };
        Assertions.assertFalse(app.checkWithDampener(list, app));
    }


    @Test
    public void testArray_ExpectsTestInputBeFalseSinceTwoTimesFoundErrors(){
        int[] list = new int[] {65, 68, 66, 67, 69, 70, 73, 72 }; //68 and 72 is wrong.
        Assertions.assertFalse(app.checkWithDampener(list, app));
    }

    @Test
    public void testArray_ExpectsTestInputBeFalseSinceMultipleTimesFoundErrors(){
        //[68, 72, 73, 75, 77]isSafe: true als de beginwaarde is weggehaald.
        int[] list = new int[] { 68, 72, 73, 75, 77 };
        Assertions.assertTrue(app.checkWithDampener(list, app));
    }

}