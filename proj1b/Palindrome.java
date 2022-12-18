/**
 * 回文操作类
 * */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> AD = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            AD.addLast(word.charAt(i));
        }
        return AD;
    }

    // 判断回文
    public boolean isPalindrome(String word) {
        return true;
    }
}