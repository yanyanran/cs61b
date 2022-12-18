import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        //org.junit.Assert.assertArrayEquals(expected, input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input, 0);
        org.junit.Assert.assertEquals(expected, actual);

        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 1;

        int actual2 = Sort.findSmallest(input2, 0   );
        assertEquals(expected2, actual2);
    }

    @Test
    /** Test the Sort.swap method. */
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }

    // Better JUnit--
    // Remove our main method from the TestSort class.
/*    public static void main(String[] args) {
        testSort();
        testFindSmallest();
        testSwap();
    }*/
}