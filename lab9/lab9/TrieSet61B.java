package lab9;

import java.util.List;

public interface TrieSet61B {
    /** Clears all items out of Trie */
    void clear();

    /** 如果Trie包含KEY，则返回true，否则返回false */
    boolean contains(String key);

    /** Inserts string KEY into Trie */
    void add(String key);

    /** 返回以prefix开头的所有单词的列表 */
    List<String> keysWithPrefix(String prefix);

    /** 返回 Trie 中存在的最长 KEY 前缀 实验 9 不需要。如果不实现此功能，则抛出 UnsupportedOperationException。*/
    String longestPrefixOf(String key);
}