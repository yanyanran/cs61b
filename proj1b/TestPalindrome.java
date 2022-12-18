import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void TestIsPalindrome() {
        // TODO
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("dogissocute"));
        assertFalse(palindrome.isPalindrome("gtyissocute"));
        assertTrue(palindrome.isPalindrome("racecar"));
        // 任何长度为 1 或 0 的单词都是回文
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("ababssba"));
        assertTrue(palindrome.isPalindrome(""));
    }
}
