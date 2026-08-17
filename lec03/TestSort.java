import static org.junit.Assert.*;
import org.junit.Test;

public class TestSort {
    @Test
    public void testSwap() {
        String[] input = { "cows", "dewll", "above", "clouds" };
        String[] expected = { "dewll", "cows", "above", "clouds" };
        SelectionSort.swap(input, 0, 1);
        org.junit.Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
        String[] input = { "cows", "dewll", "above", "clouds" };
        int expected = 2;
        int actual = SelectionSort.findSmallest (input, 0);
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSort() {
        String[] input = { "cows", "dewll", "above", "clouds" };
        String[] expected = { "above", "clouds", "cows", "dewll" };
        SelectionSort.sort(input, 0);
        org.junit.Assert.assertArrayEquals(expected, input);
    }
}
