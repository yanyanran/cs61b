import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleGridTest {
    @Test
    public void testBasic() {
        int[][] grid = {{1, 1, 0},
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 1}};
        int[][] darts = {{0, 1}, {2, 0}};
        int[] expected = {0, 4};
        BubbleGrid sol = new BubbleGrid(grid);
        assertArrayEquals(expected, sol.popBubbles(darts));
    }

    @Test
    public void testBasic2() {
        int[][] grid2 = {{0, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 0}};
        int[][] darts2 = {{3, 0}};
        int[] expected2 = {0};
        BubbleGrid sol2 = new BubbleGrid(grid2);
        assertArrayEquals(expected2, sol2.popBubbles(darts2));
    }
}