import org.junit.Test;
import static org.junit.Assert.*;

public class RabinKarpAlgorithmTests {
    @Test
    public void basic() {
        String input = "hello";
        String pattern = "ello";
        assertEquals(1, RabinKarpAlgorithm.rabinKarp(input, pattern));
    }

    @Test
    public void longerStrings() {
        String input = "americanwarrior";
        String pattern = "icanwa";
        assertEquals(4, RabinKarpAlgorithm.rabinKarp(input, pattern));
    }

    @Test
    public void testHashPattern() {
        String input = "abc";
        assertEquals(285, RabinKarpAlgorithm.hashPattern(input));
    }
}