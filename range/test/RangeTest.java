package range.test;
import static org.junit.Assert.*;
import org.junit.Test;
import range.example.InvalidRangeArgumentException;
import range.example.Range;

public class RangeTest {
    @Test(expected = InvalidRangeArgumentException.class)
    public void invalidRange() {
        String input = "2,5";
        new Range(input);
    }

    @Test
    public void StartAndEndShouldHaveInclusive() throws Exception {
        String input = "[2,5]";
        Range range = new Range(input);
        assertTrue(range.isInclusiveStart());
        assertTrue(range.isInclusiveEnd());
    }

    @Test
    public void StartAndEndShouldHaveExclusive() throws Exception {
        String input = "(2,5)";
        Range range = new Range(input);
        assertFalse(range.isInclusiveStart());
        assertFalse(range.isInclusiveEnd());
    }

    @Test
    public void ForInclusiveTwoAndFiveShouldStartWithTwoAndEndWithFive() throws Exception {
        String input = "[2,5]";
        Range range = new Range(input);
        assertEquals(2, range.getStart());
        assertEquals(5, range.getEnd());
    }

    @Test
    public void ForExclusiveTwoAndFiveShouldStartWithThreeAndEndWithFour() throws Exception {
        String input = "(2,5)";
        Range range = new Range(input);
        assertEquals(3, range.getStart());
        assertEquals(4, range.getEnd());
    }

    @Test
    public void getResultFromInclusiveTwoAndFiveshouldShowNumberTwoToFive() throws Exception {
        int[] expectedResult = {2, 3, 4, 5};
        String input = "[2,5]";
        Range range = new Range(input);
        assertArrayEquals(expectedResult, range.getResult());
    }

    @Test
    public void getResultFromExclusiveTwoAndFiveshouldShowNumberThreeToFour() throws Exception {
        int[] expectedResult = {3, 4};
        String input = "(2,5)";
        Range range = new Range(input);
        assertArrayEquals(expectedResult, range.getResult());
    }

    @Test
    public void getResultFromInclusiveTwoAndExclusiveFiveShouldShowNumberTwoToFour() throws Exception {
        int[] expectedResult = {2, 3, 4};
        String input = "[2,5)";
        Range range = new Range(input);
        assertArrayEquals(expectedResult, range.getResult());
    }

    @Test
    public void getResultFromExclusiveTwoAndInclusiveFiveShouldShowNumberThreeToFive() throws Exception {
        int[] expectedResult = {3, 4, 5};
        String input = "(2,5]";
        Range range = new Range(input);
        assertArrayEquals(expectedResult, range.getResult());
    }
}
