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
        Deque<Character> AD = wordToDeque(word);
        int size = AD.size();
        while (size > 1) {
/*            System.out.println(AD.get(0));
            System.out.println(AD.get(size - 1));*/
            if (AD.get(0) != AD.get(size - 1)) {
                return false;
            }
            size -= 2;
            AD.removeFirst();
            AD.removeLast();
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> AD = wordToDeque(word);
        int size = AD.size();
        while (size > 1) {
            if (!cc.equalChars(AD.get(0),AD.get(size - 1))) {
                return false;
            }
            size -= 2;
            AD.removeFirst();
            AD.removeLast();
        }
        return true;
    }
}
